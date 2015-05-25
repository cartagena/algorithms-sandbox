package list;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {

    @Test
    public void testAdd() {
        List list = buildList("a", "b", "c");

        Assert.assertEquals(3, list.size());
        Assert.assertEquals("b", list.get(1));
    }

    @Test
    public void testReserve() {
        List list = buildList("a", "b", "c", "d", "e");
        
        list.reserve();

        Assert.assertEquals(5, list.size());
        Assert.assertEquals("e", list.get(0));
        Assert.assertEquals("d", list.get(1));
        Assert.assertEquals("c", list.get(2));
        Assert.assertEquals("b", list.get(3));
        Assert.assertEquals("a", list.get(4));
    }
    
    @Test
    public void testReserveRecursive() {
        List list = buildList("a", "b", "c", "d", "e");
        
        list.reserveRecursive();
        
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("e", list.get(0));
        Assert.assertEquals("d", list.get(1));
        Assert.assertEquals("c", list.get(2));
        Assert.assertEquals("b", list.get(3));
        Assert.assertEquals("a", list.get(4));
    }
    
    @Test
    public void testIterator() {
        List list = buildList("a", "b", "c", "d", "e");
        
        StringBuilder sb = new StringBuilder();
        for(Object o : list) {
            sb.append(o);
        }
        
        Assert.assertEquals("abcde", sb.toString());
    }
    
    @Test
    public void testIteratorRemove() {
        List list = buildList("a", "b", "c", "d", "e");
        
        Iterator<Object> it = list.iterator();

        while(it.hasNext()) {
            Object o = it.next();
            if(o.equals("c")) {
                it.remove();
            }
        }
        
        Assert.assertEquals("[a,b,d,e]", list.toString());
    }
    
    private List buildList(String... entriues) {
        List list = new MySinglyList();
        
        for(String entry : entriues) {
            list.add(entry);
        }
        
        return list;
    }
}

