package ru.gb.seminars.seminar_04;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientTest extends AbstractTest {

    @Test
    void getClients_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM client";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(ClientEntity.class);
        //then
        Assertions.assertEquals(3, countTableSize);
        Assertions.assertEquals(3, query.list().size());
    }

    @Test
    void getCountTestORM() {
        //given
        //when
        final Query query = getSession().createSQLQuery("SELECT * FROM client")
                .addEntity(ClientEntity.class);
        //then
        Assertions.assertEquals(3, query.getResultList().size());

    }

    @ParameterizedTest
    @CsvSource({"1, Иванов", "2, Петров", "3, Сидоров"})
    void getClientById_whenValid_shouldReturn(int id, String lastName) throws SQLException {
        //given
        String sql = "SELECT * FROM client WHERE client_id=" + id;
        Statement stmt  = getConnection().createStatement();
        String nameResult = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            nameResult = rs.getString(3);
        }
        //then
        Assertions.assertEquals(lastName, nameResult);
    }
}
