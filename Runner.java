package by.gsu.pms;

import by.gsu.pms.model.ThreadGenerator;
import by.gsu.pms.model.TypeOfOperation;

public class Runner {
    public static void main(String[] args) {
        ThreadGenerator customGenerator = new ThreadGenerator();
        customGenerator.execute();
        System.out.println(customGenerator.getResult());
        ThreadGenerator forTaskGenerator = new ThreadGenerator(TypeOfOperation.MULTIPLICATION);
        forTaskGenerator.execute();
        System.out.println(forTaskGenerator.getResult());
    }
}
