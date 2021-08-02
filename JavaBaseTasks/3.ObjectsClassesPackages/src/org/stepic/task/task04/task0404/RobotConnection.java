package org.stepic.task.task04.task0404;

//Подключение к роботу
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    //закрывает соединение
    @Override
    void close();
}
