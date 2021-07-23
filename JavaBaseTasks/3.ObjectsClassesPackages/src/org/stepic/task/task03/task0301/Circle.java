package org.stepic.task.task03.task0301;
//класс описывает круг
//наследуется от Shape
public class Circle extends Shape {
    //координаты центра круга
    private final Point center;
    //значение радиуса
    private final double radius;

    //конструктор класса Circle
    public Circle(Point center, double radius, Color color) {
        super(color);  //вызов конструктора класса-родителя
        this.center = center;
        this.radius = radius;
    }

    //это геттер для получения центра круга
    public Point getCenter() {
        return center;
    }

    //геттер для получения радиуса
    public double getRadius() {
        return radius;
    }

    @Override
    //переопределенный метод геттер получения площади круга
    //переопределен метод класса родителя - Shape
    public double getArea() { return radius * radius * Math.PI; }

    @Override
    public String toString () {
        return "Circle { " +
                "center= " + center +
                ", radius= " + radius +
                ", color= " + getColor() +
                " }";
    }

    

}