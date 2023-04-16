package test;

import dataModal.Patient;
import services.PatientDAO;
import services.PatientReader;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestJDB2 {


    public static void main(String[] args) throws SQLException, ParseException {
        PatientDAO patientdao = new PatientDAO();
        PatientReader patientReader = new PatientReader();
       List<Patient> patientList = new ArrayList<>(patientReader.readAll()) ;
        PatientDAO patientDAO = new PatientDAO();

       for (Patient patient : patientList){
           patientDAO.CreateDAO(patient);

       }

       patientDAO.SearchbynameDAO("Julie" ,"Chalme");
        patientDAO.UpadatDAO("Julie" ,"Chalme","Mugilan","Mourougayen");
//        patientDAO.DeleteDAO("Paul");

        patientDAO.FindDAO();
    }

}
