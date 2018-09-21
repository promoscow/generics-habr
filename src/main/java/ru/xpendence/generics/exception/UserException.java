package ru.xpendence.generics.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:25
 * e-mail: 2262288@gmail.com
 */
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
