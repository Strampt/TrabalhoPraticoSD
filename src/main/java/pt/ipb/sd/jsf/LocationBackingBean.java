package pt.ipb.sd.jsf;

import pt.ipb.sd.ejb.LocationManager;
import pt.ipb.sd.entity.Location;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class LocationBackingBean {

    @EJB
    LocationManager locationManager;
    String city;
    String country;
    String unit;

    public List<Location> getLocations() {
        return locationManager.getLocations();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String doCreateLocation() {
        this.locationManager.create(getCity(), getCountry(), getUnit());
        return "locations";
    }
}