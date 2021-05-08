//базовый класс фигуры
public class Shape {
    //цвет фигуры не должен меняться
    private final Color color;
    //конструктор
    public Shape (Color color) {this.color = color;}
    //метод получения цвета фигуры
    public Color getColor () {return color;}
    //метод рассчета площади.
    //Здесь он условный, т.к. пока неизвестен тип фигуры
    public double getArea () {return Double.NaN;}
}
