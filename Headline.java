package lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headline {

    @JsonProperty("EffectiveDate")
    private String effectiveDate;

    @JsonProperty("Text")
    private String text;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("EndDate")
    private String endDate;


    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Headline() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getEffectiveDate() {
        return effectiveDate;
    }


    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public String getEndDate() {
        return endDate;
    }

}
