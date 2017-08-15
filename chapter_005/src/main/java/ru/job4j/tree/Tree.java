package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 14.08.2017
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node root;

    public Tree() {
        this.root = new Node(new ArrayList<Node>(), null);
    }

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


    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>();
    }

    public class TreeIterator<E> implements Iterator<E> {
        private List listFromTree = fillList();
        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < listFromTree.size();
        }

        @Override
        public E next() {
            return (E) listFromTree.get(pointer++);
        }
    }

    private class Node {
        List<Node> children;
        E value;

        public Node(List<Node> children, E value) {
            this.children = children;
            this.value = value;
        }
    }
}
