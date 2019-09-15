package by.gsu.pmslab;

public class Circle extends GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = 0;
    }

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double square(){
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public String writeInfo(){
        return radius + ";" + super.writeInfo();
    }
}
