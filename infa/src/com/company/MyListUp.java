package com.company;

public class MyListUp {
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

        public int compare1(Node value) {
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

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNow() {
            return now;
        }

        public void setNow(Node now) {
            this.now = now;
        }


        public String toString() {
            return Integer.toString(this.value);
        }
    }

    private Node begin;
    private int counter;
    private int length;
    private int pozition;

    public MyListUp() {
        this.begin = null;
        this.counter = 1;
        this.length = 1;
        this.pozition = 1;
    }

    public void addUp(int value) {
        Node newvalue = new Node(value);
        if (this.begin == null) {
            this.begin = newvalue;
        } else {
            this.endUp().setNext(newvalue);
        }
    }


    public String toStringUp() {
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

    public Node endUp() {
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }

    public Node indexAtUp(int index) {
        Node iter = this.begin;
        int iter2 = kolUp();
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

    public int givePozitionUp(Node value) {
        Node iter = this.begin;
        this.pozition = 1;
        while (iter.hasNext()) {
            if (iter.compare1(value) == 0) {
                break;
            } else {
                iter = iter.getNext();
                this.pozition++;
            }
        }
        return this.pozition;
    }


    public int kolUp() {
        this.length = 1;
        Node iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
            this.length++;
        }
        return this.length;

    }

    public void sortUp() {
        Node iter = this.begin;
//        for (int i = 1; i < kol() - 1; i++) {
//            while (iter.hasNext()) {
//                if (iter.compare(iter.next) == 1) {
//                    swap(givePozition(iter), givePozition(iter.next));
//                }
//                iter = iter.getNext();
//            }
//        }
//        while (iter.hasNext()) {
//            for (int i = 1; i < kol() - 1; i++) {
//                if (iter.compare(iter.next) == 1) {
//                    System.out.println(iter);
//                    System.out.println(iter.next);
//                    swap(givePozition(iter), givePozition(iter.next));
//                    System.out.println(iter);
//                    System.out.println(iter.next);
//                }
//                iter = iter.getNext();
//            }
//        }
        while(iter.hasNext()) {
            Node iterNext = iter.next;
            while(iterNext != null) {
                if(iter.compare1(iterNext) == -1) {
//                    swap(iter.value, iterNext.value);
                    //System.out.println(iter.value);
                    int temp = iter.value;
                    iter.value = iterNext.value;
                    iterNext.value = temp;
                }
                iterNext = iterNext.next;
            }
            iter = iter.next;
        }
    }

    public void swapUp(int firstPos, int secondPos) {
        Node itFirstPos = indexAtUp(firstPos);
        Node itSecondPos = indexAtUp(secondPos);
        Node itPreFirstPos = indexAtUp(firstPos - 1);
        Node itPreSecondPos = indexAtUp(secondPos - 1);
        if (firstPos == 1) {
            this.begin = itSecondPos;
            itPreSecondPos.next = itFirstPos;
        } else {
            itPreFirstPos.setNext(itSecondPos);
            itPreSecondPos.setNext(itFirstPos);
        }
        Node iter = itFirstPos.next;
        itFirstPos.next = itSecondPos.next;
        itSecondPos.next = iter;
    }
}
