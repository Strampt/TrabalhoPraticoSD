package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class WeatherManager implements WeatherManagerLocal, WeatherManagerRemote {

    @PersistenceContext(unitName = "meteo-pu")
    EntityManager entityManager;

    @Override
    public Weather create(String weather, String description, String temperature) {
        Weather weather1 = new Weather(weather, description, temperature);
        entityManager.persist(weather1);
        return weather1;
    }

    @Override
    public List<Weather> getWeathers() {
        List<Weather> l = entityManager.createNamedQuery(Weather.ALL, Weather.class)
                .getResultList();
        return l;
    }

    @Override
    public Weather update(Weather weather) {
        return entityManager.merge(weather);
    }

    @Override
    public void delete(Weather weather) {
        entityManager.remove(weather);
    }

    @Override
    public void delete(long id) {
        Weather weather = entityManager.find(Weather.class, id);
        entityManager.remove(weather);
    }
}
