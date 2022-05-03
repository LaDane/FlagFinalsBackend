package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ResetDB {
    public static void truncate(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
            em.createNativeQuery("truncate table continents").executeUpdate();
            em.createNativeQuery("truncate table countries").executeUpdate();
            em.createNativeQuery("truncate table questions").executeUpdate();
            em.createNativeQuery("truncate table quizzes").executeUpdate();
            em.createNativeQuery("truncate table roles").executeUpdate();
            em.createNativeQuery("truncate table user_roles").executeUpdate();
            em.createNativeQuery("truncate table users").executeUpdate();
            em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
        } finally {
            em.close();
        }
    }
}
