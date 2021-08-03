package org.stepic.task.task04.task0404;

//клас исключения отличный от RobotConnectionException при подключении к роботу
class MyException extends RuntimeException implements Dublicated {
    public MyException() {
        super();
    }
    @Override
    public Dublicated dublic() {
        return new MyException();
    }
}
