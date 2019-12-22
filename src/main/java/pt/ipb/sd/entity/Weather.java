package pt.ipb.sd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Weather.COUNT_ALL, query = "SELECT COUNT(b) FROM Weather b"),
        @NamedQuery(name = Weather.ALL, query = "SELECT b FROM Weather b"),
        @NamedQuery(name = Weather.BY_WEATHER, query = "SELECT b FROM Weather b WHERE b.weather = :weather"),
        @NamedQuery(name = Weather.COUNT_BY_WEATHER, query = "SELECT COUNT(b) FROM Weather b WHERE b.weather = :weather")})

public class Weather implements Serializable{
    public final static String ALL = "pt.ipb.sd.jpa.entity.Weather.ALL";
    public final static String COUNT_ALL = "pt.ipb.sd.jpa.entity.Weather.COUNT_ALL";
    public final static String BY_WEATHER = "pt.ipb.sd.jpa.entity.Weather.BY_WEATHER";
    public final static String COUNT_BY_WEATHER = "pt.ipb.jpa.entity.Weather.COUNT_BY_WEATHER";

    @ManyToOne(fetch = FetchType.EAGER)
    Location location;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String weather;
    String description;
    String temperature;
    LocalDate date;

    public Weather(String weather, String description, String temperature, LocalDate date){
        this.weather = weather;
        this.description = description;
        this.temperature = temperature;
    }

    public Weather() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
