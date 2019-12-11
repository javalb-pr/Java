package by.gsu.pms.model;

import java.util.concurrent.Callable;

public class CalculatorCallable implements Callable<Double> {
    private double result;
    private int number;

    public CalculatorCallable(double result, int number) {
        this.result = result;
        this.number = number;
    }

    @Override
    public Double call() throws Exception {
        return ThreadGenerator.getOperation().doOperation(result, number);
    }
}
