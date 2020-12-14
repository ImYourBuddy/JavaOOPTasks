package com.mycompany.firsttask.triangle;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] pointCoordinates = new int[]{x, y};
        return  pointCoordinates;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    /**
     * Calculate the distance from this point to the given point at (x, y)
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return Distance between points
     */
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    /**
     * Calculate the distance from this point to the given instance of MyPoint
     * @param another The point to which the distance is calculated
     * @return Distance between points
     */
    public double distance(MyPoint another) {
        return this.distance(another.getX(), another.getY());
    }

    /**
     * Calculate the distance from this point to (0,0)
     * @return Distance between this point and (0,0)
     */
    public double distance() {
        return this.distance(0, 0);
    }
}
