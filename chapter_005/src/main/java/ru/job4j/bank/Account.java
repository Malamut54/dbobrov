package ru.job4j.bank;

import java.util.List;
import java.util.Map;

/**
 * Final task collection.
 */
public class Account {
    /**
     * Private fields.
     */
    private int value;
    /**
     * Private fields.
     */
    private int requisites;

    public int getValue() {
        return value;
    }

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (value != account.value) return false;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + requisites;
        return result;
    }
}
