package ru.gb.homeworks.homework_04;

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
public class ProductsEntityTest extends AbstractTest{

    @Test
    @Order(1)
    void getProducts_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM products";
        Statement stmt = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(ProductsEntity.class);
        Assertions.assertEquals(10, countTableSize);
        Assertions.assertEquals(10, query.list().size());
    }


    @Order(2)
    @ParameterizedTest
    @CsvSource({"GOJIRA ROLL, 300.0", "VIVA LAS VEGAS ROLL, 450.0", "FUTOMAKI, 700.0", "TOOTSY MAKI, 133.0", "ZONIE ROLL, 254.0"})
    void getProductById_whenValid_shouldReturn(String menu_name, String price) throws SQLException {
        //given
        String sql = "SELECT * FROM products WHERE menu_name='" + menu_name + "'";
        Statement stmt  = getConnection().createStatement();
        String menuNameString = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            menuNameString = rs.getString(3);
        }
        //then
        Assertions.assertEquals(price, menuNameString);
    }


    @Test
    @Order(3)
    void addProduct_whenValid_shouldSave() {
        //given
        ProductsEntity entity = new ProductsEntity();
        entity.setProductId((short) 11);
        entity.setMenuName("вода из крана");
        entity.setPrice("9999.0");
        //when
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();

        final Query query = getSession()
                .createSQLQuery("SELECT * FROM products WHERE product_id=" + 11)
                .addEntity(ProductsEntity.class);
        ProductsEntity productsEntity = (ProductsEntity) query.uniqueResult();
        //then
        Assertions.assertNotNull(productsEntity);
        Assertions.assertEquals("вода из крана", productsEntity.getMenuName());
        Assertions.assertEquals("9999.0", productsEntity.getPrice());
    }


    @Test
    @Order(4)
    void deleteProduct_whenValid_shouldDelete() {
        //given
        final Query query = getSession()
                .createSQLQuery("SELECT * FROM products WHERE product_id=" + 11)
                .addEntity(ProductsEntity.class);
        Optional<ProductsEntity> productsEntity = (Optional<ProductsEntity>) query.uniqueResultOptional();
        Assumptions.assumeTrue(productsEntity.isPresent());
        //when
        Session session = getSession();
        session.beginTransaction();
        session.delete(productsEntity.get());
        session.getTransaction().commit();
        //then
        final Query queryAfterDelete = getSession()
                .createSQLQuery("SELECT * FROM products WHERE product_id=" + 11)
                .addEntity(ProductsEntity.class);
        Optional<ProductsEntity> productsEntityAfterDelete = (Optional<ProductsEntity>) queryAfterDelete
                .uniqueResultOptional();
        Assertions.assertFalse(productsEntityAfterDelete.isPresent());
    }
}
