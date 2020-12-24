package com.company;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.IntStream;

public class MyList<T> implements Collection<T> {
    class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> now;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.next == null) {
                return false;
            }
            return true;
        }


        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getNow() {
            return now;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setNow(Node<T> now) {
            this.now = now;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private Node begin;
    private int counter;
    private int length;
    private int pozition;

    public MyList() {
        this.begin = null;
        this.counter = 1;
        this.length = 1;
        this.pozition = 1;
    }


    public boolean addL(T value) {
        Node newvalue = new Node(value);
        if (this.begin == null) {
            this.begin = newvalue;
        } else {
            this.end().setNext(newvalue);
        }
        return true;
    }


    public String toString() {
        String result = "[ ";
        if (this.begin != null) {
            Node iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString() + " ";
        }
        result += "]";
        return result;
    }

    public Node<T> end() {
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }

    public Node<T> indexAt(int index) {
        Node iter = this.begin;
        int iter2 = size();
        if (index <= iter2) {
            while (iter.hasNext() && this.counter < index) {
                iter = iter.getNext();
                this.counter++;
            }
            this.counter = 1;
            return iter;
        } else {
            return null;
        }
    }


    public void swap(int firstPos, int secondPos) {
        Node<T> itFirstPos = indexAt(firstPos);
        Node<T> itSecondPos = indexAt(secondPos);
        Node<T> itPreFirstPos = indexAt(firstPos - 1);
        Node<T> itPreSecondPos = indexAt(secondPos - 1);
        if (firstPos == 1) {
            this.begin = itSecondPos;
            itPreSecondPos.next = itFirstPos;
        } else {
            itPreFirstPos.setNext(itSecondPos);
            itPreSecondPos.setNext(itFirstPos);
        }
        Node<T> iter = itFirstPos.next;
        itFirstPos.next = itSecondPos.next;
        itSecondPos.next = iter;
    }
    @Override
    public int size() {
        this.length = 1;
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
            this.length++;
        }
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public Object[] toArray() {
        Node<T> iter = this.begin;
        Node nums[];
        nums = new Node[size()];
        for(int i = 0; i<size(); i++) {
            nums[i] = iter;
            iter = iter.getNext();
        }
        return nums;
    }


    @Override
    public boolean add(T value) {
        Node newvalue = new Node(value);
        if (this.begin == null) {
            this.begin = newvalue;
        } else {
            this.end().setNext(newvalue);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
