package test;

import java.sql.*;
import java.util.Date;

public class TestJDB1 {
    public static void main(String[] args) throws SQLException {
        Connection collections= DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1 ");    // create connection


        PreparedStatement preparestatement=collections.prepareStatement("CREATE TABLE PATIENTS(id INT NOT NULL auto_increment,hcNumber VARCHAR (225), lastName VARCHAR (225), firstName VARCHAR (225),address VARCHAR (500),teleNum INT NOT NULL ,insuranceId INT NOT NULL,subDate  varchar(225))");  // write one line
        preparestatement.execute();



        PreparedStatement preparestatement2 = collections.prepareStatement("SELECT * FROM PATIENTS ");
        ResultSet resultSet =   preparestatement2.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("lastName");
            System.out.println(name);


        }



        collections.close();
    }
}
