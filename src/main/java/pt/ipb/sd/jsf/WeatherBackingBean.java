package pt.ipb.sd.jsf;

import pt.ipb.sd.ejb.WeatherManager;
import pt.ipb.sd.entity.Weather;

import javax.ejb.EJB;
import java.util.List;

public class WeatherBackingBean {

    @EJB
    WeatherManager weatherManager;
    String weather;
    String description;
    String temperature;

    public List<Weather> getWeathers() {return weatherManager.getWeathers();}

    public String getWeather() {
        return weather;
    }

    public void setWather(String wather) {
        this.weather = wather;
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

    public String doCreateWeather(){
        this.weatherManager.create(getWeather(), getDescription(), getTemperature());
        return "weathers";
    }

}
