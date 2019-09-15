package by.gsu.pmslab.Triangle;

public class EquilateralTriangle extends Triangle {

    private int x,y;
    private double side1;
    private String type;

    public EquilateralTriangle(){

    }

    public EquilateralTriangle(int x, int y, double side, String type) {
        this.x = x;
        this.y = y;
        this.side1 = side;
        this.type = type;
    }

    @Override
    public double square() {
        return side1*Math.sqrt(3);
    }

    @Override
    public void writeInfo() {
        System.out.println(side1 + ";" + type + ";" + x + ";" + y + ";" + square());
    }
}

