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
import java.util.ArrayList;
import java.util.List;

public class CountryPopulator {

    public static void main(String[] args) throws NotFoundException, IOException {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        populateCountries(emf);
    }

    public static void populateCountries(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent europe = ContinentFacade.getFacade(emf).getByName("Europe");

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
        Country bulgaria = new Country("Bulgaria", europe, "100");
        Country finland = new Country("Finland", europe, "246");
        Country slovakia = new Country("Slovakia", europe, "703");
        Country ireland = new Country("Ireland", europe, "372");
        Country croatia = new Country("Croatia", europe, "191");
        Country moldova = new Country("Moldova", europe, "498");
        Country bosnia = new Country("Bosnia & Herz.", europe, "070");
        Country albania = new Country("Albania", europe, "008");
        Country lithuania = new Country("Lithuania", europe, "440");
        Country northMacedonia = new Country("North Macedonia", europe, "807");
        Country slovenia = new Country("Slovenia", europe, "705");
        Country latvia = new Country("Latvia", europe, "428");
        Country estonia = new Country("Estonia", europe, "233");
        Country montenegro = new Country("Montenegro", europe, "499");
        Country luxembourg = new Country("Luxembourg", europe, "442");
        Country malta = new Country("Malta", europe, "470");
        Country iceland = new Country("Iceland", europe, "352");
        Country andorra = new Country("Andorra", europe, "020");
        Country monaco = new Country("Monaco", europe, "492");
        Country liechtenstein = new Country("Liechtenstein", europe, "438");
        Country sanMarino = new Country("San Marino", europe, "674");



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
            em.persist(bulgaria);
            em.persist(finland);
            em.persist(slovakia);
            em.persist(finland);
            em.persist(ireland);
            em.persist(croatia);
            em.persist(moldova);
            em.persist(bosnia);
            em.persist(albania);
            em.persist(lithuania);
            em.persist(northMacedonia);
            em.persist(slovenia);
            em.persist(latvia);
            em.persist(estonia);
            em.persist(montenegro);
            em.persist(luxembourg);
            em.persist(malta);
            em.persist(iceland);
            em.persist(andorra);
            em.persist(monaco);
            em.persist(liechtenstein);
            em.persist(sanMarino);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
