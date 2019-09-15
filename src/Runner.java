import by.gsu.pmslab.*;

public class Runner {
    public static void main(String[] args) {
        GeometricFigure [] figures  = {
                new Triangle(12,12,2,3,4,"norm"),
                new Circle(0,1,3),
                new Rectangle(3,-2,3,4)
        };

        for (GeometricFigure item : figures){
            System.out.println(item.writeInfo());
        }
    }
}
