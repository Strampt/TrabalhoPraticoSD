package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Location;

import javax.ejb.Local;
import java.util.List;

public interface LocationManagerLocal {
    Location create(String city, String country, String metric);

    List<Location> getLocations();

    Location update(Location location);

    void delete(Location location);

    void delete(long id);
}
