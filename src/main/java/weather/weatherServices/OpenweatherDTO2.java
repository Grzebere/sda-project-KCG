package weather.weatherServices;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class OpenweatherDTO2 {
    private double lon;
    private double lat;
    private int currentDt;
    private double currentTemp;
    private int currentPressure;
    private int currentHumidity;
    private double currentWindSpeed;
    private int currentWindDeg;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getCurrentDt() {
        return currentDt;
    }

    public void setCurrentDt(int currentDt) {
        this.currentDt = currentDt;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public int getCurrentPressure() {
        return currentPressure;
    }

    public void setCurrentPressure(int currentPressure) {
        this.currentPressure = currentPressure;
    }

    public int getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(int currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public double getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public void setCurrentWindSpeed(double currentWindSpeed) {
        this.currentWindSpeed = currentWindSpeed;
    }

    public int getCurrentWindDeg() {
        return currentWindDeg;
    }

    public void setCurrentWindDeg(int currentWindDeg) {
        this.currentWindDeg = currentWindDeg;
    }

    @Override
    public String toString() {
        return "OpenweatherDTO2{" +
                "lon=" + lon +
                ", lat=" + lat +
                ", currentDt=" + currentDt +
                ", currentTemp=" + currentTemp +
                ", currentPressure=" + currentPressure +
                ", currentHumidity=" + currentHumidity +
                ", currentWindSpeed=" + currentWindSpeed +
                ", currentWindDeg=" + currentWindDeg +
                '}';
    }

    @JsonProperty("current")
    private void unpackNestedCurrent(Map<String, Object> current)  {
        this.currentDt = (int) current.get("dt");
        this.currentTemp = (double) current.get("temp");
        this.currentPressure = (int) current.get("pressure");
        this.currentHumidity = (int) current.get("humidity");
        this.currentWindSpeed = (double) current.get("wind_speed");
        this.currentWindDeg = (int) current.get("wind_deg");
    }

}
