package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocationManager implements LocationManagerLocal, LocationManagerRemote {

    @PersistenceContext(unitName = "locations-pu")
    EntityManager entityManager;

    public Location create(String city, String country, String metric) {
        Location location = new Location(city, country, metric);
        entityManager.persist(location);
        return location;
    }

    public List<Location> getLocations() {
        List<Location> l = entityManager.createNamedQuery(Location.ALL, Location.class).getResultList();
        return l;
    }

    public Location update(Location location) { return entityManager.merge(location);}

    public void delete(Location location) { entityManager.remove(location);}

    public void delete(long id) {
        Location location = entityManager.find(Location.class, id);
        entityManager.remove(location);
    }
}
