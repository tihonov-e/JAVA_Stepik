package org.stepic.task.task03.task0301;
import java.math.BigInteger;

/*Классический пример наследования с фигурами.
Cоздаем родительский класс Shape, наследуем от него
классы конкретных геометрических фигур*/


public class Main {

    //main method
    public static void main(String[] args) {
        //create new objects Circle, Square, Triangle
        Circle circle = new Circle(new Point(0,0), 1, Color.RED);
        Square square = new Square(new Point(0,0), 2, Color.BLACK);
        Triangle triangle = new Triangle(new Point(0,0), new Point(1,1), new Point(2,2), Color.BLUE);

        //print they parameters
        System.out.println(circle.toString());
        System.out.println(square.toString());
        System.out.println(triangle.toString());
    }

}
