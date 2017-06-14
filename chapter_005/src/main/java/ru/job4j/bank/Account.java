package ru.job4j.bank;

/**
 * Final task collection.
 */
public class Account {
    /**
     * Private fields.
     */
    private double value;
    /**
     * Private fields.
     */
    private int requisites;

    /**
     * Getter for value.
     *
     * @return value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for value.
     *
     * @param value value.
     */
    void setValue(double value) {
        this.value = value;
    }

    /**
     * Constructor for Account.
     * @param value value.
     * @param requisites requisites.
     */
    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" + "value=" + value + ", requisites=" + requisites + '}';
    }
}
