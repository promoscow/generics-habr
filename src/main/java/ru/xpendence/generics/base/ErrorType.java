package ru.xpendence.generics.base;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:43
 * e-mail: 2262288@gmail.com
 */
public enum ErrorType {
    ENTITY_NOT_FOUND("Entity not found by id: %s"),
    ENTITY_NOT_SAVED("Entity not saved: %s"),
    ENTITY_NOT_UPDATED("Entity not updated: %s");

    private String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
