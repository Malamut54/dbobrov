package ru.job4j.synclist;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task synchronize list.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class SyncListLinkTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddValueToLinkedConatainer() {
        SyncListLink<Integer> linkedList = new SyncListLink<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        Integer result = linkedList.get(4);
        Integer expected = 4;
        assertThat(result, is(expected));
    }

    /**
     * Test Iterator.
     */
    @Test
    public void testIteratorInRealCondition() {
        Integer result = null;
        SyncListLink<Integer> linkedList = new SyncListLink<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        while (linkedList.iterator().hasNext()) {
            result = linkedList.iterator().next();
        }
        Integer expected = 5;
        assertThat(result, is(expected));

    }
}