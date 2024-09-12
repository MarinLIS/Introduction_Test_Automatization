package ru.gb.lessons.lesson_04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.*;

@Disabled
public class DBTest {

    //Объект подключения
    private static Connection connection;

    @BeforeAll
    static void init() {
        connect("project.db");
    }

    @Test
    void testConstraintStatus() {
        Assertions.assertThrows(SQLException.class, () -> insertRequestInfo(100000, null, "10", "", "OLD"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> insertRequestInfo(100000, null, "10", "", "NotValue"));
    }

    @Test
    void insert() throws SQLException {
        insertRequestInfo(100001, "name", "10", "", "OLD");
        String sql = "SELECT * FROM request_type";

        Statement stmt  = connection.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Assertions.assertNotNull(rs);
        int countTableSize = 0;
        // loop through the result set
        while (rs.next()) {
            countTableSize++;
        }
        Assertions.assertEquals(10001,countTableSize);
    }

    @Test
    void testDictStatus() throws SQLException {
        String sql = "SELECT * FROM status";

        Statement stmt  = connection.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Assertions.assertNotNull(rs);
        int countTableSize = 0;
        // loop through the result set
        while (rs.next()) {
            Assertions.assertNotNull(GenerateFileTest.StatusType.valueOf(rs.getString("status_name")));
            countTableSize++;
        }
        Assertions.assertEquals(3,countTableSize);
    }

    private void insertRequestInfo(Integer id, String name, String weight, String description, String status) throws SQLException {
        String sql = "INSERT INTO request_type(" +
                     "id, request_name, weight, description, status) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, weight);
        pstmt.setString(4, description);
        pstmt.setString(5, String.valueOf(GenerateFileTest.StatusType.valueOf(status).getCode()));
        pstmt.executeUpdate();
    }

    //Создание подключений к СУБД
    private static void connect(String name) {
        try {
            //Регистрация драйвера
            Class.forName("org.sqlite.JDBC");
            //Создание подключения
            connection = DriverManager.getConnection("jdbc:sqlite:"+name);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
