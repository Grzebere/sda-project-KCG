package weather.dataBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    public static class LocationBuilder {
        private int id;
        private double longitude;
        private double latitude;
        private String region;
        private String country;
        private List<WeatherArchive> weatherArchives;

        public LocationBuilder() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
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
    private Integer id;

    @Column()
    private double longitude;
    private double latitude;
    private String region;
    private String country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
    private List<WeatherArchive> weatherArchives;


    public Location() {
    }

    public Location(int id, double longitude, double latitude, String region, String country) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.region = region;
        this.country = country;
        this.id = id;
    }

    public Location(LocationBuilder locationBuilder) {
        this.id = locationBuilder.id;
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
        return "Lokacja " +
                id +
                ": " + region +
                ", " + country +
                ", długość geograficzna:" + longitude +
                ", szerokość geograficzna:" + latitude + '\n';


        /*return "Location{" +
                "id=" + id +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                //", weatherArchives=" + weatherArchives +
                '}';*/
    }

    public Integer getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public List<WeatherArchive> getWeatherArchives() {
        return weatherArchives;
    }
}
