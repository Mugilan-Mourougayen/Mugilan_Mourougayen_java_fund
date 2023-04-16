package services;

import dataModal.Insurance;
import dataModal.Patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientReader {
    List<Patient> patientList = new ArrayList<>();
    public ArrayList readAll() throws ParseException {
        try {
            BufferedReader reader =new BufferedReader(new FileReader("resources/patients.csv"));
            String line;
            reader.readLine();
            while((line=reader.readLine())!=null){
                String[]  values = line.split(";");
//                Integer hcNumber, String firstName, String lastName, String address, Integer teleNum, Integer insuranceId, String subDate\

//                System.out.println(values[]/**/);
                String hcnum =values[0];
                String lastname=values[1];
                String firstname=values[2];
                String address=values[3];
                Integer tel=Integer.parseInt(values[4].replace("\"",""));
                int id =Integer.parseInt(values[5]);

                Date date=new SimpleDateFormat("dd/MM/yyyy").parse(values[6]);

                Patient patient=new Patient(hcnum,lastname,firstname,address,tel,id,date);
                patientList.add(patient);
            }
            System.out.println(patientList);
            return (ArrayList) patientList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
