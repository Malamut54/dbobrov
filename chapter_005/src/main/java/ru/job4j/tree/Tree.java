package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Task tree.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 * @param <E>
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root node of tree.
     */
    private Node root;

    /**
     * Default constructor.
     */
    public Tree() {
        this.root = new Node(new ArrayList<Node>(), null);
    }

    /**
     * Add child in parent.
     * Parent can have list of child
     *
     * @param parent input parent value.
     * @param child  input child value.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        Node node;
        List<Node> list;
        List<Node> rootList = root.children;
        List<Node> childList;
        if (parent == null || child == null) {
            return false;
        } else if (rootList.isEmpty()) {
            node = new Node(null, child);
            list = new ArrayList<>();
            list.add(node);
            rootList.add(new Node(list, parent));
            return true;
        } else {
            for (int i = 0; i < rootList.size(); i++) {
                if (rootList.get(i).value.compareTo(parent) == 0) {
                    childList = rootList.get(i).children;
                    childList.add(new Node(null, child));
                    return true;
                }
            }
        }
        //Add Node with new parent.
        node = new Node(null, child);
        childList = new ArrayList<>();
        childList.add(node);
        rootList.add(new Node(childList, parent));
        return true;
    }

    /**
     * Check if the tree is binary
     *
     * @return boolean
     */
    public boolean isBinary() {
        for (Node child : this.root.children) {
            if (child.children.size() > 2) {
                return false;
            }
        }
        return true;
    }
    /**
     * Fill List for Iterator.
     * @return List.
     */
    public List fillList() {
        List<E> listChild = new ArrayList<>();

        for (int i = 0; i < root.children.size(); i++) {
            listChild.add(root.children.get(i).value);
            List<Node> tmp = root.children.get(i).children;
            for (int j = 0; j < tmp.size(); j++) {
                listChild.add(tmp.get(j).value);
            }
        }
        return listChild;
    }

    /**
     * Iterator for Tree.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>();
    }

    /**
     * Realization Iterator for tree.
     * @param <E>
     */
    public class TreeIterator<E> implements Iterator<E> {
        /**
         * List of all value.
         */
        private List listFromTree = fillList();
        /**
         * Pointer.
         */
        private int pointer = 0;

        /**
         * Realization hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return pointer < listFromTree.size();
        }

        /**
         * Realization next.
         * @return value.
         */
        @Override
        public E next() {
            return (E) listFromTree.get(pointer++);
        }
    }

    /**
     * Class node. Store List and value.
     */
    private class Node {
        /**
         * List of children.
         */
        private List<Node> children;
        /**
         * Value.
         */
        private E value;

        /**
         * Constructor.
         *
         * @param children List children (if exist).
         * @param value    input value for store.
         */
        Node(List<Node> children, E value) {
            this.children = children;
            this.value = value;
        }
    }
}
