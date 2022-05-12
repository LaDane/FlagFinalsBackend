package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.QuizDTO;
import dtos.QuizLiteDTO;
import entities.Quiz;
import errorhandling.NotFoundException;
import facades.QuizLiteFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("lite")
public class QuizLiteResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final QuizLiteFacade FACADE =  QuizLiteFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("generate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response generate() throws NotFoundException {
        QuizLiteDTO quiz = FACADE.generateQuiz(10);
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(quiz))
                .build();
    }

    @Path("result/{correctId}/{answer}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public int getResult(@PathParam("correctId") Long correctId, @PathParam("answer") String answer) throws NotFoundException {
        return FACADE.getResult(correctId, answer);
    }
}


