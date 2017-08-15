package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 */

public class TreeTest {
    @Test
    public void whenAddFirstNodeToTree() {
        Tree<Integer> tree = new Tree();
        tree.add(1, 5);
        tree.add(1, 6);
        tree.add(1, 2);
        tree.add(2, 5);
        tree.add(2, 7);
        tree.add(3, 8);
        tree.add(3, 9);
    }

    @Test
    public void iteratorInRealCondition() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 5);
        tree.add(1, 6);
        tree.add(1, 2);
        tree.add(2, 5);
        tree.add(2, 7);
        tree.add(3, 8);
        tree.add(3, 9);
        Iterator<Integer> iter = tree.iterator();


        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
