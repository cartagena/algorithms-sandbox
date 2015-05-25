package list;


public class Node {

    private Node next;
    private Object data;
    
    public Node(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", next=" + (next == null ? "null" : next.data) + "]";
    }
    
}
