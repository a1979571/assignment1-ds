# Java RMI Calculator Assignment

## Overview

This project demonstrates a simple **distributed calculator system** using Java RMI. 

---
# Java RMI Server Methods

1.void pushValue(int val)
Pushes an integer val onto the stack.

2.void pushOperation(String operator)
Applies an operator ("min", "max", "lcm", "gcd") to all stack values and pushes the result.

3.int pop()
Pops and returns the top value of the stack.

4.boolean isEmpty()
Returns true or false 

5.int delayPop(int millis)

## Project Structure

| File                            | Description                                                                                                  |
| ------------------------------- | ---------------------------------------------------------------                                              |
| `Calculator.java`               | the interface that defines the remote operations implemented by your remote service.                         |
| `CalculatorImplementation.java` | the implementation class for the remote operations.                                                          |
| `CalculatorServer.java`         | Starts the RMI server.                                                                                       |
| `CalculatorClient.java`         | Client that connects to the server and tests operations.                                                     |
                                


## Compilation

---

## Running the RMI Server

1. Start the server:

```bash
java CalculatorServer
```
![Calculator UI](images/Server.jpeg)

---

## Running the Client
![Calculator UI](images/client.jpeg)
1. Open a new terminal window.
2. Run the client:

```bash
java CalculatorClient
```

---
## Testing 
```bash
java -cp .;C:\Users\91810\Downloads\junit-4.13.2.jar;C:\Users\91810\Downloads\hamcrest-core-1.3.jar org.junit.runner.JUnitCore Assignment1.CalculatorTest
```
![Calculator UI](images/test.jpeg)

---
## Testing Multiple Clients
```bash
java MultiClient

```
![Calculator UI](images/Multi-Client.jpeg)
---

