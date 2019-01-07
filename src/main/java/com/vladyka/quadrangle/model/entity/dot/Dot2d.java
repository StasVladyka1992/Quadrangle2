package com.vladyka.quadrangle.model.entity.dot;

public class Dot2d implements Dot {
    private double x;
    private double y;

    public Dot2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Dot2d (){}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double[] getCoordinatesOfDot() {
        return new double[]{x,y};
    }

    @Override
    public String toString() {
        return "Dot:" + " x=" + x + ", y=" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot2d dot2d = (Dot2d) o;

        if (Double.compare(dot2d.x, x) != 0) return false;
        return Double.compare(dot2d.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}