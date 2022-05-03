package facades;

import entities.Question;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class QuestionFacade implements IFacade<Question> {

    private static EntityManagerFactory emf;
    private static QuestionFacade instance;

    private QuestionFacade() {}

    public static QuestionFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuestionFacade();
        }
        return instance;
    }

    @Override
    public Question create(Question question) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(question);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return question;
    }

    @Override
    public Question update(Question question) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Question found = em.find(Question.class, question.getId());
        if (found == null) {
            throw new NotFoundException("Entity with ID: " + question.getId() + " not found");
        }

        // TODO: update values here

        try {
            em.getTransaction().begin();
            Question updated = em.merge(question);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Question delete(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Question found = em.find(Question.class, id);
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
    public Question getById(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Question question;
        try {
            question = em.find(Question.class, id);
            if (question == null) {
                throw new NotFoundException();
            }
        } finally {
            em.close();
        }
        return question;
    }

    @Override
    public List<Question> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Question> query = em.createQuery("SELECT z FROM Question z", Question.class);
        return query.getResultList();
    }

    @Override
    public long getCount() {
        EntityManager em = emf.createEntityManager();
        try{
            return (Long)em.createQuery("SELECT COUNT(z) FROM Question z").getSingleResult();
        } finally {
            em.close();
        }
    }
}
