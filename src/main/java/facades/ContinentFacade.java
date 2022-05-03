package facades;

import entities.Continent;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContinentFacade implements IFacade<Continent> {

    private static EntityManagerFactory emf;
    private static ContinentFacade instance;

    private ContinentFacade() {}

    public static ContinentFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ContinentFacade();
        }
        return instance;
    }

    @Override
    public Continent create(Continent continent) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(continent);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return continent;
    }

    @Override
    public Continent update(Continent continent) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Continent found = em.find(Continent.class, continent.getId());
        if (found == null) {
            throw new NotFoundException("Entity with ID: " + continent.getId() + " not found");
        }

        // TODO: update values here

        try {
            em.getTransaction().begin();
            Continent updated = em.merge(continent);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Continent delete(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Continent found = em.find(Continent.class, id);
        if (found == null) {
            throw new NotFoundException("Could not remove Entity with id: " + id);
        }

        try {
            em.getTransaction().begin();
            em.remove(found);
            em.getTransaction().commit();
            return found;
        } finally {
            em.close();
        }
    }

    @Override
    public Continent getById(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Continent continent;
        try {
            continent = em.find(Continent.class, id);
            if (continent == null) {
                throw new NotFoundException();
            }
        } finally {
            em.close();
        }
        return continent;
    }

    @Override
    public List<Continent> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Continent> query = em.createQuery("SELECT z FROM Continent z", Continent.class);
        return query.getResultList();
    }

    @Override
    public long getCount() {
        EntityManager em = emf.createEntityManager();
        try{
            return (Long)em.createQuery("SELECT COUNT(z) FROM Continent z").getSingleResult();
        } finally {
            em.close();
        }
    }

    public Continent getByName(String name) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Continent> query = em.createQuery("SELECT z FROM Continent z WHERE z.continentName = '"+name+"'", Continent.class);
        List<Continent> continents = query.getResultList();
        if (continents.size() == 0) {
            throw new NotFoundException("No continents found named '"+name+"'");
        }
        return continents.get(0);
    }
}
