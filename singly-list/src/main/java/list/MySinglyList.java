package list;

import java.util.Iterator;

public class MySinglyList implements List {

    private Node head;
    private Node tail;
    private int size;
    
    @Override
    public void add(Object data) {
        Node newNode = new Node(data);
        
        if(this.head == null) {
            this.head = newNode; 
        }
        
        if(this.tail != null) {
            this.tail.setNext(newNode);
        }
        
        this.tail = newNode;
        size++;
    }

    @Override
    public Object get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node result = this.head;
        for(int i = 1; i <= index; i++) {
            result = result.getNext();
        }
        
        return result.getData();
    }    

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = this.head;
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(current != null) {
            sb.append(current.getData());
            
            current = current.getNext();
            if(current != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        
        
        return sb.toString();
    }    
    
    @Override
    public void reverse() {
        Node newTail = this.head;
        Node newHead = this.tail;
        
        Node current = this.head.getNext();
        Node previous = this.head;
        
        while(current != null) {
            Node next = current.getNext();
            current.setNext(previous);
            
            previous = current;
            current = next;
        }
        
        this.tail = newTail;
        this.tail.setNext(null);
        this.head = newHead;
    }

    @Override
    public void reverseRecursive() {
        Node newTail = this.head;
        reserve(this.head);
        
        this.tail = newTail;
    }
    
    private void reserve(Node node) {
        if(node.getNext() == null) {
            this.head = node;
            return;
        }
        
        reserve(node.getNext());
        
        Node tmp = node.getNext();
        tmp.setNext(node);
        node.setNext(null);
    }

    private void remove(int index) {
        Node previous = null;
        Node current = this.head;
        
        for(int i = 1; i <= index; i++) {
            previous = current;
            current = current.getNext();
        }
        
        Node next = current.getNext();
        
        if(previous == null) {
            this.head = next;
        } else if(next == null){
            this.tail = previous;
            this.tail.setNext(null);
        } else {
            previous.setNext(next);
        }
        
        size--;
    }
    
    @Override
    public Iterator<Object> iterator() {
        return new MyListIterator(this);
    }

    private static class MyListIterator implements Iterator<Object> {
        
        MySinglyList list;
        Node current;
        int index = -1;
        
        MyListIterator(MySinglyList list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return this.current == null ? this.list.head != null : this.current.getNext() != null;
        }

        @Override
        public Object next() {
            this.current = this.current == null ? this.list.head : this.current.getNext();
            index++;
            
            return this.current.getData();
        }

        @Override
        public void remove() {
            if(this.current == null) {
                throw new IllegalStateException();
            }
            
            this.list.remove(index);
        }
    };
}
