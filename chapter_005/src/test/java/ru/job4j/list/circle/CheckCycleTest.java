package ru.job4j.list.circle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task Cycle.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.07.2017
 */

public class CheckCycleTest {
    /**
     * When cycle is exist.
     */
    @Test
    public void whenInputCycleEqualsTrue() {
        CheckCycle check = new CheckCycle();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        boolean result = check.hasCycle(first);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * When a cycle is not present.
     */
    @Test
    public void whenInputCycleEqualsFalse() {
        CheckCycle check = new CheckCycle();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;

        boolean result = check.hasCycle(first);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
