package pt.ipb.sd.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Location.COUNT_ALL, query = "SELECT COUNT(b) FROM Location b"),
        @NamedQuery(name = Location.ALL, query = "SELECT b FROM Location b"),
        @NamedQuery(name = Location.BY_CITY, query = "SELECT b FROM Location b WHERE b.city = :city"),
        @NamedQuery(name = Location.COUNT_BY_CITY, query = "SELECT COUNT(b) FROM Location b WHERE b.city = :city")})

public class Location implements Serializable {
    public final static String ALL = "pt.ipb.sd.jpa.entity.Location.ALL";
    public final static String COUNT_ALL = "pt.ipb.sd.jpa.entity.Location.COUNT_ALL";
    public final static String BY_CITY = "pt.ipb.sd.jpa.entity.Location.BY_CITY";
    public final static String COUNT_BY_CITY = "pt.ipb.sd.jpa.entity.Location.COUNT_BY_CITY";

    @OneToMany(mappedBy = "location")
    List<Weather> weathers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String city;
    String country;
    String metric;

    public Location(String city, String country, String metric) {
        this.city = city;
        this.country = country;
        this.metric = metric;
    }

    public Location() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
