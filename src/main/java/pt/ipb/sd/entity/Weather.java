package pt.ipb.sd.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({@NamedQuery(name = Weather.COUNT_ALL, query = "SELECT COUNT(b) FROM Weather b"),
        @NamedQuery(name = Weather.ALL, query = "SELECT b FROM Weather b"),
        @NamedQuery(name = Weather.BY_WEATHER, query = "SELECT b FROM Weather b WHERE b.weather = :weather"),
        @NamedQuery(name = Weather.COUNT_BY_WEATHER, query = "SELECT COUNT(b) FROM Weather b WHERE b.weather = :weather")})


public class Weather implements Serializable{
    public final static String ALL = "pt.ipb.sd.jpa.entity.ALL";
    public final static String COUNT_ALL = "pt.ipb.sd.jpa.entity.Weather.COUNT_ALL";
    public final static String BY_WEATHER = "pt.ipb.sd.jpa.entity.Weather.BY_WEATHER";
    public final static String COUNT_BY_WEATHER = "pt.ipb.pja.entity.Weather.COUNT:BY_WEATHER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String weather;
    String description;
    String temperature;

    public Weather(String weather, String description, String temperature){
        this.weather = weather;
        this.description = description;
        this.temperature = temperature;
    }
    public long getId() {return id;}

    public void setId(long id) {this.id = id; }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
