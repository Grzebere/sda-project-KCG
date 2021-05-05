package weather.weatherServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.dataBase.Location;
import weather.dataBase.WeatherArchive;

import java.util.Date;

public class Deserialize {

    public static WeatherArchive getWeatherFromJson(String json, Location location) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenweatherDTO2 openweatherDTO2 = objectMapper.readValue(json, OpenweatherDTO2.class);
        WeatherArchive weatherArchive = new WeatherArchive(
                location,
                new Date(openweatherDTO2.getCurrentDt() * 1000L),
                (float) openweatherDTO2.getCurrentTemp(),
                (float) openweatherDTO2.getCurrentPressure(),
                (float) openweatherDTO2.getCurrentHumidity(),
                (double) openweatherDTO2.getCurrentWindSpeed(),
                (int) openweatherDTO2.getCurrentWindDeg()
        );
        return weatherArchive;
    }

    public static Location getLocationFromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenweatherDTO openweatherDTO = objectMapper.readValue(json, OpenweatherDTO.class);
        Location location = new Location(
                openweatherDTO.getId(),
                openweatherDTO.getCoordLon(),
                openweatherDTO.getCoordLat(),
                openweatherDTO.getSysCountry(),
                openweatherDTO.getName()
        );

        return location;
    }
}
