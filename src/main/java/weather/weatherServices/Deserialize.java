package weather.weatherServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.helpers.DateTimeDateFormat;
import weather.dataBase.Location;
import weather.dataBase.WeatherArchive;

import java.time.LocalDate;
import java.util.Date;

public class Deserialize {

    public static WeatherArchive getWeatherFromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenweatherDTO openweatherDTO =objectMapper.readValue(json, OpenweatherDTO.class);
        Location location = new Location(openweatherDTO.getCoordLon(), openweatherDTO.getCoordLat(), openweatherDTO.getSysCountry(), openweatherDTO.getName());
        WeatherArchive weatherArchive = new WeatherArchive(location, new Date(openweatherDTO.getDt()*1000L), (float)openweatherDTO.getMainTemp(), (float)openweatherDTO.getMainPressure(), (float)openweatherDTO.getMainHumidity());
        return weatherArchive;
    }

    public static Location getLocationFromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenweatherDTO openweatherDTO =objectMapper.readValue(json, OpenweatherDTO.class);
        Location location = new Location(openweatherDTO.getCoordLon(), openweatherDTO.getCoordLat(), openweatherDTO.getSysCountry(), openweatherDTO.getName());
        WeatherArchive weatherArchive = new WeatherArchive(location, new Date(openweatherDTO.getDt()*1000L), (float)openweatherDTO.getMainTemp(), (float)openweatherDTO.getMainPressure(), (float)openweatherDTO.getMainHumidity());
        return location;
    }
}
