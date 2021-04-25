package weather.dataBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    public static class LocationBuilder {
        private String longitude;
        private String latitude;
        private String region;
        private String country;
        private List<WeatherArchive> weatherArchives;

        public LocationBuilder() {
        }


        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setWeatherArchives(List<WeatherArchive> weatherArchives) {
            this.weatherArchives = weatherArchives;
        }

        public Location build() {
            return new Location(this);
        }


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "name", length = 40)
    private String longitude;
    private String latitude;
    private String region;
    private String country;

    @OneToMany(mappedBy = "weather_archive")
    private List<WeatherArchive> weatherArchives;


    public Location() {
    }

    public Location(String longitude, String latitude, String region, String country) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.region = region;
        this.country = country;
    }

    public Location(LocationBuilder locationBuilder) {
        this.longitude = locationBuilder.longitude;
        this.latitude = locationBuilder.latitude;
        this.region = locationBuilder.region;
        this.country = locationBuilder.country;
        this.weatherArchives = locationBuilder.weatherArchives;
    }

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", weatherArchives=" + weatherArchives +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public List<WeatherArchive> getWeatherArchives() {
        return weatherArchives;
    }
}
