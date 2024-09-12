package homeworks.homework_04;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryEntityTest extends AbstractTest{

    @Test
    void getDelivery_whenValid_shouldReturn() throws SQLException {
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
    @CsvSource({"1, 3", "2, 4", "3, 1"})
    void getDeliveryById_whenValid_shouldReturn(String delivery_id, String courier_id) throws SQLException {
        //given
        String sql = "SELECT * FROM delivery WHERE delivery_id='" + delivery_id + "'";
        Statement stmt  = getConnection().createStatement();
        String deliveryIdString = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            deliveryIdString = rs.getString(3);
        }
        //then
        Assertions.assertEquals(courier_id, deliveryIdString);
    }
}
