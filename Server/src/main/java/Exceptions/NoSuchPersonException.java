package Exceptions;

public class NoSuchPersonException extends RuntimeException{
    public NoSuchPersonException() {
        super("Нет такого элемента.");
    }
}

//public class EmptyLineException extends RuntimeException {
//    public EmptyLineException(String message) {
//        super(message+" не может быть пустым.");
//    }
//
//
//}
