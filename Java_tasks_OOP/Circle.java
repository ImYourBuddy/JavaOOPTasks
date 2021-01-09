package com.mycompany.firsttask.shapes;

import java.util.Objects;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        if (Math.abs(radius) < 0.000001 || radius < 0) {
            throw new IllegalArgumentException("The radius should be > 0");
        } else {
            this.radius = radius;
        }
    }

    public Circle(double radius, String color) {
        this(radius);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (Math.abs(radius) < 0.000001 || radius < 0) {
            throw new IllegalArgumentException("The radius should be > 0");
        } else {
            this.radius = radius;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ']';
    }

    /**
     * Calculate the area of a circle
     * @return the area of a circle
     */
    public double getArea () {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        boolean radiusEquals = (Math.abs(radius - circle.radius) < 0.000001);
        boolean colorEquals = (color == null && circle.color == null)
                || (color != null && color.equals(circle.color));
        return radiusEquals && colorEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result +  Double.hashCode(radius);
        result = 31 * result + (color == null ? 0 : color.hashCode());
        return result;
    }
}
