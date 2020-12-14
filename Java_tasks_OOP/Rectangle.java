package com.mycompany.firsttask.shapes;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        if (length <= 0.0) {
            throw new IllegalArgumentException("The length should be > 0");
        } else {
            this.length = length;
        }
        if (width <= 0.0) {
            throw new IllegalArgumentException("The width should be > 0");
        } else {
            this.width = width;
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length should be > 0");
        } else {
            this.length = length;
        }
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (width <= 0.0) {
            throw new IllegalArgumentException("The width should be > 0");
        } else {
            this.width = width;
        }
    }

    /**
     * Calculate the area of a rectangle
     * @return the area of a rectangle
     */
    public double getArea () {
        return length * width;
    }
    /**
     * Calculate the perimeter of a rectangle
     * @return the perimeter of a rectangle
     */
    public double getPerimeter () {
        return 2 * length + 2 * width;
    }

    @Override
    public String toString() {
        return "Rectangle[" +
                "length=" + length +
                ", width=" + width +
                ']';
    }
}
