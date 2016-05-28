package Structures;

public class LinkedList {

    private Node head = null;
    private int size = 0;

    public LinkedList() {
        head = null;
    }

    public LinkedList(Object value) {
        head = new Node(value);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object at(int position) {
        if (head != null) {
            if (position == 0 || position >= 0 && position < size) {
                int current = 0;
                Node actual = head;
                while (current != position) {
                    actual = actual.getNext();
                    current++;
                }
                return actual.getValue();
            }
            return null;
        }
        return null;
    }

    public void insert(int position, Object value) {
        if (head != null) {
            if (position == 0 || position >= 0 && position <= size) {
                int current = 0;
                Node actual = head;
                Node next;
                if (position > 0) {
                    while (current != position - 1) {
                        actual = actual.getNext();
                        current++;
                    }
                    Node olderNext = actual.getNext();
                    next = new Node(value);
                    actual.setNext(new Node(value));
                    next.setNext(olderNext);
                    size++;
                } else if (position == 0) {
                    next = head;
                    setHead(new Node(value));
                    head.setNext(next);
                    size++;
                }
            }
        } else {
            head = new Node(value);
            size++;
        }
       
    }

    public int find(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(at(i))) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int position) {
        if (head != null) {
            if (position == 0 || position > 0 && position < size) {
                int current = 0;
                Node actual = head;
                if (position > 0) {
                    while (current < position - 1) {
                        actual = actual.getNext();
                        current++;
                    }
                    if (actual.hasNext()) {
                        actual.setNext(actual.getNext().getNext());
                        size--;
                    } else {
                        actual = null;
                        size--;
                    }
                } else {
                    setHead(head.getNext());
                    size--;
                }
            }
        }
    }

    public void concat(LinkedList list) {
        size += list.getSize();
        insert(0, list.getHead());
    }
    
    public void push_back(Object value){
        insert(size(),value);
    }
    
    public int size(){
        int size = 0;
        if(head != null){
            size++;
            Node temp = head;
            while(temp.hasNext()){
                size++;
                temp = temp.getNext();
            }
        }
        return size;
    }
}
