package weather.dataBase;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {

            final SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(WeatherArchive.class)
                    .buildSessionFactory();
            Location bialy = new Location("12", "10", "Białystok", "Polska");
                Functions.insertLocation(bialy, sessionFactory);
                Functions.insertLocation(new Location("33", "66", "Gdańsk", "Polska"), sessionFactory);
                Functions.insertWeather(new WeatherArchive(bialy, LocalDate.now(), 32.2f, 1000f, 60f), sessionFactory);
        //System.out.println(Functions.selectLocations(sessionFactory));
        //System.out.println(Functions.selectLocationsByRegion(sessionFactory, "Gdańsk"));
        System.out.println(Functions.selectLocationsByLongitudeAndLatitude(sessionFactory, "12", "10"));
        System.out.println(Functions.selectWeatherByLocationAndDate(sessionFactory, bialy, LocalDate.now()));



    }
    }
