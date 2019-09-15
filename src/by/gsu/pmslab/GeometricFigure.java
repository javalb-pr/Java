package by.gsu.pmslab;

public class GeometricFigure {

    private int x, y;

    public GeometricFigure(){
        this.x = 0;
        this.y = 0;

    }

    public GeometricFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double square(){
        return 0;
    }

    public String writeInfo(){
        return x + ";" + y + ";" + square();
    }
}
