package pt.ipb.sd.jsf;

import pt.ipb.sd.ejb.WeatherManagerRemote;
import pt.ipb.sd.entity.Weather;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class WeatherBackingBean {

    @EJB
    WeatherManagerRemote weatherManager;
    @ManagedProperty("#{param.weather}")
    String weather;
    String description;
    String temperature;

    public List<Weather> getWeathers() {return weatherManager.getWeathers();}

    public String getName(){return "testing...one...two...middle.out";}

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

    public String doCreateWeather(){
        this.weatherManager.create(getWeather(), getDescription(), getTemperature());
        return "weathers";
    }

}
