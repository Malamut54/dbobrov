package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task List.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.07.2017
 */
public class QueueContainerTest {
    /**
     * Test.
     */
    @Test
    public void whenOfferContainerAndThenPoll() {
        QueueContainer<Integer> queue = new QueueContainer<>();
        for (int i = 0; i < 6; i++) {
            queue.offer(i);
        }
        queue.poll();
        Integer result = queue.poll();
        Integer expected = 1;
        assertThat(result, is(expected));
    }
}
