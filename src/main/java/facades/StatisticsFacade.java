package facades;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entities.Country;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.List;

public class StatisticsFacade {

    private static EntityManagerFactory emf;
    private static StatisticsFacade instance;

    private StatisticsFacade() {}

    public static StatisticsFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StatisticsFacade();
        }
        return instance;
    }

    public JsonObject getContinentStats(String continent) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> tq = em.createQuery("SELECT c FROM Country c WHERE c.continent.continentName = '"+continent+"'", Country.class);
        List<Country> countryList = tq.getResultList();
        if (countryList.size() == 0) {
            throw new NotFoundException("No continent with name " + continent + " exists");
        }
        countryList.sort(Comparator.comparing(Country::getCountryName));

        JsonArray ja = new JsonArray();
        for (int i = 0; i < countryList.size(); i++) {
            JsonObject jo = new JsonObject();
            Country country = countryList.get(i);

            jo.addProperty("key", i+1);
            jo.addProperty("svg", country.getCountrySVG());
            jo.addProperty("country", country.getCountryName());
            jo.addProperty("answered", country.getAnswered());
            jo.addProperty("correct", country.getCorrect());
            jo.addProperty("incorrect", country.getIncorrect());
            ja.add(jo);
        }
        JsonObject mainObject = new JsonObject();
        mainObject.add("countries", ja);
        return mainObject;
    }
}
