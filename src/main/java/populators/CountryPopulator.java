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

        Country germany = new Country("Germany", europe, facade.getSVG("germany"));
        Country gb = new Country("Great Britain", europe, facade.getSVG("gb"));
        Country france = new Country("France", europe, facade.getSVG("france"));
        Country italy = new Country("Italy", europe, facade.getSVG("italy"));
        Country spain = new Country("Spain", europe, facade.getSVG("spain"));
        Country ukraine = new Country("Ukraine", europe, facade.getSVG("ukraine"));
        Country russia = new Country("Russia", europe, facade.getSVG("russian%20federation"));
        Country poland = new Country("Poland", europe, facade.getSVG("poland"));
        Country romania = new Country("Romania", europe, facade.getSVG("romania"));
        Country netherlands = new Country("Netherlands", europe, facade.getSVG("netherlands"));
        Country belgium = new Country("Belgium", europe, facade.getSVG("belgium"));
        Country greece = new Country("Greece", europe, facade.getSVG("greece"));
        Country portugal = new Country("Portugal", europe, facade.getSVG("portugal"));
        Country sweden = new Country("Sweden", europe, facade.getSVG("sweden"));
        Country hungary = new Country("Hungary", europe, facade.getSVG("hungary"));
        Country belarus = new Country("Belarus", europe, facade.getSVG("belarus"));
        Country austria = new Country("Austria", europe, facade.getSVG("austria"));
        Country serbia = new Country("Serbia", europe, facade.getSVG("serbia"));
        Country switzerland = new Country("Switzerland", europe, facade.getSVG("switzerland"));
        Country denmark = new Country("Denmark", europe, facade.getSVG("denmark"));
        Country norway = new Country("Norway", europe, facade.getSVG("norway"));

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
