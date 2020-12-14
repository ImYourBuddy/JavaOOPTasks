package com.mycompany.firsttask.shapes;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("The radius should be > 0");
        } else {
            this.radius = radius;
        }
    }

    public Circle(double radius, String color) {
        if (radius <= 0) {
            throw new IllegalArgumentException("The radius should be > 0");
        } else {
            this.radius = radius;
        }
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
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
}
