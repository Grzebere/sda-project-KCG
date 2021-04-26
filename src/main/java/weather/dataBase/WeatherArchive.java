package weather.dataBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather_archive")
public class WeatherArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "idlocation")
    private Location location;

    private LocalDate date;
    private Float temperature;
    private Float pressure;
    private Float humidity;

    public WeatherArchive() {
    }

    public WeatherArchive(Location location, LocalDate date, Float temperature, Float pressure, Float humidity) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }



    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "WeatherArchive{" +
                "id=" + id +
                ", location=" + location +
                ", date=" + date +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
