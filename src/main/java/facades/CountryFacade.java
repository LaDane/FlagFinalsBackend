package facades;

import entities.Country;
import errorhandling.NotFoundException;
import utils.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;


public class CountryFacade implements IFacade<Country> {

    private static EntityManagerFactory emf;
    private static CountryFacade instance;

    private CountryFacade() {}

    public static CountryFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CountryFacade();
        }
        return instance;
    }

    @Override
    public Country create(Country country) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return country;
    }

    @Override
    public Country update(Country country) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Country found = em.find(Country.class, country.getId());
        if (found == null) {
            throw new NotFoundException("Entity with ID: " + country.getId() + " not found");
        }

        // TODO: update values here

        try {
            em.getTransaction().begin();
            Country updated = em.merge(country);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Country delete(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Country found = em.find(Country.class, id);
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
    public Country getById(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Country country;
        try {
            country = em.find(Country.class, id);
            if (country == null) {
                throw new NotFoundException();
            }
        } finally {
            em.close();
        }
        return country;
    }

    @Override
    public List<Country> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> query = em.createQuery("SELECT z FROM Country z", Country.class);
        return query.getResultList();
    }

    @Override
    public long getCount() {
        EntityManager em = emf.createEntityManager();
        try{
            return (Long)em.createQuery("SELECT COUNT(z) FROM Country z").getSingleResult();
        } finally {
            em.close();
        }
    }

    public Country getByName(String name) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> query = em.createQuery("SELECT z FROM Country z WHERE z.countryName = '"+name+"'", Country.class);
        List<Country> countries = query.getResultList();
        if (countries.size() == 0) {
            throw new NotFoundException("No countries found named '"+name+"'");
        }
        return countries.get(0);
    }

    public String getSVG(String name) throws NotFoundException, IOException {
        String result = Utility.fetchData("https://countryflagsapi.com/svg/"+name);
        if (!result.startsWith("<svg")) {
            throw new NotFoundException("No SVG can be fetched with name '"+name+"'");
        }
        return result;
    }
}
