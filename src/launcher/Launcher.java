package launcher;

import services.InsuranceReader;
import test.TestOOP1;

public class Launcher {
    public static void main(String[] args) {

        TestOOP1 testOOP1=new TestOOP1();
        testOOP1.printId();
        InsuranceReader ir =new InsuranceReader();
        ir.readAll();
    }
}

