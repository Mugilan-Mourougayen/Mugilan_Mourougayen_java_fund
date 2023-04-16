package services;

import dataModal.Insurance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceReader {

  public void readAll(){
      List<Insurance>  insuranceList = new ArrayList<>();
      try {
          BufferedReader reader =new BufferedReader(new FileReader("resources/insurances.csv"));
          String line;
          reader.readLine();
          while((line=reader.readLine())!=null){
              String[]  values = line.split(";");
              int id = Integer.valueOf(values[0]);
              String name=values[1];
              Insurance insurance=new Insurance(id,name);
            insuranceList.add(insurance);
          }
          System.out.println(insuranceList);

      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }

}
