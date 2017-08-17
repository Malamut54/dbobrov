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
     * Test add first Node.
     */
    @Test
    public void whenAddFirstNodeToTreeAndReturnTrue() {
        Tree<Integer> tree = new Tree();
        boolean result = tree.add(1, 5);
        assertThat(result, is(true));
    }

    /**
     * Test add second Node.
     */
    @Test
    public void whenAddSecondNodeToTreeAndReturnTrue() {
        Tree<Integer> tree = new Tree();
        tree.add(1, 7);
        boolean result = tree.add(1, 5);
        assertThat(result, is(true));
    }

    /**
     * Test iterator.
     */
    @Test
    public void iteratorInRealCondition() {
        Tree<Integer> tree = new Tree<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(8, 9);
        tree.add(8, 10);

        Iterator<Integer> iter = tree.iterator();

        while (iter.hasNext()) {
            result.add(iter.next());
        }

        for (int i = 1; i < 11; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }

    /**
     * Test binary.
     */
    @Test
    public void whenTreeIsBinaryAndReturnTrue() {
        Tree<Integer> tree = new Tree<>();
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
        Tree<Integer> tree = new Tree<>();
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        boolean result = tree.isBinary();
        assertThat(result, is(false));
    }
}
