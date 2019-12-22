package pt.ipb.sd.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Location.ALL, query = "Select b FROM Location b")
})

public class Location implements Serializable {
    public final static String ALL = "pt.ipb.sd.jpa.entity.Location.All";

    @OneToMany(mappedBy = "location")
    private List<Weather> weathers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String city;
    String country;
    String unit;

    public Location(String city, String country, String unit){
        this.city = city;
        this.country = country;
        this.unit = unit;
    }

    public Location() {
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
}
