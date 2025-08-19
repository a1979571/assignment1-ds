package Assignment1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
// HERE WE ARE REGISTERING THE CALCULATOR WITH  THE RMI REGISTERY
public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // STARTING THE RMI REGISTERY
            CalculatorImplementation calci = new CalculatorImplementation();
            Naming.rebind("CalculatorService", calci);
            System.out.println("RMI SERVER IS RUNNING");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
