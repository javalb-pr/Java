package by.gsu.pmslab;

public class Rectangle implements GeometricFigure, WriteInfo {

    private double width, height;
    int x,y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Rectangle(double width, double height) {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int x, int y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double square(){
        return width*height;
    }

    @Override
    public void writeInfo(){
        System.out.println(width + ";" + height + ";" +  x + ";" + y + ";" + square());
    }
}
