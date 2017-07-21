package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task List.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 21.07.2017
 */

public class StackContainerTest {
    /**
     * Test Push and Pop.
     */
    @Test
    public void whenPushValueToStackContainerAndThenPop() {
        StackContainer<Integer> stack = new StackContainer<Integer>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        stack.pop();
        Integer result = stack.pop();
        Integer expected = 4;
        assertThat(result, is(expected));
    }
}
