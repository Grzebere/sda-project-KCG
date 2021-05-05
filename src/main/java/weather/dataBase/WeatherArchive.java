package weather.dataBase;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "weather_archive")
public class WeatherArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "idlocation")
    private Location location;

    private Date date;
    private Float temperature;
    private Float pressure;
    private Float humidity;
    private Double windSpeed;
    private Integer windDeg;

    public WeatherArchive() {
    }

    public WeatherArchive(Location location, Date date, Float temperature, Float pressure, Float humidity, Double windSpeed, Integer windDeg ) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }



    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pogoda z dnia: " +
                new SimpleDateFormat("yyyy-MM-dd").format(date) + " w " +
                location.getRegion() + ", " +
                location.getCountry() +
                ": temperatura= " + temperature +
                ", ciśnienie= " + pressure +
                ", prędkość wiatru= " + windSpeed +
                ", kierunek wiatru= " + windDeg +
                ", humidity= "+ humidity + ".";


        /*return "WeatherArchive{" +
                "id=" + id +
                ", location=" + location +
                ", date=" + date +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';*/
    }
}
