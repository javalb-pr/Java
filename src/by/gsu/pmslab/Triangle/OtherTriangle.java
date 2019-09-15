package by.gsu.pmslab.Triangle;

public class OtherTriangle extends Triangle {


    private int x,y;
    private double side1, side2, side3;
    private String type;

    public OtherTriangle(){

    }

    public OtherTriangle(int x, int y, double side1, double side2, double side3, String type) {
        this.x = x;
        this.y = y;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.type = type;
    }

    @Override
    public double square() {
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public void writeInfo() {
        System.out.println(side1 + ";" + side2 + ";" + side3 + ";" + type + ";" + x + ";" + y + ";" + square());
    }
}
