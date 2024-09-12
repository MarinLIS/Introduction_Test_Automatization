
package ru.gb.homeworks.homework_03;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Name",
    "ID",
    "Ascending",
    "LocalDateTime",
    "EpochDateTime",
    "Value",
    "Category",
    "CategoryValue",
    "MobileLink",
    "Link"
})
@Generated("jsonschema2pojo")
public class Index {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Ascending")
    private Boolean ascending;
    @JsonProperty("LocalDateTime")
    private String localDateTime;
    @JsonProperty("EpochDateTime")
    private Integer epochDateTime;
    @JsonProperty("Value")
    private Double value;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("CategoryValue")
    private Integer categoryValue;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ID")
    public Integer getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Ascending")
    public Boolean getAscending() {
        return ascending;
    }

    @JsonProperty("Ascending")
    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
    }

    @JsonProperty("LocalDateTime")
    public String getLocalDateTime() {
        return localDateTime;
    }

    @JsonProperty("LocalDateTime")
    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    @JsonProperty("EpochDateTime")
    public Integer getEpochDateTime() {
        return epochDateTime;
    }

    @JsonProperty("EpochDateTime")
    public void setEpochDateTime(Integer epochDateTime) {
        this.epochDateTime = epochDateTime;
    }

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("CategoryValue")
    public Integer getCategoryValue() {
        return categoryValue;
    }

    @JsonProperty("CategoryValue")
    public void setCategoryValue(Integer categoryValue) {
        this.categoryValue = categoryValue;
    }

    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }

    @JsonProperty("MobileLink")
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

}
