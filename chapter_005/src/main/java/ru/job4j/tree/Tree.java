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
    private TreeNode root;

    /**
     * Constructor.
     * @param rootValue inpur value for root.
     */
    public Tree(E rootValue) {
        if (rootValue == null) {
            throw new NullPointerException();
        } else {
            this.root = new TreeNode(rootValue);
        }
    }

    /**
     * Add parent and child to tree.
     * @param parent input parent value.
     * @param child input child value.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        List<TreeNode> tmp;
        List<TreeNode> rootParentList = this.root.children;
        if (parent == null || child == null) {
            return false;
        }
        //Add first element
        if (this.root.children.isEmpty()) {
            this.root.children.add(new TreeNode(parent));
            tmp = this.root.children.get(0).children;
            tmp.add(new TreeNode(child));
            return true;
        }
        //Check exist parent.
        for (TreeNode treeNode : rootParentList) {
            if (treeNode.value.compareTo(parent) == 0) {
                tmp = treeNode.children;
                tmp.add(new TreeNode(child));
                return true;
            }
        }
        //Add new parent and child.
        rootParentList.add(new TreeNode(parent));
        for (TreeNode treeNode : rootParentList) {
            if (treeNode.value.compareTo(parent) == 0) {
                treeNode.children.add(new TreeNode(child));
                return true;
            }
        }
        return false;
    }

    /**
     * Fill list for iterator.
     * @return List.
     */
    private List fillList() {
        List<E> list = new ArrayList<>();
        List<TreeNode> tmp;
        for (int i = 0; i < root.children.size(); i++) {
            tmp = root.children.get(i).children;
            list.add(root.children.get(i).value);
            for (int j = 0; j < tmp.size(); j++) {
                list.add(tmp.get(j).value);
            }
        }
        return list;
    }

    /**
     * Check if the tree is binary.
     * @return boolean.
     */
    public boolean isBinary() {
        for (TreeNode child : this.root.children) {
            if (child.children.size() > 2) {
                return false;
            }
        }
        return true;
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
         * List of all value.
         */
        private List<E> list = fillList();
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
            return pointer < list.size();
        }

        /**
         * Realization method next.
         * @return value.
         */
        @Override
        public E next() {
            if (pointer >= list.size()) {
                throw new NoSuchElementException();
            }
            return (E) list.get(pointer++);
        }
    }

    /**
     * Class Node. Store value and List children.
     */
    private class TreeNode {
        /**
         * List children.
         */
        private List<TreeNode> children = new ArrayList<>();
        /**
         * Value for store.
         */
        private E value;

        /**
         * Constructor.
         *
         * @param value input value for store.
         */
        TreeNode(E value) {
            this.value = value;
        }
    }

}
