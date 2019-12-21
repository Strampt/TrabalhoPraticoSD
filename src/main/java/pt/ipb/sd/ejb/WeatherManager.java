package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class WeatherManager implements WeatherManagerLocal, WeatherManagerRemote {

    @PersistenceContext(unitName = "meteo-pu")
    EntityManager entityManager;

    @Override
    public Weather create(String weather, String description, String temperature){
        Weather weatherob = new Weather(weather, description, temperature);
        entityManager.persist(weather);
        return weatherob;
    }

    @Override
    public List<Weather> getWeathers(){
        List<Weather> l = entityManager.createNamedQuery(Weather.ALL, Weather.class).getResultList();
        return l;
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
