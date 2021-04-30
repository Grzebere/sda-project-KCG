package weather.weatherServices;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

//Przykładowy dla Warszawy
class OpenWeathermap_Example {
    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=Warszawa&units=metric&appid=ed427a111d64798753394af633106470";
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();        OkHttpClient client = new OkHttpClient();        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }}


// Sprawdzenie obecnej pogody po podaniu miasta
class OpenWeathermap_current_1 {
    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q={miasto}&units=metric&appid=ed427a111d64798753394af633106470";
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();        OkHttpClient client = new OkHttpClient();        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }}

// Sprawdzanie obecnej pogody po podaniu długości i szerokości
class OpenWeathermap_current_2 {
    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?lat={szer}&lon={dług}&units=metric&appid=ed427a111d64798753394af633106470";
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();        OkHttpClient client = new OkHttpClient();        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }}

// Sprawdzenie pogody 5 dni do tyłu po podaniu szerokości , długości i daty
class OpenWeathermap_Historical {
    private final static String BASE_URL = "https://api.openweathermap.org/data/2.5/onecall/timemachine?lat={szer}&lon={dług}&units=metric&dt={data Unix}&appid=ed427a111d64798753394af633106470";
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();        OkHttpClient client = new OkHttpClient();        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }}

// Sprawdzenie pogody 5 dni do tyłu po podaniu miasta i daty
// Dostępne parts: "current (obecny),minutely (co minutę przez kolejną godzinę),hourly (co godzinę na następne 48 godzin),daily (codzienne przez 7 dni),alerts(narodowe alarmy pogodowe)" . Każdy part wyklucza nam daną część. Przykładowo: "current,minutely,hourly,alerts" pokaże nam tylko dzienne na kilka kolejnych dni.
class OpenWeathermap_Forecast {
    private final static String BASE_URL = "https://api.openweathermap.org/data/2.5/onecall?lat={szer}&lon={dług}&exclude={part}&appid=ed427a111d64798753394af633106470";
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();        OkHttpClient client = new OkHttpClient();        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }}


//
