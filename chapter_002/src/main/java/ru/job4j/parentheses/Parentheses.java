package ru.job4j.parentheses;

/**
 * Final Task OOP.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @since 0.1
 */
public class Parentheses {
    /**
     * Class Parentheses.
     */

    /**
     * Private variable.
     */
    private boolean check = true;

    /**
     * Perform check correct sequence.
     *
     * @param par input String parentheses.
     * @return boolean.
     */
    public boolean checkParentheses(String par) {

        char[] symbol = par.toCharArray();
        for (int i = 0; i < (symbol.length / 2); i++) {
            if (symbol[i] == '(' && symbol[symbol.length - i - 1] == ')') {
                this.check = true;
            } else {
                this.check = false;
            }
        }
        return this.check;
    }
}
