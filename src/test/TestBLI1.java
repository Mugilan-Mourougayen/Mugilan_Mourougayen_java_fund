package test;

import dataModal.Patient;
import services.PatientBLService;
import services.PatientReader;

import java.text.ParseException;
import java.util.ArrayList;

public class TestBLI1 {

    public static void main(String[] args) throws ParseException {
        PatientReader patientReader = new PatientReader();
        ArrayList<Patient> readedallpatient = new ArrayList<>(patientReader.readAll());
        PatientBLService seniority =new PatientBLService();
        seniority.computeSeniority(readedallpatient.get(5));


    }

}
