package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.QuizDTO;
import entities.*;
import errorhandling.NotFoundException;
import facades.ContinentFacade;
import facades.CountryFacade;
import facades.QuizFacade;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.*;
import populators.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

import static io.restassured.RestAssured.given;
import static java.lang.Math.toIntExact;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class QuizResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";

    private static QuizDTO testQuiz;
    private static User testUser;
    private static Country testCountry, correctCountry, wrongCountry;
    private static Continent testContinent;

    private static CountryFacade countryFacade;
    private static ContinentFacade continentFacade;
    private static QuizFacade quizFacade;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() throws NotFoundException, IOException {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();



        EntityManager em = emf.createEntityManager();

        //populate
        ContinentPopulator.populateContinents(emf);
        CountryPopulator.populateCountries(emf);
        RolePopulator.populateRoles(emf);


        countryFacade = CountryFacade.getFacade(emf);
        continentFacade = ContinentFacade.getFacade(emf);
        quizFacade = QuizFacade.getFacade(emf);


        testContinent = continentFacade.getByName("Europe");
        correctCountry = countryFacade.getByName("Sweden");
        wrongCountry = countryFacade.getByName("Norway");
        testCountry = countryFacade.getByName("Denmark");
        testUser = new User("Peter", "12345", testCountry);



        try {
            em.getTransaction().begin();
            em.persist(testUser);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        testQuiz = getTestQuiz();

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;


    }

    public static QuizDTO getTestQuiz() throws NotFoundException {
        Quiz quiz = quizFacade.generateQuiz(testContinent.getContinentName(), testUser.getUserName());

        quiz.setTotalCorrect(20L);
        quiz.setTotalIncorrect(0L);
        quiz.setTotalPoints(10000L);

        for (Question question : quiz.getQuestions() ) {
            question.setPoints(500L);
        }

        quiz.setContinent(testContinent);
        quiz.setUser(testUser);

        return new QuizDTO(quiz);
    }


    @AfterAll
    public static void closeTestServer() {
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();

        httpServer.shutdownNow();
    }

    @Test
    void testServerIsUp() {
        given()
                .when()
                .get("/quiz/ping")
                .then()
                .statusCode(200);
    }

    @Test
    void generate() {
        given()
                .contentType("application/json")
                .when()
                .get("/quiz/generate/" + testContinent.getContinentName() + "/" + testUser.getUserName())
                .then()
                .assertThat()
                .statusCode(200)
                .body("totalPoints", equalTo(0))
                .body("totalCorrect", equalTo(0))
                .body("totalIncorrect", equalTo(0))
                .body("questions", hasItem(hasEntry("points", 0)))
                .body("questions", hasSize(20));
    }

    @Test
    void getCorrectAnswerResult() {
        String responseString =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/quiz/result/" + correctCountry.getId() + "/Sweden/8")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .asString();

        assertEquals(responseString, "800");
    }

    @Test
    void getWrongAnswerResult() {
        String responseString =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/quiz/result/" + wrongCountry.getId() + "/Sweden/8")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .asString();

        assertEquals(responseString, "0");
    }

    @Test
    void endQuiz() {

        String requestBody = GSON.toJson(testQuiz);

        Integer expected = toIntExact(testQuiz.getTotalPoints());

        given()
                .header("Content-type", ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/quiz/create")
                .then()
                .assertThat()
                .statusCode(200)
                .body("totalPoints", equalTo(expected))
                .body("username", equalTo(testUser.getUserName()))
                .body("questions", hasSize(20));

    }
}