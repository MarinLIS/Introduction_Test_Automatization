package ru.gb.lessons.lesson_06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveResultToDBService {

    private static final Logger logger
            = LoggerFactory.getLogger(SaveResultToDBService.class);

    //Объект подключения
    private static Connection connection;

    static {
        logger.info("Подключение к базе данных");
        connect("for_lesson_06.db");
    }

    //Создание подключений к СУБД
    private static void connect(String name) {
        try {
            //Регистрация драйвера
            Class.forName("org.sqlite.JDBC");
            //Создание подключения
            connection = DriverManager.getConnection("jdbc:sqlite:"+name);
        } catch ( Exception e ) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        logger.info("Подключение к базе данных успешно осуществлено");
    }

    //Метод добавление записи в таблицу employee_info
    public static void insertEmployeeInfo(String code, String url, String method, String time) {
        logger.info("Сохранение результата тестирования "+ url);
        String sql = "INSERT INTO data_result(status_code, request_url, request_method, request_time) VALUES(?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, code);
            pstmt.setString(2, url);
            pstmt.setString(3, method);
            pstmt.setString(4, time);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.info("Данные тестирования успешно сохранены"+ url);
    }
}

