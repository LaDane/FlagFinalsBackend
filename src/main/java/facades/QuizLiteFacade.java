package facades;

import dtos.QuizLiteDTO;
import entities.*;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizLiteFacade {
    private static EntityManagerFactory emf;
    private static QuizLiteFacade instance;

    private QuizLiteFacade() {}

    public static QuizLiteFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuizLiteFacade();
        }
        return instance;
    }

    public QuizLiteDTO generateQuiz(int quantity)  {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        List<Country> allCountries = query.getResultList();
        Collections.shuffle(allCountries);

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
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

        QuizLiteDTO quizLiteDTO = new QuizLiteDTO(questions);
        return quizLiteDTO;
    }

    public int getResult(Long correctId, String answer) throws NotFoundException {
        Country country = CountryFacade.getFacade(emf).getById(correctId);
        if (!country.getCountryName().equals(answer)) {
            return 0;
        } else {
            return 1;
        }
    }

}
