package ru.gb.lessons.lesson_04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Disabled
public class GenerateFileTest {

    static List<RequestType> requestTypes = new ArrayList<RequestType>(10000);

    @BeforeAll
    static void init() {
        Random random = new Random();
        Faker faker = new Faker();
        for(int i=0; i<10000; i++) {
            requestTypes.add(new RequestType(faker.code().asin().toUpperCase(),
                    String.valueOf(random.nextInt(100)),
                    "DESCRIPTION",
                    StatusType.randomDirection()));
        }
    }

    @Test
    void generateFileCSVTest() throws IOException {

        File csvFile = new File("src/test/resources/request_type.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        for (RequestType data : requestTypes) {
            StringBuilder line = new StringBuilder();
            line.append(data.getName()+';');
            line.append(data.getWeight()+';');
            line.append(data.getDescription()+';');
            line.append(data.getStatusType().name()+';');

            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }

    private static class RequestType {
        private String name;
        private String weight;
        private String description;
        private StatusType statusType;

        public RequestType(String name, String weight, String description, StatusType statusType) {
            this.name = name;
            this.weight = weight;
            this.description = description;
            this.statusType = statusType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public StatusType getStatusType() {
            return statusType;
        }

        public void setStatusType(StatusType statusType) {
            this.statusType = statusType;
        }
    }

    public enum StatusType {
        NEW(0),
        OLD(1),
        CANCELED(2);

        private int code;

        StatusType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        private static final Random PRNG = new Random();

        public static StatusType randomDirection()  {
            StatusType[] statusTypes = values();
            return statusTypes[PRNG.nextInt(statusTypes.length)];
        }
    }
}
