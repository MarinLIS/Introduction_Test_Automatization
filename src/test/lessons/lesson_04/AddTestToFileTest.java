package ru.gb.lessons.lesson_04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Disabled
public class AddTestToFileTest {

    //Объект подключения
    private static Connection connection;
    String csvFile = "C:\\Users\\gepat\\Documents\\training at GeekBrains\\Introduction to Test Automation\\Introduction_to_Test_Automation\\src\\test\\resources\\request_type.csv";

    @BeforeAll
    static void init() {
        connect("project.db");
    }

    @Test
    void addDataToDB() {

        int id = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            String line = "";
            String cvsSplitBy = ";";
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);

                insertRequestInfo(id, lines[0],lines[1],lines[2],lines[3]);
                id++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertRequestInfo(Integer id, String name, String weight, String description, String status) {
        String sql = "INSERT INTO request_type(" +
                     "id, request_name, weight, description, status) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, weight);
            pstmt.setString(4, description);
            pstmt.setString(5, String.valueOf(GenerateFileTest.StatusType.valueOf(status).getCode()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static int id=1;

    @ParameterizedTest
    @CsvFileSource(resources = "/request_type.csv", numLinesToSkip = 0, delimiterString = ";")
    void addDataToDB(String name, String weight, String description, String status) {
        insertRequestInfo(id, name, weight, description, status);
        id++;
    }


    @Test
    void createFilesToImport() throws IOException {
        int id=1;
        String sql = "INSERT INTO request_type(" +
                     "id, request_name, weight, description, status)" +
                     " VALUES (%s, '%s', '%s', '%s', '%s');";
        try (FileWriter fileWriterSQLInsert = new FileWriter("insert_objects.sql");
             PrintWriter printWriterSQLInsert = new PrintWriter(fileWriterSQLInsert);
             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line = "";
            String cvsSplitBy = ";";
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);

                printWriterSQLInsert.printf(sql + '\n', id, lines[0], lines[1], lines[2], lines[3]);
                printWriterSQLInsert.printf("" + '\n');
                id++;
            }

        }
    }

    //Создание подключений к СУБД
    private static void connect(String name) {
        try {
            //Регистрация драйвера
            Class.forName("org.sqlite.JDBC");
            //Создание подключения
            connection = DriverManager.getConnection("jdbc:sqlite:" + name);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
