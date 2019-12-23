package pt.ipb.sd.rest;

import pt.ipb.sd.ejb.LocationManagerRemote;
import pt.ipb.sd.entity.Location;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/locations")
public class LocationRest {
    @EJB
    LocationManagerRemote locationManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> list() {
        return locationManager.getLocations();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String create(Location location) {
        Client client = ClientBuilder.newClient();
        Location newLocation = locationManager.create(location.getCity(), location.getCountry(), location.getUnit());
        WebTarget target = client.target("http://localhost/api/locations");
        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(newLocation), String.class);
        return response;
    }


    @DELETE
    @Path("{id}")
    public void deleteLocationById(@PathParam("id") long id) {locationManager.delete(id);}
}