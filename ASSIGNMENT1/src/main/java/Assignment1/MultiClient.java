package Assignment1;

//multiclient test on same stack
public class MultiClient {
    public static void main(String[] args) {
        try {
            //starting rmi registry if it not running
            try {
                java.rmi.registry.LocateRegistry.createRegistry(1099);
            } catch (Exception e) {
                System.out.println("Registery is alreday running...!");
            }

            // start the server
            CalculatorImplementation server = new CalculatorImplementation();
            java.rmi.Naming.rebind("CalculatorService", server);

            // Creating multiple threads and start
            for (int p = 1; p <= 6; p++) {
                int clientId = p;
                new Thread(() -> runClient(clientId)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runClient(int idnum) {
        try {
            Calculator calc = (Calculator) java.rmi.Naming.lookup("rmi://localhost/CalculatorService");
            System.out.println("Client " + idnum + " started.");

            // clients pushes some values
            calc.pushValue(idnum * 2);
            calc.pushValue(idnum * 3);

            //delay
            Thread.sleep(1000);

            // assigning operations for clients
            switch (idnum) {
                //minimum operation
                case 1:
                    calc.pushOperation("min");
                    System.out.println("Client " + idnum + " MINIMUM res: " + calc.pop());
                    break;
                    //maximum operation
                case 2:
                    calc.pushOperation("max");
                    System.out.println("Client " + idnum + " MAXIMUM res: " + calc.pop());
                    break;
                    //GCD
                case 3:
                    calc.pushOperation("gcd");
                    System.out.println("Client " + idnum + " GCD result: " + calc.pop());
                    break;
                    //LCM
                case 4:
                    calc.pushOperation("lcm");
                    System.out.println("Client " + idnum + " LCM res: " + calc.pop());
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

