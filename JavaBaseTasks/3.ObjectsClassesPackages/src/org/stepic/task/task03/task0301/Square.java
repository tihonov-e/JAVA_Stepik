package org.stepic.task.task03.task0301;

//класс описывает квадрат
//наследуется от Shape
public class Square extends Shape {
    //координаты одной из вершин
    private final Point corner;
    //значение строны
    private final double size;

    //конструктор класса Square
    public Square (Point corner, double size, Color color) {
        super(color);  //вызов конструктора класса-родителя
        this.corner = corner;
        this.size = size;
    }

    //это геттер для получения координат
    public Point getCorner() { return corner; }

    //геттер для получения размера стороны
    public double getSize () { return size; }

    @Override
    //переопределенный метод геттер получения площади квадрата
    //переопределен метод класса родителя - Shape
    public double getArea() { return size * size; }

    @Override
    public String toString () {
        return "Square { " +
                "corner= " + corner +
                ", size= " + size +
                ", color= " + getColor() +
                " }";
    }
}