package org.stepic.task.task04.task0404;

//класс управляет роботом
//ошибка в соответсвии с массивом класса test выбрасываеться в 1 попытку подключения
class RobotUse implements RobotConnection {
    @Override
    public void moveRobotTo(int x, int y){
        System.out.println("attempt number: " + Main.getI() + ". start RC");
        if ((Test.getTest(1) instanceof Throwable) && (Main.getI() == 1)){
            System.out.println("RC Exeption");
            throw Test.getTest(1);
        }
        else{
            System.out.println("Move robot OK" );
        }
    }
    @Override
    public void close(){
        System.out.println("attempt number: " + Main.getI() + ". start close");
        if ((Test.getTest(2) instanceof Throwable) && (Main.getI() == 1)){
            System.out.println("Close Exeption");
            throw Test.getTest(2);
        }
        else{
            System.out.println("Close OK");
        }
    }
}