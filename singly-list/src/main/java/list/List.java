package list;

public interface List extends Iterable<Object> {

    void add(Object data);
    
    void reserve();

    void reserveRecursive();
    
    int size();

    Object get(int i);
    
}
