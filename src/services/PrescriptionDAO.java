package services;

import dataModal.Patient;
import dataModal.Prescription;

import java.sql.*;

public class PrescriptionDAO{

    //    o Create a patient,  Done**
//    o Update a patient, Done
//    o Delete a patient, Done
//    o Search patients using search criteria,  Done name
    Connection connections;


    public PrescriptionDAO() throws SQLException {
        connections = connect();
        PreparedStatement preparestatement=connections.prepareStatement("CREATE TABLE IF NOT EXISTS PRESCRIPTION(precId INT NOT NULL , precRef varchar(225) , precCode INT NOT NULL ,precDays INT NOT NULL )");  // write one line
        preparestatement.execute();

    }

//private Integer precId precRef precCode  precDays;


    public void CreateDAO(Prescription prescription) throws SQLException {

        PreparedStatement preparestatement = connections.prepareStatement("INSERT INTO PRESCRIPTION (precId, precRef, precCode, precDays) values (?,?,?,?)");


        preparestatement.setInt(1, prescription.getPrecId());
        preparestatement.setString(2, prescription.getPrecRef());
        preparestatement.setInt(3, prescription.getPrecCode());
        preparestatement.setInt(4, prescription.getPrecDays());

        preparestatement.executeUpdate();
    }
//
    public void SearchbynameDAO(String prescref) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("SELECT * FROM PRESCRIPTION WHERE  prescRef= ?");
        preparestatement.setString(1, prescref);
        ResultSet resultSet =   preparestatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("prescRef");
            System.out.println(name);



        }

    }


    public void UpadatDAO(Integer id,String name) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("UPDATE PRESCRIPTION SET precRef = ? WHERE precId = ? ");
        preparestatement.setString(1, name);
        preparestatement.setInt(2, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");

    }


    public void DeleteDAO(Integer id) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("DELETE PRESCRIPTION  WHERE precId = ? ");
        preparestatement.setInt(1, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");

    }

    public void FindDAO() throws SQLException {
        PreparedStatement preparestatement2 = connections.prepareStatement("SELECT * FROM PRESCRIPTION ");
        ResultSet resultSet =   preparestatement2.executeQuery();

        while (resultSet.next()) {
            String precId = resultSet.getString("precId");
            String precRef = resultSet.getString("precRef");
            String precCode = resultSet.getString("precCode");
            String precDays = resultSet.getString("precDays");
            System.out.println(precId +"  "+precRef+ " "+precCode+" "+precDays);


        }

    }
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }

}
