package com.company;

public class MyList {
    class Node {
        private int value;
        private Node next;
        private Node now;

        public Node(int value) {
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

        public int compare(Node value) {
            if (value.getValue() > this.value) {
                return 1;
            } else if (value.getValue() == this.value) {
                return 0;
            } else {
                return -1;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public Node getNow() {
            return now;
        }

        public void setNow(Node now) {
            this.now = now;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    private Node begin;
    private int counter;
    private int length;

    public MyList() {
        this.begin = null;
        this.counter = 1;
        this.length = 1;
    }

    public void add(int value) {
        Node newvalue = new Node(value);
        if (this.begin == null) {
            this.begin = newvalue;
        } else {
            this.end().setNext(newvalue);
        }
        this.length++;
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

    public Node end() {
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }

    public Node indexAt(int index) {
        Node iter = this.begin;
        int iter2 = this.length;
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

    public void sort() {
        Node iter = this.begin;
        while(iter.hasNext()) {
            Node iterTemp = iter.next;
            while(iterTemp != null) {
                if(iter.compare(iterTemp) == -1) {
//swap(iter.value, iterTemp.value);
//System.out.println(iter.value);
                    int temp = iter.value;
                    iter.value = iterTemp.value;
                    iterTemp.value = temp;
                }
                iterTemp = iterTemp.next;
            }
            iter = iter.next;
        }
    }

    public void swap(int firstPos, int secondPos) {
        Node itFirstPos = indexAt(firstPos);
        Node itSecondPos = indexAt(secondPos);
        Node itPreFirstPos = indexAt(firstPos - 1);
        Node itPreSecondPos = indexAt(secondPos - 1);
        if (firstPos == 1) {
            this.begin = itSecondPos;
            itPreSecondPos.next = itFirstPos;

            Node iter = itFirstPos.next;
            itFirstPos.next = itSecondPos.next;
            itSecondPos.next = iter;

        } else {
            itPreFirstPos.setNext(itSecondPos);
            itPreSecondPos.setNext(itFirstPos);

            Node iter = itFirstPos.next;
            itFirstPos.next = itSecondPos.next;
            itSecondPos.next = iter;
        }
    }
}
