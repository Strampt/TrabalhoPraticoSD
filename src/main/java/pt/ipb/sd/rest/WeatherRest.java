package pt.ipb.sd.rest;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.opensaml.xmlsec.encryption.Public;
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
import java.awt.*;
import java.util.List;

@Path("/api/weathers")
public class WeatherRest {

    @EJB
    WeatherManagerRemote weatherManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> list() { return weatherManager.getWeathers(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String create(Weather weather){
        Client client = ClientBuilder.newClient();
        Weather newWeather = weatherManager.create(weather.getWeather(), weather.getDescription(), weather.getTemperature(), weather.getDate());
        WebTarget target = client.target("http://localhost/api/weathers");
        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(newWeather), String.class);
        return response;
    }

    @DELETE
    @Path("{id}")
    public void deleteWeatherById(@PathParam("id") long id) {weatherManager.delete(id);}
}
