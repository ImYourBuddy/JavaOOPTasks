package com.mycompany.secondtask.ball;

import java.util.Objects;

/**
 * This class is helper for the ball class.It describes the container in which the ball moves.
 */
public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("The width should be > 0");
        } else if (height <= 0) {
            throw new IllegalArgumentException("The height should be > 0");
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x1 + width;
            this.y2 = y1 + height;
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collidesWidth(Ball ball) {
        double x1BallSize = ball.getX() - ball.getRadius();
        double x2BallSize = ball.getX() + ball.getRadius();
        double y1BallSize = ball.getY() - ball.getRadius();
        double y2BallSize = ball.getY() + ball.getRadius();
        if ((x1BallSize >= x1 && x2BallSize <= x2) && (y1BallSize >= y1 && y2BallSize <= y2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + ',' + y1 +
                "),(" + x2 + ',' + y2 +
                ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 &&
                y1 == container.y1 &&
                x2 == container.x2 &&
                y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}
