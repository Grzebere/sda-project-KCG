package weather.dataBase;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import weather.weatherServices.Deserialize;
import weather.weatherServices.WeatherFunctions;

import java.io.IOException;
import java.util.Date;


public class Test {
    public static void main(String[] args) throws IOException {

        Date date = new Date(System.currentTimeMillis());

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(WeatherArchive.class)
                .buildSessionFactory();
        Location bialy = new Location(11,12, 10, "Białystok", "Polska");

        Functions.insertLocation(bialy, sessionFactory);
        Functions.insertLocation(new Location(12, 33, 66, "Gdańsk", "Polska"), sessionFactory);
        //Functions.insertWeather(new WeatherArchive(bialy, date, 32.2f, 1000f, 60f), sessionFactory);

        //System.out.println(Functions.selectLocations(sessionFactory));
        //System.out.println(Functions.selectLocationsByRegion(sessionFactory, "Gdańsk"));

        System.out.println(Functions.selectLocationsByLongitudeAndLatitude(sessionFactory, 12, 10));
        //System.out.println(Functions.selectWeatherByLocationAndDate(sessionFactory, bialy, date));
        String json = WeatherFunctions.getWeatherForDay("23.16", "53.13", new Date().getTime());
        System.out.println(json);
        System.out.println(Deserialize.getWeatherFromJson(json, Functions.selectLocationsByRegion(sessionFactory, "Białystok")));


    }
}
