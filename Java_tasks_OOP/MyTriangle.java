package com.mycompany.firsttask.triangle;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        checkVertex(x1, y1, x2, y2, x3, y3);
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        checkVertex(v1.getX(), v1.getY(), v2.getX(), v2.getY(), v3.getX(), v3.getY());
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=(" + v1.getX() + ',' + v1.getY() + ')' +
                ", v2=(" + v2.getX() + ',' + v2.getY() + ')' +
                ", v3=" + v3.getX() + ',' + v3.getY() + ')' +
                ']';
    }

    /**
     * Calculate the perimeter of a triangle
     *
     * @return the perimeter of a triangle
     */
    public double getPerimeter() {
        double firstSide = v1.distance(v2);
        double secondSide = v2.distance(v3);
        double thirdSide = v3.distance(v1);
        return firstSide + secondSide + thirdSide;
    }

    /**
     * Determines the type of triangle based on its sides
     *
     * @return triangle type
     */
    public TriangleType getType() {
        double firstSide = v1.distance(v2);
        double secondSide = v2.distance(v3);
        double thirdSide = v3.distance(v1);
        if ((Math.abs(firstSide - secondSide) < 0.000001) || (Math.abs(secondSide - thirdSide) < 0.000001) || (Math.abs(thirdSide - firstSide) < 0.000001)) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        boolean v1Equals = (v1 == null && that.v1 == null)
                || (v1 != null && v1.equals(that.v1));
        boolean v2Equals = (v2 == null && that.v2 == null)
                || (v2 != null && v2.equals(that.v2));
        boolean v3Equals = (v3 == null && that.v3 == null)
                || (v3 != null && v3.equals(that.v3));
        return v1Equals && v2Equals && v3Equals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (v1 == null ? 0 : v1.hashCode());
        result = 31 * result + (v2 == null ? 0 : v2.hashCode());
        result = 31 * result + (v3 == null ? 0 : v3.hashCode());
        return result;
    }

    /**
     * triangle types
     */
    public enum TriangleType {
        ISOSCELES,
        SCALENE
    }

    private void checkVertex(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) {
            throw new IllegalArgumentException("vertices cannot match");
        } else if ((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1)) {
            throw new IllegalArgumentException("vertices cannot be on the same straight line");
        }
    }
}
