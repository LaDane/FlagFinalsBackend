package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facades.LeaderboardFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("leaderboard")
public class LeaderboardResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final LeaderboardFacade FACADE = LeaderboardFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("highscore")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHighscores() {
        JsonObject jo = FACADE.getHighscores();
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(jo))
                .build();
    }
}
