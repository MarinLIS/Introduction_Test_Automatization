package homeworks.homework_03;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "ID",
        "Ascending",
        "Description"
})

public class MetaData {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Ascending")
    private Boolean ascending;
    @JsonProperty("Description")
    private String description;

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

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

}
