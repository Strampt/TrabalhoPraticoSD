package pt.ipb.sd.rest;

import pt.ipb.sd.ejb.WeatherManager;
import pt.ipb.sd.ejb.WeatherManagerRemote;
import pt.ipb.sd.entity.Weather;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/weathers")
public class WeatherRest {
    @EJB
    WeatherManagerRemote weatherManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> list(){return weatherManager.getWeathers();}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Weather weather){
        Weather newWeather = weatherManager.create(weather.getWeather(), weather.getDescription(), weather.getTemperature());
        return Response.status(200).entity(newWeather).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteWeatherById(@PathParam("id") long id) {weatherManager.delete(id);}

}
