package list;

public interface List extends Iterable<Object> {

    void add(Object data);
    
    void reverse();

    void reverseRecursive();
    
    int size();

    Object get(int i);
    
}
