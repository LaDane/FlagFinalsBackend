package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CountryDTO;
import entities.Country;
import errorhandling.NotFoundException;
import facades.CountryFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("country")
public class CountryResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final CountryFacade FACADE =  CountryFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("ping")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

//    @Path("create")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response create(String jsonContext) {
//        CountryDTO dto = GSON.fromJson(jsonContext, CountryDTO.class);
//        Country country = new Country(
//            dto.getDummyStr1(),
//            dto.getDummyStr2()
//        );
//        CountryDTO created = new CountryDTO(FACADE.create(country));
//        return Response
//                .ok("SUCCESS")
//                .entity(GSON.toJson(created))
//                .build();
//    }

//    @Path("{id}")
//    @PUT
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response update(@PathParam("id") Long id, String jsonContext) throws NotFoundException {
//        CountryDTO dto = GSON.fromJson(jsonContext, CountryDTO.class);
//        Country country = new Country(
//                dto.getDummyStr1(),
//                dto.getDummyStr2()
//        );
//        country.setId(id);
//        CountryDTO updated = new CountryDTO(FACADE.update(country));
//        return Response
//                .ok("SUCCESS")
//                .entity(GSON.toJson(updated))
//                .build();
//    }

//    @Path("{id}")
//    @DELETE
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response delete(@PathParam("id") Long id) throws NotFoundException {
//        CountryDTO deleted = new CountryDTO(FACADE.delete(id));
//        return Response
//                .ok("SUCCESS")
//                .entity(GSON.toJson(deleted))
//                .build();
//    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) throws NotFoundException {
        CountryDTO found = new CountryDTO(FACADE.getById(id));
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(found))
                .build();
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<CountryDTO> dtoList = new ArrayList<>();
        for (Country country : FACADE.getAll()) {
            dtoList.add(new CountryDTO(country));
        }
        return Response
                .ok("SUCCESS")
                .entity(GSON.toJson(dtoList))
                .build();
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCountryCount() {
        long count = FACADE.getCount();
        return "{\"count\":"+count+"}";
    }
}
