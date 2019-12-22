package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class WeatherManager implements WeatherManagerLocal, WeatherManagerRemote {

    @PersistenceContext(unitName = "meteo-pu")
    EntityManager entityManager;

    public Weather create(String weather, String description, String temperature, LocalDate date){
        Weather weatherob = new Weather(weather, description, temperature, date);
        entityManager.persist(weather);
        return weatherob;
    }

    @Override
    public List<Weather> getWeathers(){
        List<Weather> w = entityManager.createNamedQuery(Weather.ALL, Weather.class).getResultList();
        return w;
    }

    @Override
    public Weather update(Weather weatherob) { return entityManager.merge(weatherob);}

    @Override
    public void delete(Weather weatherob) {entityManager.remove(weatherob);}

    @Override
    public void delete(long id){
        Weather weatherob = entityManager.find(Weather.class, id);
        entityManager.remove(weatherob);
    }

}
