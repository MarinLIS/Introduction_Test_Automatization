package ru.gb.homeworks.homework_04;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersEntityTest extends AbstractTest{

    @Test
    void getOrder_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM delivery";
        Statement stmt = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(DeliveryEntity.class);
        Assertions.assertEquals(15, countTableSize);
        Assertions.assertEquals(15, query.list().size());
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 4", "5, 5"})
    void getOrdersById_whenValid_shouldReturn(String order_id, String customer_id) throws SQLException {
        //given
        String sql = "SELECT * FROM orders WHERE order_id='" + order_id + "'";
        Statement stmt  = getConnection().createStatement();
        String orderIdString = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            orderIdString = rs.getString(2);
        }
        //then
        Assertions.assertEquals(customer_id, orderIdString);
    }
}
