package org.stepic.task.task03.task0303;
import java.util.function.DoubleUnaryOperator;

//метод левых прямоугольников
/*Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле
        левых прямоугольников.

Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
        Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.

Интервал интегрирования задается его конечными точками aa и bb, причем a \lt = ba<=b.
        Для получения достаточно точного результата используйте шаг сетки не больше 10^{-6}*/

public class Main {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        //ваш код

        final int n = 100000000;
        double h = (b - a) / n;
        double result = 0;

        for (int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * (i + 0.5));
        }
        return result * h;

    }
}
