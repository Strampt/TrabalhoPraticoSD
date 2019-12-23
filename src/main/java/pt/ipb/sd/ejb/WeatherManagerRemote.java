package pt.ipb.sd.ejb;

import pt.ipb.sd.entity.Weather;

import javax.ejb.Remote;

@Remote
public interface WeatherManagerRemote extends WeatherManagerLocal {
}
