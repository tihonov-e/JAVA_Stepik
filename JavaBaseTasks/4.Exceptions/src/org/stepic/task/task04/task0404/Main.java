package org.stepic.task.task04.task0404;

//задача про робота
/*Задача: установить соединение. Переместить робота. Закрыть соединение.
        Если есть исключение от соединения робота, то попробовать ещё раз. Три попытки.
        Попытка засчитывается не глядя на проблемы закрытия, достаточно переместить робота.
        Соединение не получилось? Закрываем его не глядя на проблем с ним.
        Исключение во время работы не от соединения робота? Закрываем коннект и больше ничего не делаем.*/

public class Main {

    static int i; // переменная для перебора попыток полключений, что бы подключиться 3 раза
    static int repeatNumber; // переменная для перебора 27 вариантов различных ошибок из массива класса Test

    static public int getRepeatNumber() {
        return repeatNumber;
    }

    static public int getI() {
        return i;
    }


    public static void main(String args[]) {
        int toX = 1;
        int toY = 2;
        RobotConnectionManager robotConnectionManager = new RobotConnectionManager();
        for (repeatNumber = 0; repeatNumber < 26; repeatNumber++) {
            System.out.println("\r" + "repeat number: " + repeatNumber);
            StringBuilder builder = new StringBuilder();
            String[] names = {"RCM: ", "RC: ", "Close: "};
            int i = 0;
            for (String name : names) {
                builder.append(name).append(Test.getTest(i) != null ? Test.getTest(i).toString() : "OK").append("||");
                i++;
            }
            System.out.println("Exception List: " + builder.toString());
            try {
                moveRobot(robotConnectionManager, toX, toY); // запуск метода для решения задачи
            } catch (Throwable t) {
                System.out.println("Exception catch in big cycle");
            }
        }
    }

    //метод который мы создаем для управления роботом (то что нужно для решения задачи)
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        //Тут вставляем свой код
        try {
            robotConnectionManager.getConnection();
        }
        catch (RobotConnectionException e){
            System.out.println("Connection failed");
        }

    }
}

