package by.gsu.pms.model;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadGenerator {
    private int poolSize;
    private static TypeOfOperation operation = TypeOfOperation.ADDITION;
    private int numericalInterval;
    private double result = 0;

    public ThreadGenerator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter thread pull size:");
        this.poolSize = scanner.nextInt();
        System.out.println("List of operations:");
        System.out.println("\taddition");
        System.out.println("\tsubtraction");
        System.out.println("\tmultiplication");
        System.out.println("\tdefault");
        System.out.println("Enter name of operation for threads results:");
        String inOperation = scanner.next();
        if (!inOperation.equals("default")){
            operation = TypeOfOperation.valueOf(inOperation.toUpperCase());
        }

        System.out.println("Enter numerical interval:");
        this.numericalInterval = scanner.nextInt();
    }

    public ThreadGenerator(TypeOfOperation typeOfOperation){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter thread pull size:");
        this.poolSize = scanner.nextInt();
        operation = typeOfOperation;
        System.out.println("Enter numerical interval:");
        this.numericalInterval = scanner.nextInt();
    }

    public void execute(){
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        IntStream.range(1, numericalInterval)
                .filter(number -> number % 4 == 0)
                .forEach(number -> {
                    try {
                        System.out.println(number);
                        result = executor.submit(new CalculatorCallable(result, number)).get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        executor.shutdown();
    }

    public double getResult() {
        return result;
    }

    public static TypeOfOperation getOperation() {
        return operation;
    }
}
