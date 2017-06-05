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
        if (symbol[0] == ')' || symbol.length % 2 != 0) {
            this.check = false;
        } else {
            for (int i = 0; i < symbol.length; ) {
                if (symbol[i] == '(' && symbol[i + 1] == ')') {
                    i += 2;
                } else {
                    this.check = false;
                    break;
                }
            }
        }
        for (int i = 0; i < symbol.length; i++) {

        }
        return this.check;
    }
}
