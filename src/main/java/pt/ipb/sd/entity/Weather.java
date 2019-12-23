package pt.ipb.sd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Weather.ALL, query = "SELECT b FROM Weather b")
})

public class Weather implements Serializable {
    public final static String ALL = "pt.ipb.sd.jpa.entity.Weather.ALL";

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String weather;
    String description;
    String temperature;

    public Weather(String weather, String description, String temperature) {
        this.weather = weather;
        this.description = description;
        this.temperature = temperature;
    }

    public Weather(){

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

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



