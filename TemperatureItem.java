package lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureItem {
    @JsonProperty("Value")
    private double value;
    @JsonProperty("Unit")
    private String unit;


    public TemperatureItem() {
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
