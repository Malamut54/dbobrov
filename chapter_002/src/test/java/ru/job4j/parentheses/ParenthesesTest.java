package ru.job4j.parentheses;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Parentheses.
 */
public class ParenthesesTest {
    /**
     * Test. When Correct.
     */
    @Test
    public void whenParenthesesInCorrectOrder() {
        Parentheses parentheses = new Parentheses();
        boolean result = parentheses.checkParentheses("(((()))((()))()())");
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test. When Incorrect.
     */
    @Test
    public void whenFirstParenthesesNotCorrect() {
        Parentheses parentheses = new Parentheses();
        boolean result = parentheses.checkParentheses("())(()");
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test. When Incorrect.
     */
    @Test
    public void whenParenthesesInNotCorrectOrder() {
        Parentheses parentheses = new Parentheses();
        boolean result = parentheses.checkParentheses("))((");
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
