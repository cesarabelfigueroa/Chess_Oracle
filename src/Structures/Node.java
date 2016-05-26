package Structures;

public class Node {

    private Object value = null;
    private Node next = null;
    private Node before = null;

    public Node(Object value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasBefore() {
        return before != null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }
}