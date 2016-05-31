package Structures;

public class Queue {

    private Node top = null;
    private Node head = null;
    private int size = 0;

    public Queue() {

    }

    public Queue(Object value) {
        head = new Node(value);
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void queue(Object value) {
        Node last = new Node(value);
        if (head != null && top != null) {
            top.setNext(last);
            top = top.getNext();
        } else {
            head = last;
            top = last;
        }
        size++;
    }

    public Object dequeue() {
        Object value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }

    public Object peek() {
        return head.getValue();
    }
}

