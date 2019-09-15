package by.gsu.pmslab;

public class Rectangle extends GeometricFigure {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int x, int y, double width, double height) {
        super(x, y);
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
    public String writeInfo(){
        return width + ";" + height + ";" + super.writeInfo();
    }
}
