package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Location;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LocationManager implements LocationManagerLocal, LocationManagerRemote{

    @PersistenceContext(unitName = "meteo-pu")
    EntityManager entityManager;

    @Override
    public Location create(String city, String country, String unit) {
        Location location = new Location(city, country, unit);
        entityManager.persist(location);
        return location;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> l = entityManager.createNamedQuery(Location.ALL, Location.class).getResultList();
        return l;
    }

    @Override
    public Location update(Location location) {
        return entityManager.merge(location);
    }

    @Override
    public void delete(Location location) {
        entityManager.remove(location);
    }

    @Override
    public void delete(long id) {
        Location location = entityManager.find(Location.class, id);
        entityManager.remove(location);
    }
}
