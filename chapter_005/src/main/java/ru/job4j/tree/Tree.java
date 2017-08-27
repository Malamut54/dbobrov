package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 * @param <E>
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root Tree.
     */
    private Node root;

    /**
     * Add parent and child to tree.
     * @param parent input parent value.
     * @param child input child value.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        Node tmp;
        boolean isAdded = true;

        if (parent == null || child == null) {
            isAdded = false;
        }
        //Add root and his child.
        if (root == null) {
            root = new Node(parent);
            root.children.add(new Node(child));
        } else {
            tmp = serchNode(parent, root);
            tmp.children.add(new Node(child));
            isAdded = true;

        }

        return isAdded;
    }

    /**
     * Search Node, use for add value.
     *
     * @param input   value
     * @param current input node
     * @return node
     */
    private Node serchNode(E input, Node current) {
        Node node = null;
        if (current.value.equals(input)) {
            node = current;
        } else {
            List<Node> children = current.children;
            for (Node child : children) {
                node = serchNode(input, child);
                if (node != null) {
                    break;
                }
            }
        }
        return node;
    }

    /**
     * Public method for check if tree is binary.
     * @return boolean.
     */
    public boolean isBinary() {
        return checkBinary(root);
    }

    /**
     * Check if the tree is binary.
     * @param current input node
     * @return boolean
     */
    private boolean checkBinary(Node current) {
        boolean binary = true;
        int size = current.children.size();
        if (size > 2 && size != 0) {
            binary = false;
        } else if (size == 1) {
            binary = checkBinary(current.children.get(0));
        } else if (size == 2) {
            binary = checkBinary(current.children.get(0));
            if (binary) {
                binary = checkBinary(current.children.get(1));
            }
        }
        return binary;
    }

    /**
     * Fill a list of all nodes.
     *
     * @param node input node
     * @return List
     */
    private List<Node> returnAllNodes(Node node) {
        List<Node> listOfNodes = new ArrayList<Node>();
        if (node != null) {
            listOfNodes.add(node);
            for (int i = 0; i < listOfNodes.size(); ++i) {
                Node n = listOfNodes.get(i);
                List<Node> children = n.children;
                if (children != null) {
                    for (Node child : children) {
                        if (!listOfNodes.contains(child)) {
                            listOfNodes.add(child);
                        }
                    }
                }
            }
        }
        return listOfNodes;
    }


    /**
     * Iterator for Tree.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Realization Iterator for tree.
     * @param <E>
     */
    private class TreeIterator<E> implements Iterator<E> {
        /**
         * Get list of all node.
         */
        private List<Node> listAllNode = returnAllNodes(root);

        /**
         * Pointer.
         */
        private int pointer;

        /**
         * Realization method hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return pointer < listAllNode.size() && listAllNode.size() != 0;
        }

        /**
         * Realization method next.
         * @return value
         */
        @Override
        public E next() {
            if (pointer >= listAllNode.size()) {
                throw new NoSuchElementException();
            }
            return (E) listAllNode.get(pointer++).value;
        }
    }

    /**
     * Class Node. Store value and List children.
     */
    private class Node {
        /**
         * List children.
         */
        private List<Node> children = new ArrayList<>();
        /**
         * Value for store.
         */
        private E value;

        /**
         * Constructor.
         *
         * @param value input value for store.
         */
        Node(E value) {
            this.value = value;
        }

    }

}
