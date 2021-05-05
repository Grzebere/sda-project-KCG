package weather.weatherServices;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class WeatherFunctions {
    static String BASE_URL = "http://api.openweathermap.org/data/2.5/onecall";


    public static String getWeatherForDay(String longitude, String latitude, long day) throws IOException {
        final String url = "http://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=ed427a111d64798753394af633106470";
        ArrayList lista = new ArrayList(Arrays.asList("tempertayre: 1, dir: 123", "temerature: 20, dir: 333"));
        return getWeatherFromService(url);


    }

    public static String getWeatherByCoordinates(String longitude, String latitude) throws IOException {
        Date today = new Date();
        Date date = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        final String url = BASE_URL + "?lat=" + latitude + "&lon=" + longitude + "&units=metric&dt={" + date.getTime() + "}&appid=ed427a111d64798753394af633106470";
        return getWeatherFromService(url);
    }

     private static String getWeatherFromService(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }



}
