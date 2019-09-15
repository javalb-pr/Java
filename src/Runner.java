import by.gsu.pmslab.*;
import by.gsu.pmslab.Triangle.EquilateralTriangle;
import by.gsu.pmslab.Triangle.OtherTriangle;
import by.gsu.pmslab.Triangle.Triangle;
import by.gsu.pmslab.WriteInfo;

public class Runner {
    public static void main(String[] args) {

        WriteInfo [] infos = {
                new OtherTriangle(12,12,2,3,4,"norm"),
                new EquilateralTriangle(34,2,5,"equil"),
                new Circle(0,1,3),
                new Rectangle(3,-2,3,4)
        };

        for (WriteInfo item : infos){
            item.writeInfo();
        }

    }
}
