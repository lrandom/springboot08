package niit.com.vn.springboot08.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    protected Connection connection = null;

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring-jdbc", "root", "koodinh@");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
    }
    
}
