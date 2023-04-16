package services;

import dataModal.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientBLService {
    public static Integer computeSeniority(Patient patient) {
        Date currentDate = new Date();
        Date patientdate= patient.getSubDate();
        long daysBetween = (currentDate.getTime() - patientdate.getTime()) / (24 * 60 * 60 * 1000);
        int intValue = (int) daysBetween/365;
        System.out.println(intValue);
        return intValue;
    }
    public static Map<String, Integer> computeSeniorityByPatient(List<Patient> patients) {
        Map<String, Integer> seniorityByPatient = new HashMap<>();

        for (Patient patient : patients) { //for each patient in patients list

            seniorityByPatient.put(patient.getFirstName(), computeSeniority(patient));
        }
        return seniorityByPatient;
    }
}
