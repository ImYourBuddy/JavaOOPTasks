package com.mycompany.secondtask.ball;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        if (radius <= 0) {
            throw new IllegalArgumentException("The radius should be > 0");
        } else if (direction < -180 || direction > 180) {
            throw new IllegalArgumentException("The direction should be in interval [-180;180] degrees");
        } else {
            this.x = x;
            this.y = y;
            this.radius = radius;
            xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
            yDelta = (float) (-speed * Math.sin(Math.toRadians(direction)));
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    /**
     * Changes the direction of the ball horizontally
     */
    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    /**
     * changes the direction of the ball vertically
     */
    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[" +
                "(" + x +
                "," + y + ')' +
                ", speed=(" + xDelta + ',' + yDelta +
                ")]";
    }
}
