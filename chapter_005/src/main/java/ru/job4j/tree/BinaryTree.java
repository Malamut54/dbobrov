package ru.job4j.tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Task Tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 17.08.2017
 * @param <E>
 */

public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
    /**
     * Root node.
     */
    private Node rootNode;

    /**
     * Default constructor.
     */
    public BinaryTree() {
        this.rootNode = null;
    }

    /**
     * Add value to BinaryTree.
     *
     * @param e input value.
     */
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

    /**
     * Iterator for BinaryTree.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new BinaryTreeIterator<>(rootNode);
    }

    /**
     * Realization Iterator.
     * @param <E>
     */
    private class BinaryTreeIterator<E> implements Iterator<E> {
        /**
         * Private stack for value in BinaryTree.
         */
        private Stack<Node> stack;

        /**
         * Constructor.
         *
         * @param root input root Node.
         */
        BinaryTreeIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * realization method hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * realization method next.
         * @return value.
         */
        @Override
        public E next() {
            Node node = stack.pop();
            E result = (E) node.item;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }

    /**
     * Class node.
     */
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

        /**
         * Constructor.
         *
         * @param item  input value
         * @param right link to right Node.
         * @param left  link to left Node.
         */
        Node(E item, Node right, Node left) {
            this.item = item;
            this.right = right;
            this.left = left;
        }
    }
}
