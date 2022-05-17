package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import errorhandling.NotFoundException;
import facades.StatisticsFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("statistics")
public class StatisticsResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final StatisticsFacade FACADE = StatisticsFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("{continent}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getContinentStats(@PathParam("continent") String continent) throws NotFoundException {
        JsonObject jo = FACADE.getContinentStats(continent);
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(jo))
                .build();
    }
}
