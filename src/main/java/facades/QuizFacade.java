package facades;

import dtos.QuizDTO;
import entities.*;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizFacade implements IFacade<Quiz> {

    private static EntityManagerFactory emf;
    private static QuizFacade instance;

    private QuizFacade() {}

    public static QuizFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuizFacade();
        }
        return instance;
    }

    @Override
    public Quiz create(Quiz quiz) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(quiz);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return quiz;
    }

    @Override
    public Quiz update(Quiz quiz) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Quiz found = em.find(Quiz.class, quiz.getId());
        if (found == null) {
            throw new NotFoundException("Entity with ID: " + quiz.getId() + " not found");
        }

        // TODO: update values here

        try {
            em.getTransaction().begin();
            Quiz updated = em.merge(quiz);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Quiz delete(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Quiz found = em.find(Quiz.class, id);
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
    public Quiz getById(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Quiz quiz;
        try {
            quiz = em.find(Quiz.class, id);
            if (quiz == null) {
                throw new NotFoundException();
            }
        } finally {
            em.close();
        }
        return quiz;
    }

    @Override
    public List<Quiz> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Quiz> query = em.createQuery("SELECT z FROM Quiz z", Quiz.class);
        return query.getResultList();
    }

    @Override
    public long getCount() {
        EntityManager em = emf.createEntityManager();
        try{
            return (Long)em.createQuery("SELECT COUNT(z) FROM Quiz z").getSingleResult();
        } finally {
            em.close();
        }
    }

    public Quiz generateQuiz(String continentName, String username) throws NotFoundException {
        Continent continent = ContinentFacade.getFacade(emf).getByName(continentName);
        User user = UserFacade.getUserFacade(emf).getUserByName(username);

        EntityManager em = emf.createEntityManager();

        TypedQuery<Country> query;

        if (!continent.getContinentName().equals("World")) {
            query = em.createQuery("SELECT z FROM Country z WHERE z.continent.id = '"+continent.getId()+"'", Country.class);

        } else {
            query = em.createQuery("SELECT z FROM Country z ", Country.class);

        }

        List<Country> allCountries = query.getResultList();
        Collections.shuffle(allCountries);

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Country correctCountry = allCountries.get(i);
            Long correctCountryId = correctCountry.getId();
            String svg = allCountries.get(i).getCountrySVG();

            List<Country> newCountryList = new ArrayList<>(allCountries);
            newCountryList.remove(correctCountry);
            Collections.shuffle(newCountryList);

            List<String> answers = new ArrayList<>();
            answers.add(correctCountry.getCountryName());
            answers.add(newCountryList.get(0).getCountryName());
            answers.add(newCountryList.get(1).getCountryName());
            answers.add(newCountryList.get(2).getCountryName());
            Collections.shuffle(answers);

            Question question = new Question(
                    correctCountryId,
                    svg,
                    answers.get(0),
                    answers.get(1),
                    answers.get(2),
                    answers.get(3),
                    0L
            );
            questions.add(question);
        }

        Quiz quiz = new Quiz(questions, continent, user);
        return quiz;
    }

    public Long getResult(Long correctId, String answer, float time) throws NotFoundException {
        Country country = CountryFacade.getFacade(emf).getById(correctId);
        if (!country.getCountryName().equals(answer)) {
            return 0L;
        } else {
            int points = (int) Math.floor(time * 100);
            return (long) points;
        }
    }

//    public Quiz quizEnd(QuizDTO dto) {
//        Quiz quiz =
//    }
}
