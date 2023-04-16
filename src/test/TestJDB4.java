package test;

import services.Joindetail;
import services.PatientDAO;
import services.PatientReader;

import java.sql.SQLException;
import java.text.ParseException;

public class TestJDB4 {
    public static void main(String[] args) throws SQLException, ParseException {
        System.out.println("due to connection issue the data in memory is not stable" +
                "");
        Joindetail joindetail=new Joindetail();
        joindetail.Joiningcontext();

    }
}
