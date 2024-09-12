package ru.gb.homeworks.homework_03;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.gb.seminars.seminar_03.accuweather.Imperial;
import ru.gb.seminars.seminar_03.accuweather.Metric;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Metric",
    "Imperial"
})
@Generated("jsonschema2pojo")
public class Temperature {

    @JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;
    @JsonProperty("Maximum")
    private Maximum maximum;
    @JsonProperty("Minimum")
    private Minimum minimum;

    @JsonProperty("Metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("Metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    @JsonProperty("Imperial")
    public Imperial getImperial() {
        return imperial;
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    @JsonProperty("Imperial")
    public void setImperial(Imperial imperial) {
        this.imperial = imperial;
    }

}
