package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 17.08.2017
 */

public class BinaryTreeTest {
    @Test
    public void whenAddValueToBinTreeAndReturnTrue() {
        BinaryTree<Integer> binTree = new BinaryTree<>();
        binTree.add(4);
        binTree.add(1);
        binTree.add(6);
        binTree.add(3);
        binTree.add(7);
        binTree.add(2);
    }
}
