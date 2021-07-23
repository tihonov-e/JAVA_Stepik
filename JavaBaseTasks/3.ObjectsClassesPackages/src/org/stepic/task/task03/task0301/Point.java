package org.stepic.task.task03.task0301;

//класс описывающий точку
public class Point {
    private final double x;
    private final double y;

    //constructor
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX () {return x;}
    public double getY () {return y;}

    @Override
    public String toString () {return '(' + x + ", " + y + ')';}
}
