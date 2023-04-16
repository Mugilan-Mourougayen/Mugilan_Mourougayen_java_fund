package services;

import dataModal.Insurance;
import dataModal.Medication;
import dataModal.Prescription;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Joindetail {

    Connection connections;
    public Joindetail() throws SQLException {
        connections = connect();
    }

    public  void Joiningcontext() throws SQLException, ParseException {



        PreparedStatement preparestatement = connections.prepareStatement("SELECT t1.hcNumber, t1.lastName, t1.firstName, t1.address, t1.teleNum, t1.insuranceId, t1.subDate, t2.name, t3.medName, t3.medComment, t4.precCode, t4.precDays FROM PATIENTS t1 JOIN INSURANCES t2 ON t1.insuranceId = t2.id JOIN PRESCRIPTIONS t4 ON t1.hcNumber = t4.precRef JOIN MEDICATIONS  t3 ON t4.precCode = t3.medName");

        ResultSet resultSet =   preparestatement.executeQuery();

        while (resultSet.next()) {
            String hcNumber = resultSet.getString("hcNumber");
            String lastName = resultSet.getString("lastName");
            String firstName = resultSet.getString("firstName");
            String address = resultSet.getString("address");
            String teleNum = resultSet.getString("teleNum");
            String insuranceId = resultSet.getString("insuranceId");
            String subDate = resultSet.getString("subDate");
            String name = resultSet.getString("name");
            String medName = resultSet.getString("medName");
            String medComment = resultSet.getString("medComment");
            String precCode = resultSet.getString("precCode");
            int precDays = resultSet.getInt("precDays");

            System.out.println(hcNumber + ", " + lastName + ", " + firstName + ", " + address + ", " + teleNum + ", " + insuranceId + ", " + subDate + ", " + name + ", " + medName + ", " + medComment + ", " + precCode + ", " + precDays);
        }






    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    }
}
