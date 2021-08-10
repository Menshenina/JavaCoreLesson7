package lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty("Minimum")
    private TemperatureItem minimum;
    @JsonProperty("Maximum")
    private TemperatureItem maximum;

    public Temperature() {
    }

    public void setMinimum(TemperatureItem minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(TemperatureItem maximum) {
        this.maximum = maximum;
    }

    public TemperatureItem getMaximum() {
        return maximum;
    }

    public TemperatureItem getMinimum() {
        return minimum;
    }
}
