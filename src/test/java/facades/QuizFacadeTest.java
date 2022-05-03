package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Continent;
import entities.Country;
import entities.Quiz;
import entities.User;
import errorhandling.NotFoundException;
import org.junit.jupiter.api.*;
import populators.ContinentPopulator;
import populators.CountryPopulator;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class QuizFacadeTest {

    private static EntityManagerFactory emf;
    private static QuizFacade facade;
    private List<Continent> continents = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();
    private User user;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = QuizFacade.getFacade(emf);
    }

    @BeforeEach
    void setUp() throws NotFoundException, IOException {
        ResetDB.truncate(emf);

        ContinentPopulator.populateContinents(emf);
        continents = ContinentFacade.getFacade(emf).getAll();
        CountryPopulator.populateCountries(emf);
        countries = CountryFacade.getFacade(emf).getAll();

        user = new User("user", "test", countries.get(1));

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void cleanup() {
    }

    @Test
    void generateQuiz() throws NotFoundException {
        System.out.println("CONTINENTS SIZE = "+ continents.size());
        System.out.println("COUNTRY SIZE = "+ countries.size());
        Quiz quiz = facade.generateQuiz("Europe", "user");
        System.out.println(GSON.toJson(quiz));
    }
}