package by.gsu.pmslab;

public class Triangle extends GeometricFigure {

    private double side1, side2, side3;
    private String type;

    public Triangle(double side1, double side2, double side3, String type) {
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
        this.type = null;
    }

    public Triangle(int x, int y, double side1, double side2, double side3, String type) {
        super(x, y);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.type = type;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double square(){
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String writeInfo(){
        return side1 + ";" + side2 + ";" + side3 + ";" + type + ";" + super.writeInfo();
    }
}
