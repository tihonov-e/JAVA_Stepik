package org.stepic.task.task04.task0404;

//класс создает объект для управления роботом
//ошибка в соответсвии с массивом класса test выбрасываеться в 1 попытку подключения
class RobotConnectionManager {
    RobotConnection getConnection(){
        System.out.println("attempt number: " + Main.getI() + ". start RCM");
        if ((Test.getTest(0) instanceof Throwable) && (Main.getI() == 1)){
            System.out.println("RCM Exeption");
            throw Test.getTest(0);
        }
        else{
            System.out.println("RCM OK");
            return new RobotUse();
        }
    }
}

