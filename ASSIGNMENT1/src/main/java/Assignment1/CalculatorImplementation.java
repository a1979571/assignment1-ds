package Assignment1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
//IMPLEMENTATION FOR THE CALCULATOR
public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private final Stack<Integer> stack;

    public CalculatorImplementation() throws RemoteException {
        super();
        stack = new Stack<>();
    }

    @Override
    public synchronized void pushValue(int value) throws RemoteException {
        stack.push(value);
        System.out.println("VALUE PUSHED: " + value);
    }

    @Override
    public synchronized void pushOperation(String operator) throws RemoteException {
        if (stack.isEmpty()) return;

        int res;
        switch (operator.toLowerCase()) {
            case "min":
                res = stack.stream().min(Integer::compareTo).orElse(0);
                break;
            case "max":
                res = stack.stream().max(Integer::compareTo).orElse(0);
                break;
            case "lcm":
                res = stack.pop();
                while (!stack.isEmpty()) {
                    res = lcm(res, stack.pop());
                }
                stack.clear();
                break;
            case "gcd":
                res = stack.pop();
                while (!stack.isEmpty()) {
                    res = gcd(res, stack.pop());
                }
                stack.clear();
                break;
            default:
                System.out.println("operation unkown: " + operator);
                return;
        }
        stack.clear();
        stack.push(res);
        System.out.println("Operation used " + operator + " pushed result: " + res);
    }

    @Override
    public synchronized int pop() throws RemoteException {
        if (stack.isEmpty()) {
            System.out.println("Stack empty, returning 0");
            return 0;
        }
        return stack.pop();

    }

    @Override
    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public synchronized int delayPop(int millisec) throws RemoteException {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return pop();
    }

    // HELPING METHODS
    private int gcd(int p, int q) {
        return q == 0 ? Math.abs(p) : gcd(q, p % q);
    }

    private int lcm(int p, int q) {
        return Math.abs(p * q) / gcd(p, q);
    }
}

