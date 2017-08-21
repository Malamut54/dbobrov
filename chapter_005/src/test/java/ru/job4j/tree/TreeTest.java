package ru.job4j.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 */

public class TreeTest {
    /**
     * Test in real condition.
     */
    @Test
    public void testAddAndIteratorInRealCondition() {
        Tree<Integer> tree = new Tree(10);
        List<Integer> exist = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(5, 8);

        for (int i = 1; i < 9; i++) {
            exist.add(i);
        }
        Iterator<Integer> iter = tree.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        assertThat(result, is(exist));
    }


    /**
     * Test binary.
     */
    @Test
    public void whenTreeIsBinaryAndReturnTrue() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(5, 6);
        tree.add(5, 7);
        boolean result = tree.isBinary();
        assertThat(result, is(true));
    }

    /**
     * Test binary.
     */
    @Test
    public void whenTreeIsNotBinaryAndReturnFalse() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        boolean result = tree.isBinary();
        assertThat(result, is(false));
    }
}
