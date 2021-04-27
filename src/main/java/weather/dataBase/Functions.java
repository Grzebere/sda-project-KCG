package weather.dataBase;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.time.LocalDate;
import java.util.List;

public class Functions {

    public static void insertLocation(Location location, SessionFactory sessionFactory){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(location);
            transaction.commit();
        }
    }

    public static List selectLocations(SessionFactory sessionFactory){
        try (Session session = sessionFactory.openSession()) {
            Query<Location> locationQuery = session.createQuery("SELECT loc FROM Location loc" , Location.class);
            List<Location> locations = locationQuery
                    .getResultList();
            return locations;
        }
    }

    public static Location selectLocationsByRegion(SessionFactory sessionFactory, String region) {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> locationQuery = session.createQuery("SELECT loc FROM Location loc WHERE loc.region = :region", Location.class);
            Location location = locationQuery
                    .setParameter("region", region)
                    .getSingleResult();
            return location;
        }
    }

    public static Location selectLocationsByLongitudeAndLatitude(SessionFactory sessionFactory, String longitude , String latitude) {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> locationQuery = session.createQuery("SELECT loc FROM Location loc WHERE loc.longitude = :longitude AND loc.latitude = :latitude", Location.class);
            Location location = locationQuery
                    .setParameter("longitude", longitude)
                    .setParameter("latitude", latitude)
                    .getSingleResult();
            return location;
        }
    }

    public static void insertWeather(WeatherArchive weatherArchive, SessionFactory sessionFactory){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(weatherArchive);
            transaction.commit();
        }
    }
    public static WeatherArchive selectWeatherByLocationAndDate(SessionFactory sessionFactory, Location location, LocalDate localDate){
        try (Session session = sessionFactory.openSession()) {
            Query<WeatherArchive> weatherQuery = session.createQuery("SELECT wea FROM WeatherArchive wea WHERE wea.date = :localDate AND wea.location = :location", WeatherArchive.class);
            WeatherArchive weatherArchive = weatherQuery
                    .setParameter("localDate", localDate)
                    .setParameter("location", location)
                    .getSingleResult();
            return weatherArchive;
        }

    }

}
