
package ru.gb.seminars.seminar_06.recipers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "number",
    "unit"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @JsonProperty("number")
    private Double number;
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("number")
    public Double getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Double number) {
        this.number = number;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
