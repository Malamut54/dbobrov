package ru.job4j.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 17.08.2017
 */

public class BinaryTreeTest {
    /**
     * Test in real condition.
     */
    @Test
    public void testAddAndIteratorInRealCondition() {
        ArrayList<Integer> result = new ArrayList<>();
        BinaryTree<Integer> binTree = new BinaryTree<>();
        binTree.add(4);
        binTree.add(1);
        binTree.add(5);
        binTree.add(6);
        binTree.add(3);
        binTree.add(7);
        binTree.add(2);
        Iterator<Integer> iter = binTree.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
}
