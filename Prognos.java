package lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prognos {
    @JsonProperty("Headline")
    private Headline Headline;
    @JsonProperty("DailyForecasts")
    private DayForecast[] DailyForecasts;

    public Prognos() {
    }
    public lesson7.Headline getHeadline() {
        return Headline;
    }
    public DayForecast[] getDailyForecasts() {
        return DailyForecasts;
    }
    public void setHeadline(lesson7.Headline headline) {
        Headline = headline;
    }
    public void setDailyForecasts(DayForecast[] dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
