
package ru.gb.seminars.seminar_03.spoonacular.recipers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "us",
    "metric"
})
@Generated("jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measures {

    @JsonProperty("us")
    private Us us;
    @JsonProperty("metric")
    private Metric metric;

    @JsonProperty("us")
    public Us getUs() {
        return us;
    }

    @JsonProperty("us")
    public void setUs(Us us) {
        this.us = us;
    }

    @JsonProperty("metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

}
