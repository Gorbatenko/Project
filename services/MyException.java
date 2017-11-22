package BigProject.services;

public class MyException extends Exception  {
    public MyException(Throwable e) {
        initCause(e);
    }
}


