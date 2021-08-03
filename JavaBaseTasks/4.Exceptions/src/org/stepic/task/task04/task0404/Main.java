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
        for (int i = 0; i < 3; i++) {

            //устанавливаем соединение
            try (RobotConnection robotConnection = robotConnectionManager.getConnection();) {
                robotConnection.moveRobotTo(toX, toY); //команда на перемещение
                i = 3;
            }
            catch (RobotConnectionException e) {
                if (i == 2) throw e;
            }
            catch (Throwable e) {
                i = 3;
                throw e;
            }
        }
    }


}


    /*После запуска в консоли должно быть следующее:

        repeat number: 0
        Exeption List: RCM: OK||RC: OK||Close: OK||
        attempt number: 1. start RCM
        RCM OK
        attempt number: 1. start RC
        Move robot OK
        attempt number: 1. start close
        Close OK

        repeat number: 1
        Exeption List: RCM: OK||RC: OK||Close: RobotConnectionException||
        attempt number: 1. start RCM
        RCM OK
        attempt number: 1. start RC
        Move robot OK
        attempt number: 1. start close
        Close Exeption

        repeat number: 2
        Exeption List: RCM: OK||RC: OK||Close: MyException||
        attempt number: 1. start RCM
        RCM OK
        attempt number: 1. start RC
        Move robot OK
        attempt number: 1. start close
        Close Exeption

        repeat number: 3
        Exeption List: RCM: OK||RC: RobotConnectionException||Close: OK||
        attempt number: 1. start RCM
        RCM OK
        attempt number: 1. start RC
        RC Exeption
        attempt number: 1. start close
        Close OK
        attempt number: 2. start RCM
        RCM OK
        attempt number: 2. start RC
        Move robot OK
        attempt number: 2. start close
        Close OK*/