package homeworks.homework_04;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdersProductsTest extends AbstractTest {

    @Test
    @Order(1)
    void getOrdersProducts_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM orders_products";
        Statement stmt = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(OrdersProductsEntity.class);
        Assertions.assertEquals(23, countTableSize);
        Assertions.assertEquals(23, query.list().size());
    }


    @Order(2)
    @ParameterizedTest
    @CsvSource({"1, 10", "4, 7", "9, 3", "12, 10", "15, 8"})
    void getOrdersProductsById_whenValid_shouldReturn(String order_id, String product_id) throws SQLException {
        //given
        String sql = "SELECT * FROM orders_products WHERE order_id='" + order_id + "'";
        Statement stmt  = getConnection().createStatement();
        String orderIdString = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            orderIdString = rs.getString(2);
        }
        //then
        Assertions.assertEquals(product_id, orderIdString);
    }


    @Test
    @Order(3)
    void addOrdersProducts_whenValid_shouldSave() {
        //given
        OrdersProductsEntity entity = new OrdersProductsEntity();
        entity.setOrderId((short) 16);
        entity.setProductId((short) 66);
        entity.setQuantity((short) 99);
        //when
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();

        final Query query = getSession()
                .createSQLQuery("SELECT * FROM orders_products WHERE order_id=" + 16)
                .addEntity(OrdersProductsEntity.class);
        OrdersProductsEntity ordersProductsEntity = (OrdersProductsEntity) query.uniqueResult();
        //then
        Assertions.assertNotNull(ordersProductsEntity);
        Assertions.assertEquals(16, ordersProductsEntity.getOrderId());
        Assertions.assertEquals(66, ordersProductsEntity.getProductId());
        Assertions.assertEquals(99, ordersProductsEntity.getQuantity());
    }


    @Test
    @Order(4)
    void deleteOrdersProducts_whenValid_shouldDelete() {
        //given
        final Query query = getSession()
                .createSQLQuery("SELECT * FROM orders_products WHERE order_id=" + 16)
                .addEntity(OrdersProductsEntity.class);
        Optional<OrdersProductsEntity> products = (Optional<OrdersProductsEntity>) query.uniqueResultOptional();
        Assumptions.assumeTrue(products.isPresent());
        //when
        Session session = getSession();
        session.beginTransaction();
        session.delete(products.get());
        session.getTransaction().commit();
        //then
        final Query queryAfterDelete = getSession()
                .createSQLQuery("SELECT * FROM orders_products WHERE order_id=" + 16)
                .addEntity(OrdersProductsEntity.class);
        Optional<OrdersProductsEntity> productsAfterDelete = (Optional<OrdersProductsEntity>) queryAfterDelete
                .uniqueResultOptional();
        Assertions.assertFalse(productsAfterDelete.isPresent());
    }
}
