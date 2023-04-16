package test;

import dataModal.Insurance;
import dataModal.Patient;
import services.InsuranceReader;
import services.PatientReader;

import java.text.ParseException;
import java.util.ArrayList;

public class TestOOP2 {
    public static void main(String[] args) throws ParseException {
        InsuranceReader insurancereader = new InsuranceReader();
        PatientReader patientreader = new PatientReader();
        insurancereader.readAll();
//        ArrayList<Insurance> readedallinsurance = new ArrayList<>(insurancereader.readAll());
        ArrayList<Patient> readedallpatient = new ArrayList<>(patientreader.readAll());



    }
}
