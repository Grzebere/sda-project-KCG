package weather.menu;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import weather.dataBase.Functions;
import weather.dataBase.Location;
import weather.dataBase.WeatherArchive;
import weather.weatherServices.Deserialize;
import weather.weatherServices.WeatherFunctions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User {
    public static void start() throws ParseException, IOException {
        Scanner scan = new Scanner(System.in);
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(WeatherArchive.class)
                .buildSessionFactory();

        System.out.println("Witaj w Pogodynce!" + "\n" +
                "Wybeirz numer aby przejśc dalej" + "\n" +
                "1. Wyświetl zapisane lokalizacje" + "\n" +
                "2. Dodaj nową lokalizację" + "\n" +
                "3. Pobierz pogodę" + "\n" +
                "4. Zakończ"
        );
        int choice = scan.nextInt();

        switch (choice){
            case 1:
                List<Location> list = Functions.selectLocations(sessionFactory);
                System.out.println("Lista lokalizacji:");
                for ( Location locat: list
                       ) {
                    System.out.println(locat);
                }
                System.out.println("\n" +
                        "Wciśnij ENTER aby powrócić do menu");
                scan.nextLine();
                start();
                break;

            case 2:
                System.out.println("Czy chcesz dodać loklizację: " + "\n" +
                        "1. Ręcznie" + "\n" +
                        "2. Przez wpisanie koordynatów" + "\n" +
                        "3. Przez wpisanie nazwy satacji"
                        );
                int adding = scan.nextInt();
                switch (adding){
                    case 1:
                        System.out.println("Podaj id stacji pogodowej");
                        int id = scan.nextInt();
                        System.out.println("Podaj długość geograficzna");
                        double lon = scan.nextDouble();
                        System.out.println("Podaj szerokość geograficzną");
                        double lat = scan.nextDouble();
                        System.out.println("Podaj nazwę regionu");
                        String reg = scan.nextLine();
                        System.out.println("Podaj nazwę kraju");
                        String cou = scan.nextLine();
                        Location location = new Location(id, lon, lat, reg, cou);
                        Functions.insertLocation(location, sessionFactory);
                        System.out.println("\n" +
                                "Lokacja dodana! Wciśnij ENTER aby powrócić do menu");
                        scan.nextLine();
                        start();
                        break;
                }
            case 3:
                System.out.println("Wybierz lokalizaję pogody: " + "\n" +
                        "1. Za pomocą długości i szerokości geograficznej" + "\n" +
                        "2. Za pomocą nazwy regionu" + "\n" +
                        "3. Powrót"
                );
                int select = scan.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("Podaj długość geograficzna");
                        double lon = scan.nextDouble();
                        System.out.println("Podaj szerokość geograficzną");
                        double lat = scan.nextDouble();
                        Location location = Functions.selectLocationsByLongitudeAndLatitude(sessionFactory, lon, lat);
                        System.out.println("Podaj date (dd/MM/yyyy)");
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = formatter.parse(scan.nextLine());
                        String openJSON = WeatherFunctions.getWeatherForDay(Double.toString(location.getLongitude()),
                                Double.toString(location.getLatitude()),
                                date.getTime()
                        );
                        WeatherArchive weatherArchive = Deserialize.getWeatherFromJson(openJSON, location);
                        Functions.insertWeather(weatherArchive, sessionFactory);
                        System.out.println(weatherArchive);
                        System.out.println("\n" +
                                "Wciśnij ENTER aby powrócić do menu");
                        scan.nextLine();
                        start();
                        break;
                }

        }
        // wybór wyszukiwania
        System.out.println("Po czym chcesz wyszukać: 1 -> Po reginie, 2 -> Po danych geograicznych");
        int choices = scan.nextInt();

        // wyszukiwanie po rejonie
        if (choices == 1) {
            System.out.println("Podaj miejscowość");
            String region = scan.nextLine();
            // select z bazy
            // wyszukanie pogody po Location.getRegion
        }
        // wyszukiwanie po danych geograficznych
        else if (choice == 2) {
            System.out.println("Podaj długość geograficzną"); //podać jak użytkownik ma podawać wartości

            String longitude = scan.nextLine();
            System.out.println("Podaj szerokość geograficzną");
            String latitude = scan.nextLine();
            // select z bazy
            // wyszukanie pogody po Location.getRegion
        }

        // inne
        else {
            System.out.println("Podana wartość jest nie poprawna");
        }

        // data
        System.out.println("Podaj date (dd, MM, yyyy)");
        String  date = scan.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MM, yyyy");
        String date1String = date;
        System.out.println(date);
    }
}