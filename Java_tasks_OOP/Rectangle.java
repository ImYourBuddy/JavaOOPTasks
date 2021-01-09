package com.mycompany.firsttask.shapes;

import java.util.Objects;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        if (Math.abs(length) < 0.000001 || length < 0.0) {
            throw new IllegalArgumentException("The length should be > 0");
        } else if (Math.abs(length) < 0.000001 || length < 0.0) {
            throw new IllegalArgumentException("The width should be > 0");
        } else {
            this.length = length;
            this.width = width;
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if (Math.abs(length) < 0.000001 || length < 0.0) {
            throw new IllegalArgumentException("The length should be > 0");
        } else {
            this.length = length;
        }
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (Math.abs(length) < 0.000001 || length < 0.0) {
            throw new IllegalArgumentException("The width should be > 0");
        } else {
            this.width = width;
        }
    }

    /**
     * Calculate the area of a rectangle
     *
     * @return the area of a rectangle
     */
    public double getArea() {
        return length * width;
    }

    /**
     * Calculate the perimeter of a rectangle
     *
     * @return the perimeter of a rectangle
     */
    public double getPerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public String toString() {
        return "Rectangle[" +
                "length=" + length +
                ", width=" + width +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        boolean lengthEquals = (Math.abs(length - rectangle.length) < 0.000001);
        boolean widthEquals = (Math.abs(width - rectangle.width) < 0.000001);
        return lengthEquals && widthEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.hashCode(length);
        result = 31 * result + Float.hashCode(width);
        return result;
    }
}
