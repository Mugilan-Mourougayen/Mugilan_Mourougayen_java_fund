package services;

import dataModal.Insurance;
import dataModal.Medication;
import dataModal.Patient;
import dataModal.Prescription;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Physicaldatamodel {
    List<Insurance> insuranceList = new ArrayList<>();
    List<Medication> medicationList = new ArrayList<>();
    List<Prescription> prescriptionList = new ArrayList<>();
    public ArrayList readAllinsurance() throws ParseException {
        try {
            BufferedReader reader =new BufferedReader(new FileReader("resources/insurances.csv"));
            String line;
            reader.readLine();
            while((line=reader.readLine())!=null){
                String[]  values = line.split(";");
                int id =Integer.parseInt(values[0]);
                String name =values[1];

                Insurance insurance =  new Insurance(id,name);

                insuranceList.add(insurance);
            }
            System.out.println(insuranceList);
            return (ArrayList) insuranceList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public ArrayList readAllmedication() throws ParseException {
        try {
            BufferedReader reader =new BufferedReader(new FileReader("resources/medications.csv"));
            String line;
            reader.readLine();
            while((line=reader.readLine())!=null){
                String[]  values = line.split(";");
                int id =Integer.parseInt(values[0]);
                String medName=values[1];
                String medComment=values[2];

                Medication medication = new Medication(id,medName,medComment);
                medicationList.add(medication);
            }
            System.out.println(medicationList);
            return (ArrayList) medicationList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public ArrayList readAllprescription() throws ParseException {
        try {
            BufferedReader reader =new BufferedReader(new FileReader("resources/prescriptions.csv"));
            String line;
            reader.readLine();
            while((line=reader.readLine())!=null){
                String[]  values = line.split(";");

                int id =Integer.parseInt(values[0]);
                String ref =values[1];
                int code =Integer.parseInt(values[2]);
                int days =Integer.parseInt(values[3]);

                Prescription prescription=new Prescription(id,ref,code,days);
                prescriptionList.add(prescription);
            }
            System.out.println(prescriptionList);
            return (ArrayList) prescriptionList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
