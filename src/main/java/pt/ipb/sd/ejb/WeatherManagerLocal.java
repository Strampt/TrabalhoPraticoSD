package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;

@Local
public interface WeatherManagerLocal {
    Weather create(String weather, String description, String temperature);

    List<Weather> getWeathers();

    Weather update(Weather weatherob);

    void delete(Weather weatherob);

    void delete(long id);
}
