package weather.weatherServices;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class WeatherFunctions {

    public static String GetWeatherByCity(String region) throws IOException {
        final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=" + region + "&units=metric&appid=ed427a111d64798753394af633106470";
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }

    public static String GetWeatherByCoordinates(String longitude, String latitude) throws IOException {
        final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=ed427a111d64798753394af633106470";
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response.body().string();

    }


}
