package facades;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entities.Country;
import entities.Quiz;
import entities.User;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardFacade {

    private static EntityManagerFactory emf;
    private static LeaderboardFacade instance;

    private LeaderboardFacade() {}

    public static LeaderboardFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LeaderboardFacade();
        }
        return instance;
    }

    public JsonObject getHighscores() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Quiz> quizTQ = em.createQuery("SELECT q FROM Quiz q", Quiz.class);
        List<Quiz> quizList = quizTQ.getResultList();

        quizList.sort(Comparator.comparingLong(Quiz::getTotalPoints));
        Collections.reverse(quizList);

        List<Quiz> newList = new ArrayList<>();
        for (Quiz q : quizList) {
            boolean alreadyExists = false;
            for (Quiz nq : newList) {
                if (q.getUser().getUserName().equals(nq.getUser().getUserName())) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                newList.add(q);
            }
        }

        JsonArray ja = new JsonArray();

        for (int i = 0; i < newList.size(); i++) {
            if (i == 10) {
                break;
            }
            JsonObject jo = new JsonObject();
            User user = newList.get(i).getUser();
            Country country = user.getCountry();

            jo.addProperty("rank", i+1);
            jo.addProperty("username", user.getUserName());
            jo.addProperty("svg", country.getCountrySVG());
            jo.addProperty("points", newList.get(i).getTotalPoints());
            ja.add(jo);
        }

        JsonObject mainObject = new JsonObject();
        mainObject.add("highscores", ja);

        return mainObject;
    }
}
