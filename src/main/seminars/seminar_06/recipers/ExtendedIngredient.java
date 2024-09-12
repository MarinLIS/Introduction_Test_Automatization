
package ru.gb.seminars.seminar_06.recipers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "aisle",
    "image",
    "consistency",
    "name",
    "nameClean",
    "original",
    "originalName",
    "amount",
    "unit",
    "meta",
    "measures"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedIngredient {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("image")
    private String image;
    @JsonProperty("consistency")
    private String consistency;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameClean")
    private String nameClean;
    @JsonProperty("original")
    private String original;
    @JsonProperty("originalName")
    private String originalName;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("meta")
    private List<String> meta;
    @JsonProperty("measures")
    private Measures measures;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("aisle")
    public String getAisle() {
        return aisle;
    }

    @JsonProperty("aisle")
    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("consistency")
    public String getConsistency() {
        return consistency;
    }

    @JsonProperty("consistency")
    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameClean")
    public String getNameClean() {
        return nameClean;
    }

    @JsonProperty("nameClean")
    public void setNameClean(String nameClean) {
        this.nameClean = nameClean;
    }

    @JsonProperty("original")
    public String getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    @JsonProperty("originalName")
    public String getOriginalName() {
        return originalName;
    }

    @JsonProperty("originalName")
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("meta")
    public List<String> getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(List<String> meta) {
        this.meta = meta;
    }

    @JsonProperty("measures")
    public Measures getMeasures() {
        return measures;
    }

    @JsonProperty("measures")
    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

}
