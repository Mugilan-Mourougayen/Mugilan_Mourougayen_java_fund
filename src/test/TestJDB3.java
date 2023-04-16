package test;

import dataModal.Insurance;
import dataModal.Medication;
import dataModal.Patient;
import dataModal.Prescription;
import services.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestJDB3 {
    public static void main(String[] args) throws ParseException, SQLException {


//        read all Insurance
        Physicaldatamodel physicaldatamodel = new Physicaldatamodel();
        List<Insurance> insuranceList = new ArrayList<>(physicaldatamodel.readAllinsurance());
        List<Prescription> prescriptionList = new ArrayList<>(physicaldatamodel.readAllprescription());
        List<Medication> medicationList = new ArrayList<>(physicaldatamodel.readAllmedication());


//Create SQL Tbale with the list

        InsuranceDAO insuranceDAO = new InsuranceDAO();
        for (Insurance ins : insuranceList){
            insuranceDAO.CreateDAO(ins);
        }

        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        for (Prescription prescription : prescriptionList){
            prescriptionDAO.CreateDAO(prescription);
        }


        MedicationDAO medicationDAO = new MedicationDAO();
        for (Medication medication : medicationList){
            medicationDAO.CreateDAO(medication);
        }


//update SQL Tbale with the list
        insuranceDAO.UpadatDAO(1,"ABCD");
        prescriptionDAO.UpadatDAO(1,"12345");
        medicationDAO.UpadatDAO(2,"crocin");

// delete
//        insuranceDAO.DeleteDAO(1);
//        prescriptionDAO.DeleteDAO(1);
//        medicationDAO.DeleteDAO(1);

//       ###### the above 3 line of code delete the column which may lead to error in TESTJDB4 the code is commented


//DisplayAll
insuranceDAO.FindDAO();
prescriptionDAO.FindDAO();
medicationDAO.FindDAO();

    }

}
