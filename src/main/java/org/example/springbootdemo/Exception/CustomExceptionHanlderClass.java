package org.example.springbootdemo.Exception;

public class CustomExceptionHanlderClass extends RuntimeException{

    public CustomExceptionHanlderClass() {}

    public CustomExceptionHanlderClass(String message) {
        super(message);
    }

}
