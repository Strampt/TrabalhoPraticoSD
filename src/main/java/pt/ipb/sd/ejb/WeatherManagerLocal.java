package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Local;
import java.util.List;

@Local
public interface WeatherManagerLocal {
    Weather create(String weather, String description, String temperature);

    List<Weather> getWeathers();

    Weather update(Weather weather);

    void delete(Weather weather);

    void delete(long id);
}
