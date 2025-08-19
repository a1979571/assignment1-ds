package Assignment1;

import java.rmi.Naming;

// CLIENT FOR CALCULATOR SREVICE TESTING
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calci = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            //TESTING TH PUSHING(PUSH) VALUE
            calci.pushValue(20);
            calci.pushValue(92);

            // TESTING THE PUSHOPERATION FOR THE OPERTATIONS
            calci.pushOperation("gcd");
            System.out.println("RESULTS FOR GCD:" + calci.pop());

            //HERE WE ARE TESTING THE POP DELAYS
            calci.pushValue(34);
            calci.pushValue(56);
            calci.pushOperation("lcm");
            System.out.println("RESULTS FOR LCM AFTER DELAY: " + calci.delayPop(500));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

