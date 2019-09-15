package by.gsu.pmslab;

public class Circle implements GeometricFigure, WriteInfo {

    private double radius;
    int x,y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Circle(double radius) {
        this.radius = 0;
    }

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
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
    public void writeInfo(){
        System.out.println(radius + ";" +  x + ";" + y + ";" + square());
    }
}
