package services;

import dataModal.Medication;
import dataModal.Patient;
import dataModal.Prescription;

import java.sql.*;

public class MedicationDAO {

    //    o Create a patient,  Done**
//    o Update a patient, Done
//    o Delete a patient, Done
//    o Search patients using search criteria,  Done name
    Connection connections;
//
    public MedicationDAO() throws SQLException {

        connections = connect();
        PreparedStatement preparestatement=connections.prepareStatement("CREATE TABLE IF NOT EXISTS MEDICATIONS(medCode INT NOT NULL ,medName VARCHAR (225), medComment VARCHAR (225))");  // write one line
        preparestatement.execute();
    }

    public void CreateDAO(Medication medication) throws SQLException {

        PreparedStatement preparestatement = connections.prepareStatement("INSERT INTO MEDICATIONS (medCode ,medName, medComment) values (?,?,?)");


        preparestatement.setInt(1, medication.getMedCode());
        preparestatement.setString(2, medication.getMedName());
        preparestatement.setString(3, medication.getMedComment());

        preparestatement.executeUpdate();
    }

    public void SearchbynameDAO(Integer medcode) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("SELECT * FROM MEDICATIONS WHERE medCode = ?");
        preparestatement.setInt(1, medcode);


        ResultSet resultSet =   preparestatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("medName");
            System.out.println(name);



        }
    }


    public void UpadatDAO(Integer id,String medname) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("UPDATE MEDICATIONS SET medName = ? WHERE medCode = ? ");
        preparestatement.setString(1, medname);
        preparestatement.setInt(2, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");


    }

    public void DeleteDAO(Integer id) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("DELETE MEDICATIONS  WHERE medCode = ? ");
        preparestatement.setInt(1, id);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");

    }

    public void FindDAO() throws SQLException {
        PreparedStatement preparestatement2 = connections.prepareStatement("SELECT * FROM MEDICATIONS ");
        ResultSet resultSet = preparestatement2.executeQuery();

        while (resultSet.next()) {
            String medCode = resultSet.getString("medCode");
            String medName = resultSet.getString("medName");
            String medComment = resultSet.getString("medComment");


            System.out.println(medCode + "  " + medName + " " + medComment);


        }

    }
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }
}
