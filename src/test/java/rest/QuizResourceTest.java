package rest;

import entities.Continent;
import entities.Country;
import entities.Quiz;
import entities.User;
import errorhandling.NotFoundException;
import facades.ContinentFacade;
import facades.CountryFacade;
import io.restassured.RestAssured;
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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
class QuizResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api/quiz";
    private static Quiz testQuiz;
    private static User testUser;
    private static Country testCountry;
    private static Continent testContinent;

    private static CountryFacade countryFacade;
    private static ContinentFacade continentFacade;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() throws NotFoundException, IOException {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        countryFacade = CountryFacade.getFacade(emf);
        continentFacade = ContinentFacade.getFacade(emf);

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;

        //populate
        ContinentPopulator.populateContinents(emf);
        CountryPopulator.populateCountries(emf);
        RolePopulator.populateRoles(emf);
    }

    @BeforeEach
    public void setUp() throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        testContinent = continentFacade.getByName("Europe");
        testCountry = countryFacade.getByName("Denmark");
        testUser = new User("Peter", "12345", testCountry);

        try {
            em.getTransaction().begin();
            em.persist(testUser);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

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
                .get("/ping")
                .then()
                .statusCode(200);
    }

    @Test
    void generate() {
        given()
                .contentType("application/json")
                .when()
                .get("/generate/" + testContinent.getContinentName() + "/" + testUser.getUserName())
                .then()
                .assertThat()
                .statusCode(200)
                .body("totalPoints", equalTo(0));

    }

    @Test
    void getResult() {
    }
}