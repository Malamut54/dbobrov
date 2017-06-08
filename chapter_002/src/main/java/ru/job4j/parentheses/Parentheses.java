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
        int counter = 0;

        char[] symbol = par.toCharArray();
        for (int i = 0; i < symbol.length; i++) {
            if (symbol[i] == '(') {
                counter += 1;
            } else {
                counter -= 1;
                if (counter < 0) {
                    this.check = false;
                    break;
                }
            }
        }
        return counter == 0;
    }
}
