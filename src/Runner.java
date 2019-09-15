import by.gsu.pmslab.*;
import by.gsu.pmslab.WriteInfo;

public class Runner {
    public static void main(String[] args) {

        WriteInfo [] infos = {
                new Triangle(12,12,2,3,4,"norm"),
                new Circle(0,1,3),
                new Rectangle(3,-2,3,4)
        };

        for (WriteInfo item : infos){
            item.writeInfo();
        }

    }
}
