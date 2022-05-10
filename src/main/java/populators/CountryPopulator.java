package populators;

import entities.Continent;
import entities.Country;
import errorhandling.NotFoundException;
import facades.ContinentFacade;
import facades.CountryFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;

public class CountryPopulator {

    public static void main(String[] args) throws NotFoundException, IOException {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        populateCountries(emf);
    }

    public static void populateCountries(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent europe = ContinentFacade.getFacade(emf).getByName("Europe");
        CountryFacade facade = CountryFacade.getFacade(emf);

        Country germany = new Country("Germany", europe, "276");
        Country gb = new Country("Great Britain", europe, "826");
        Country france = new Country("France", europe, "250");
        Country italy = new Country("Italy", europe, "380");
        Country spain = new Country("Spain", europe, "724");
        Country ukraine = new Country("Ukraine", europe, "804");
        Country russia = new Country("Russia", europe, "643");
        Country poland = new Country("Poland", europe, "616");
        Country romania = new Country("Romania", europe, "642");
        Country netherlands = new Country("Netherlands", europe, "528");
        Country belgium = new Country("Belgium", europe, "056");
        Country greece = new Country("Greece", europe, "300");
        Country portugal = new Country("Portugal", europe, "620");
        Country sweden = new Country("Sweden", europe, "752");
        Country hungary = new Country("Hungary", europe, "348");
        Country belarus = new Country("Belarus", europe, "112");
        Country austria = new Country("Austria", europe, "040");
        Country serbia = new Country("Serbia", europe, "688");
        Country switzerland = new Country("Switzerland", europe, "756");
        Country denmark = new Country("Denmark", europe, "208");
        Country norway = new Country("Norway", europe, "578");

        try {
            em.getTransaction().begin();
            em.persist(germany);
            em.persist(gb);
            em.persist(france);
            em.persist(italy);
            em.persist(spain);
            em.persist(ukraine);
            em.persist(russia);
            em.persist(poland);
            em.persist(romania);
            em.persist(netherlands);
            em.persist(belgium);
            em.persist(greece);
            em.persist(portugal);
            em.persist(sweden);
            em.persist(hungary);
            em.persist(belarus);
            em.persist(austria);
            em.persist(serbia);
            em.persist(switzerland);
            em.persist(denmark);
            em.persist(norway);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
