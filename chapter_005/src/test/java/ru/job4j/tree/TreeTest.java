package ru.job4j.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 */

public class TreeTest {

    /**
     * Test binary.
     */
    @Test
    public void whenTreeIsBinaryAndReturnTrue() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10, 9);
        tree.add(10, 8);
        tree.add(8, 7);
        tree.add(8, 6);
        tree.add(6, 5);
        tree.add(6, 4);
        tree.add(4, 3);
        tree.add(4, 2);
        boolean result = tree.isBinary();
        assertThat(result, is(true));
    }

    /**
     * Test binary.
     */
    @Test
    public void whenTreeIsNotBinaryAndReturnFalse() {
        Tree<Integer> tree = new Tree<>();
        tree.add(10, 9);
        tree.add(10, 8);
        tree.add(8, 7);
        tree.add(8, 6);
        tree.add(6, 5);
        tree.add(6, 4);
        tree.add(4, 3);
        tree.add(4, 2);
        tree.add(4, 1);
        boolean result = tree.isBinary();
        assertThat(result, is(false));
    }

    /**
     * Test in real condition.
     */
    @Test
    public void testInRealCondition() {
        Tree<Integer> tree = new Tree();
        List<Integer> expected = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        tree.add(10, 9);
        tree.add(10, 8);
        tree.add(8, 7);
        tree.add(8, 6);
        tree.add(6, 5);
        tree.add(6, 4);
        tree.add(4, 3);
        tree.add(4, 2);
        tree.add(4, 1);

        Iterator<Integer> iter = tree.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }

        for (int i = 10; i > 0; i--) {
            expected.add(i);
        }
        assertThat(result, is(expected));

    }
}
