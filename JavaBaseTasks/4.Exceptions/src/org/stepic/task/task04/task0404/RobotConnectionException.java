package org.stepic.task.task04.task0404;

//класc исключения RobotConnectionException при подключении к роботу
class RobotConnectionException extends RuntimeException implements Dublicated {
    public RobotConnectionException() {
        super();
    }
    @Override
    public Dublicated dublic(){
        return new RobotConnectionException();
    }
}
