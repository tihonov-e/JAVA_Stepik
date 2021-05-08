//класс описывает треугольник
//наследуется от Shape
public class Triangle extends Shape {
    //координаты вершин
    private final Point a, b ,c;

    //конструктор класса Triangle
    public Triangle (Point a, Point b, Point c, Color color) {
        super(color);  //вызов конструктора класса-родителя
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    //переопределенный метод геттер получения площади треугольника
    //переопределен метод класса родителя - Shape
    public double getArea() {
        return Math.abs((a.getX - c.getX) * (b.getY - c.getY) -
                (b.getX - c.getX) * (a.getY - c.getY)) / 2;
    }

    @Override
    public String toString () {
        return "Triangle { " +
                "a= " + a +
                ", b= " + b +
                ", c= " + c +
                ", color= " + getColor() +
                " }";
    }
}