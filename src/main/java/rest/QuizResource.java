package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.QuestionDTO;
import dtos.QuizDTO;
import entities.Question;
import entities.Quiz;
import errorhandling.NotFoundException;
import facades.*;
import facades.QuizFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("quiz")
public class QuizResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final QuizFacade FACADE =  QuizFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("ping")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("create")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String jsonContext) throws NotFoundException {
        QuizDTO dto = GSON.fromJson(jsonContext, QuizDTO.class);

        Long totalPoints = 0L;
        Long totalCorrect = 0L;
        Long totalIncorrect = 0L;
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO q : dto.getQuestions()) {
            questions.add(new Question(
                    q.getCorrectCountryId(),
                    q.getSvg(),
                    q.getAnswer1(),
                    q.getAnswer2(),
                    q.getAnswer3(),
                    q.getAnswer4(),
                    q.getPoints()
            ));
            totalPoints += q.getPoints();
            if (q.getPoints() != 0) {
                totalCorrect ++;
            } else {
                totalIncorrect ++;
            }
        }
        Quiz quiz = new Quiz(
                totalPoints,
                totalCorrect,
                totalIncorrect,
                questions,
                ContinentFacade.getFacade(EMF).getByName(dto.getContinentName()),
                UserFacade.getUserFacade(EMF).getUserByName(dto.getUsername())
        );
        Quiz created = FACADE.create(quiz);
        for (Question q : created.getQuestions()) {
            q.setQuiz(created);
            QuestionFacade.getFacade(EMF).update(q);
        }
        QuizDTO createdDTO = new QuizDTO(created);
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(createdDTO))
                .build();
    }

//    @Path("{id}")
//    @PUT
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response update(@PathParam("id") Long id, String jsonContext) throws NotFoundException {
//        QuizDTO dto = GSON.fromJson(jsonContext, QuizDTO.class);
//        Quiz quiz = new Quiz(
//                dto.getDummyStr1(),
//                dto.getDummyStr2()
//        );
//        quiz.setId(id);
//        QuizDTO updated = new QuizDTO(FACADE.update(quiz));
//        return Response
//                .ok("SUCCESS")
//                .entity(GSON.toJson(updated))
//                .build();
//    }

    @Path("{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) throws NotFoundException {
        QuizDTO deleted = new QuizDTO(FACADE.delete(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(deleted))
                .build();
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) throws NotFoundException {
        QuizDTO found = new QuizDTO(FACADE.getById(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(found))
                .build();
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<QuizDTO> dtoList = new ArrayList<>();
        for (Quiz quiz : FACADE.getAll()) {
            dtoList.add(new QuizDTO(quiz));
        }
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(dtoList))
                .build();
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getQuizCount() {
        long count = FACADE.getCount();
        return "{\"count\":"+count+"}";
    }

    @Path("generate/{continentName}/{username}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response generate(@PathParam("continentName") String continentName, @PathParam("username") String username) throws NotFoundException {
        Quiz quiz = FACADE.generateQuiz(continentName, username);
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(new QuizDTO(quiz)))
                .build();
    }

    @Path("result/{correctId}/{answer}/{time}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Long getResult(@PathParam("correctId") Long correctId, @PathParam("answer") String answer, @PathParam("time") float time) throws NotFoundException {
        Long points = FACADE.getResult(correctId, answer, time);
        return points;
    }
}
