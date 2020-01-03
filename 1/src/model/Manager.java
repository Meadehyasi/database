package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Manager {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "amirsam", "myjava123");
        //////////////////////////////////////
        connection.setAutoCommit(false);
        ///////////////////////////////////////////
        PreparedStatement preparedStatement = connection.prepareStatement("update account set total=total-? where id=?");
        preparedStatement.setLong(1, 100);
        preparedStatement.setLong(2, 1);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("update account set total=total+? where id=?");
        preparedStatement.setLong(1, 100);
        preparedStatement.setLong(2, 2);
        preparedStatement.executeUpdate();
        /////////////////////////////////////////
        connection.commit();
        /////////////////////////////////////////
        preparedStatement.close();
        connection.close();
    }
}
