package by.gsu.pms.model;

public enum TypeOfOperation {
    ADDITION{
        double doOperation(double firstArgument, double secondArgument){
            return firstArgument + secondArgument;
        }
    },
    SUBTRACTION{
        double doOperation(double firstArgument, double secondArgument){
            return firstArgument - secondArgument;
        }
    },
    MULTIPLICATION{
        double doOperation(double firstArgument, double secondArgument){
            if (firstArgument == 0) firstArgument = 1;
            if (secondArgument == 0) secondArgument = 1;
            return firstArgument * secondArgument;
        }
    };

    abstract double doOperation(double firstArgument, double secondArgument);
}
