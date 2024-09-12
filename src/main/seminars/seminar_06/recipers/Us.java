
package ru.gb.seminars.seminar_06.recipers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "unitShort",
    "unitLong"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Us {

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("unitShort")
    private String unitShort;
    @JsonProperty("unitLong")
    private String unitLong;

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("unitShort")
    public String getUnitShort() {
        return unitShort;
    }

    @JsonProperty("unitShort")
    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    @JsonProperty("unitLong")
    public String getUnitLong() {
        return unitLong;
    }

    @JsonProperty("unitLong")
    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

}
