package main.java.lesson7;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.Prognos;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Main {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = "Wa7nWgbZceLLb5MA4UoeZTErPtyk6tgA";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String LANGUAGES_KEY_PARAM = "ru-ru";
    private static final String LANGUAGES_KEY = "language";
    public static void main(String[] args) throws IOException {

        String selectedCity = "Moscow";

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(ONE_DAY)
                .addPathSegment(detectCityKey(selectedCity))
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(LANGUAGES_KEY_PARAM, LANGUAGES_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayForecastResponse.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Prognos prognos = objectMapper.readValue(weatherResponse, Prognos.class);

        StringBuilder result = new StringBuilder();
        result.append("Сегодня в Москве температура от ");
        result.append(prognos.getDailyForecasts()[0].getTemperature().getMinimum().getValue());
        result.append(" до ");
        result.append(prognos.getDailyForecasts()[0].getTemperature().getMaximum().getValue());
        result.append(" градусов Фаренгейта ");
        System.out.println(result);
    }

    private static String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}
