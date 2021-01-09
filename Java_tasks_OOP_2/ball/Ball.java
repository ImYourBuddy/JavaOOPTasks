package com.mycompany.secondtask.ball;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        boolean xEquals = (Math.abs(x - ball.x) < 0.000001);
        boolean yEquals = (Math.abs(y - ball.y) < 0.000001);
        boolean xDeltaEquals = (Math.abs(xDelta - ball.xDelta) < 0.000001);
        boolean yDeltaEquals = (Math.abs(yDelta - ball.yDelta) < 0.000001);
        return radius == ball.radius && xEquals && yEquals && xDeltaEquals && yDeltaEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.hashCode(x);
        result = 31 * result + Float.hashCode(y);
        result = 31 * result + Float.hashCode(xDelta);
        result = 31 * result + Float.hashCode(yDelta);
        result = 31 * result + radius;
        return result;
    }
}
