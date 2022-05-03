package populators;

import entities.Continent;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ContinentPopulator {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//        em.createNamedQuery("Continent.deleteAllRows").executeUpdate();
        populateContinents(emf);
    }

    public static void populateContinents(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        Continent australia = new Continent("Australia");
        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent southAmerica = new Continent("South America");

        try {
            em.getTransaction().begin();
            em.persist(africa);
            em.persist(asia);
            em.persist(australia);
            em.persist(europe);
            em.persist(northAmerica);
            em.persist(southAmerica);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
