package ru.gb.lessons.lesson_06;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "number",
    "step",
    "ingredients",
    "equipment",
    "length"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    @JsonProperty("number")
    private Integer number;
    @JsonProperty("step")
    private String step;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;
    @JsonProperty("equipment")
    private List<Equipment> equipment;
    @JsonProperty("length")
    private Length length;

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonProperty("step")
    public String getStep() {
        return step;
    }

    @JsonProperty("step")
    public void setStep(String step) {
        this.step = step;
    }

    @JsonProperty("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("equipment")
    public List<Equipment> getEquipment() {
        return equipment;
    }

    @JsonProperty("equipment")
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @JsonProperty("length")
    public Length getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Length length) {
        this.length = length;
    }

}
