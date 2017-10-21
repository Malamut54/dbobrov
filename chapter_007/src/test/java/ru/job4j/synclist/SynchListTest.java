package ru.job4j.synclist;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task synchronize list.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */
public class SynchListTest {
    /**
     * Test add.
     *
     * @throws Exception exception.
     */
    @Test
    public void whenAddValueOutsizeOfArrayContainer() throws Exception {
        SynchListArr<Integer> synchList = new SynchListArr<>();
        for (int i = 0; i < 20; i++) {
            synchList.add(i);
        }
        int result = synchList.get(19);
        assertThat(result, is(19));
    }

    /**
     * Test Iterator.
     *
     * @throws Exception exception.
     */
    @Test
    public void testIterator() throws Exception {
        int result = 0;
        SynchListArr<Integer> synchList = new SynchListArr<>();
        for (int i = 0; i < 10; i++) {
            synchList.add(i);
        }
        while (synchList.iterator().hasNext()) {
            result = synchList.iterator().next();
        }
        assertThat(result, is(9));
    }

}