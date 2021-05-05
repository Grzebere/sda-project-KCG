package weather.weatherServices;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class OpenweatherDTO {

    private double coordLon;
    private double coordLat;
    private double mainTemp;
    private int mainPressure;
    private int mainHumidity;
    private long dt;
    private String sysCountry;
    private String timezone;
    private int id;
    private String name;
    private long date;

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    public double getMainTemp() {
        return mainTemp;
    }

    public void setMainTemp(double mainTemp) {
        this.mainTemp = mainTemp;
    }

    public int getMainPressure() {
        return mainPressure;
    }

    public void setMainPressure(int mainPressure) {
        this.mainPressure = mainPressure;
    }

    public int getMainHumidity() {
        return mainHumidity;
    }

    public void setMainHumidity(int mainHumidity) {
        this.mainHumidity = mainHumidity;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getSysCountry() {
        return sysCountry;
    }

    public void setSysCountry(String sysCountry) {
        this.sysCountry = sysCountry;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OpenweatherDTO{" +
                "coordLon=" + coordLon +
                ", coordLat=" + coordLat +
                ", mainTemp=" + mainTemp +
                ", mainPressure=" + mainPressure +
                ", mainHumidity=" + mainHumidity +
                ", dt=" + dt +
                ", sysCountry='" + sysCountry + '\'' +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("coord")
    private void unpackNestedCoord(Map<String, Object> coord) {
        this.coordLon = (double) coord.get("lon");
        this.coordLat = (double) coord.get("lat");
        /*
        this.sysCountry = (String) sys.get("country");*/
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("main")
    private void unpackNestedMain(Map<String, Object> main) {
        this.mainTemp = (double) main.get("temp");
        this.mainPressure = (int) main.get("pressure");
        this.mainHumidity = (int) main.get("humidity");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("sys")
    private void unpackNestedSys(Map<String, Object> sys) {
        this.sysCountry = (String) sys.get("country");
    }


}


