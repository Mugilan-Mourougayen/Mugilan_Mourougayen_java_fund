package test;

import dataModal.Patient;

import services.PatientBLService;
import services.PatientReader;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestBLI2 {
    public static void main(String[] args) throws IOException, ParseException {
        PatientReader patientReader = new PatientReader();
        ArrayList<Patient> readedallpatient = new ArrayList<>(patientReader.readAll());
        PatientBLService ps = new PatientBLService();
        Map<String, Integer> seniorityByPatient = ps.computeSeniorityByPatient(readedallpatient);

        System.out.println(seniorityByPatient);
    }
}