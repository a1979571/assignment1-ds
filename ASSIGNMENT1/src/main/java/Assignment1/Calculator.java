package Assignment1;

import java.rmi.Remote;
import java.rmi.RemoteException;
// INTERFACE FOR CALCULATOR
public interface Calculator extends Remote {
    //PUSHING  THE INTEGER VALUE TO THE STACK
    void pushValue(int value) throws RemoteException;

  // HERRE WE ARE PUSHING THE FOUR OPERATIONS TO THE STACK ,THEN IT EXCUTES ALL THE FOUR OPERATIONS(MIN,MAX,LCM,GCD) AND THEN ITS GENERATES THE RESULTS
    void pushOperation(String operator) throws RemoteException;
    //HERE WE ARE DOING POP(REMOVING) THE FIRST(TOP) VALUE FROM THE STACK
    int pop() throws RemoteException;

    // HERE WE ARE CHECKING THAT THE STCAK IS EMPTY
    boolean isEmpty() throws RemoteException;

    // WAIT FOR SOME TIME(MILLI SECONDS) BEFORE ITS GETTING POP
    int delayPop(int millisec) throws RemoteException;
}

