package Assignment1;





import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

//RMI SERVER AUTOMATING TESSTING
//USING A SINGLE CLIENT
public class CalculatorTest {

    private static Calculator calci;

    @BeforeClass
    public static void setup() throws Exception {
        // STARTING RMI  IF IT IS NOT RUNNINGcd
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
            System.out.println("RMI REGISTRY IS ALREDAY RUNNING....!");
        }

        // STARTING THE SERVER
        CalculatorImplementation server = new CalculatorImplementation();
        Naming.rebind("CalculatorService", server);

        //SERVICE LOOKUP
        calci = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
    }

    @Test
    public void testPushAndPop() throws Exception {
        calci.pushValue(30);
        calci.pushValue(20);
        assertFalse(calci.isEmpty());
        int value = calci.pop();
        assertTrue(value == 20 || value == 30);
    }

    @Test
    public void testMinOperation() throws Exception {
        calci.pushValue(23);
        calci.pushValue(9);
        calci.pushValue(5);
        calci.pushOperation("min");
        int res = calci.pop();
        assertEquals(5, res);
    }

    @Test
    public void testMaxOperation() throws Exception {
        calci.pushValue(38);
        calci.pushValue(68);
        calci.pushValue(34);
        calci.pushOperation("max");
        int res = calci.pop();
        assertEquals(68, res);
    }

    @Test
    public void testGcdOperation() throws Exception {
        calci.pushValue(24);
        calci.pushValue(18);
        calci.pushOperation("gcd");
        int res = calci.pop();
        assertEquals(6, res);
    }

    @Test
    public void testLcmOperation() throws Exception {
        calci.pushValue(20);
        calci.pushValue(10);
        calci.pushOperation("lcm");
        int res = calci.pop();
        assertEquals(20, res);
    }

    @Test
    public void testDelayPop() throws Exception {
        calci.pushValue(30);
        long start = System.currentTimeMillis();
        int result = calci.delayPop(1000);
        long elapsed = System.currentTimeMillis() - start;
        assertEquals(30, result);
        assertTrue("Delay is  short...!", elapsed >= 1000);
    }
}


