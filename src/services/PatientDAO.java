package services;

import dataModal.Patient;
import dataModal.Prescription;

import java.sql.*;
import java.util.Date;

public class PatientDAO {
//    o Create a patient,  Done**
//    o Update a patient, Done
//    o Delete a patient, Done
//    o Search patients using search criteria,  Done name
Connection connections;

    public PatientDAO() throws SQLException {
        connections = connect();
        PreparedStatement preparestatement=connections.prepareStatement("CREATE TABLE IF NOT EXISTS PATIENTS(id INT NOT NULL auto_increment,hcNumber VARCHAR (225), lastName VARCHAR (225), firstName VARCHAR (225),address VARCHAR (500),teleNum INT NOT NULL ,insuranceId INT NOT NULL,subDate  varchar(225))");  // write one line
        preparestatement.execute();
    }


    public void CreateDAO(Patient patient) throws SQLException {

        PreparedStatement preparestatement = connections.prepareStatement("INSERT INTO PATIENTS (hcNumber, lastName,firstName,address,teleNum,insuranceId,subDate) values (?,?,?,?,?,?,?)");


        preparestatement.setString(1, patient.getHcNumber());
        preparestatement.setString(2, patient.getlastName());
        preparestatement.setString(3, patient.getFirstName());
        preparestatement.setString(4, patient.getaddress());
        preparestatement.setInt(5, patient.getteleNum());
        preparestatement.setInt(6, patient.getinsuranceId());
        preparestatement.setString(7, String.valueOf(patient.getSubDate()));
        preparestatement.executeUpdate();

    }

    public void SearchbynameDAO(String fname,String lname) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("SELECT * FROM PATIENTS WHERE firstName = ? AND lastName= ?");
        preparestatement.setString(1, fname);
        preparestatement.setString(2, lname);
//        preparestatement.executeUpdate();

        ResultSet resultSet =   preparestatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("lastName");
            System.out.println(name);



        }

    }


    public void UpadatDAO(String fname,String lname,String Newfname,String Newlname) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("UPDATE PATIENTS SET firstName = ? WHERE firstName = ? AND lastName= ?");
//                                                                               UPDATE CUSTOMERS SET ADDRESS = 'Pune' WHERE ID = 6;
        preparestatement.setString(1, Newfname);
        preparestatement.setString(2, fname);
        preparestatement.setString(3, lname);
//        preparestatement.setString(4, lname);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");

    }
    public void DeleteDAO(String fname) throws SQLException {
        PreparedStatement preparestatement = connections.prepareStatement("DELETE PATIENTS  WHERE firstName = ? ");
        preparestatement.setString(1, fname);
        int resultSet =   preparestatement.executeUpdate();
        System.out.println(resultSet + " rows updated");

    }
    public void FindDAO() throws SQLException {
        PreparedStatement preparestatement2 = connections.prepareStatement("SELECT * FROM PATIENTS ");
        ResultSet resultSet =   preparestatement2.executeQuery();
        while (resultSet.next()) {
            String lname = resultSet.getString("lastName");
            String fname = resultSet.getString("firstName");
            System.out.println(fname +" and "+lname);


        }


    }
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }

}














