package com.company;

import java.util.*;

public class MyTree<T> implements Collection<T> {  class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public boolean hasRight() {
            if (this.right != null) return true;
            return false;
        }

        public boolean hasLeft() {
            if (this.left != null) return true;
            return false;
        }

    }

    private Node<T> root;
    private long length;
    private Comparable comparable;

    public MyTree(Comparable compare) {
        this.root = null;
        this.length = 0;
        this.comparable = compare;
    }

    public long getLength() {
        return length;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<>(t);
        if (this.root == null) {
            this.root = node;
            this.length++;
            return true;
        }
        Node<T> iter = this.root;
        while (true) {
            if (this.comparable.compare(iter, node) == 0) {
                return false;
            } else if (this.comparable.compare(iter, node) > 0) {
                if (iter.hasRight()) {
                    iter = iter.getRight();
                } else {
                    iter.setRight(node);
                    this.length++;
                    return true;
                }
            } else {
                if (iter.hasLeft()) {
                    iter = iter.getLeft();
                } else {
                    iter.setLeft(node);
                    this.length++;
                    return true;
                }
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}