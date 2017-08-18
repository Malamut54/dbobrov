package ru.job4j.tree;

import java.util.Iterator;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 17.08.2017
 */

public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
    private Node rootNode;


    public BinaryTree() {
        this.rootNode = null;
    }

    public void add(E e) {

        if (rootNode == null) {
            rootNode = new Node(e, null, null);
            return;
        }
        Node current = rootNode;
        Node parent = null;
        while (true) {
            parent = current;
            if (e.compareTo(current.item) <= 0) {
                current = current.left;
                if (current == null) {
                    parent.left = new Node(e, null, null);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = new Node(e, null, null);
                    return;
                }
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private class Node {
        /**
         * Private field.
         */
        private E item;
        /**
         * Private field.
         */
        private Node right;
        /**
         * Private field.
         */
        private Node left;

        public Node(E item, Node right, Node left) {
            this.item = item;
            this.right = right;
            this.left = left;
        }
    }
}
