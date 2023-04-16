package services;

import dataModal.Insurance;
import dataModal.Patient;
import dataModal.Prescription;

import java.sql.*;

public class InsuranceDAO {
    //    o Create a patient,  Done**
//    o Update a patient, Done
//    o Delete a patient, Done
//    o Search patients using search criteria,  Done name
    Connection connections;
    public InsuranceDAO() throws SQLException {

            connections = connect();
        PreparedStatement preparestatement=connections.prepareStatement("CREATE TABLE IF NOT EXISTS INSURANCES(id INT NOT NULL ,name VARCHAR (225))");  // write one line
        preparestatement.execute();


    }
    public  void CreateDAO(Insurance insurance) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("INSERT INTO INSURANCES (id, name) values (?,?)");
        preparestatement.setInt(1, insurance.getId());
        preparestatement.setString(2, insurance.getName());
        preparestatement.executeUpdate();

    }

    public void SearchbynameDAO(Integer id) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("SELECT * FROM INSURANCES WHERE id = ?");
        preparestatement.setInt(1, id);
        ResultSet resultSet =   preparestatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
        }
    }

    public void UpadatDAO(Integer id,String i_name) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("UPDATE INSURANCES SET name = ? WHERE id = ? ");
        preparestatement.setString(1, i_name);
        preparestatement.setInt(2, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");
    }

    public void DeleteDAO(Integer id) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("DELETE INSURANCES  WHERE id = ? ");
        preparestatement.setInt(1, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows Deleted");
    }

    public void FindDAO() throws SQLException {
        PreparedStatement preparestatement2 = connections.prepareStatement("SELECT * FROM INSURANCES ");
        ResultSet resultSet =   preparestatement2.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println(id +"  "+name);
        }

    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }
}
