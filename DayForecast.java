package lesson7;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DayForecast {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private PartOfDay day;
    @JsonProperty("Night")
    private  PartOfDay night;

    public DayForecast() {
    }

    public String getDate() {
        return date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public PartOfDay getDay() {
        return day;
    }

    public PartOfDay getNight() {
        return night;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setDay(PartOfDay day) {
        this.day = day;
    }

    public void setNight(PartOfDay night) {
        this.night = night;
    }
}
