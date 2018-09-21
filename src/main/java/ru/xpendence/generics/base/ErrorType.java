package ru.xpendence.generics.base;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:43
 * e-mail: 2262288@gmail.com
 */
public enum ErrorType {
    USER_NOT_FOUND("User not found by id: %s"),
    USER_NOT_SAVED("User not saved: %s");

    private String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
