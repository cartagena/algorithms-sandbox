package list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Test;

public class ListTest {

    @Test
    public void testAdd() {
        List list = buildList("a", "b", "c");

        int listSize = list.size();
        assertThat(listSize)
            .isEqualTo(3);
        
        Object secondElement = list.get(1);
        assertThat(secondElement)
           .isEqualTo("b");
    }

    @Test
    public void testReserve() {
        List list = buildList("a", "b", "c", "d", "e");
        
        list.reverse();

        assertThat(list)
            .containsExactly("e", "d", "c", "b", "a");
    }
    
    @Test
    public void testReserveRecursive() {
        List list = buildList("a", "b", "c", "d", "e");
        
        list.reverseRecursive();

        assertThat(list)
            .containsExactly("e", "d", "c", "b", "a");
    }
    
    @Test
    public void testIterator() {
        List list = buildList("a", "b", "c", "d", "e");
        
        Iterator<Object> it = list.iterator();
        
        assertThat(it)
            .containsExactly("a", "b", "c", "d", "e");
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
        
        int listSize = list.size();
        
        assertThat(listSize)
            .isEqualTo(4);
        
        assertThat(list)
            .containsExactly("a", "b", "d", "e");
    }

    @Test
    public void testIteratorRemoveFirst() {
        List list = buildList("a", "b", "c");
        
        Iterator<Object> it = list.iterator();

        it.next();
        it.remove();
        
        int listSize = list.size();
        
        assertThat(listSize)
            .isEqualTo(2);
        
        assertThat(list)
            .containsExactly("b", "c");
    }

    
    @Test
    public void testIteratorRemoveInvalid() {
        List list = buildList("a", "b", "c", "d", "e");
        
        Iterator<Object> it = list.iterator();

        try {
            it.remove();
        } catch (Exception e) {
            assertThat(e)
                .isInstanceOf(IllegalStateException.class)
                .hasNoCause()
                .hasMessage(null);
        }
    }
    
    
    @Test
    public void testIteratorRemoveLast() {
        List list = buildList("d", "e", "f");
        
        Iterator<Object> it = list.iterator();

        it.next();
        it.next();
        it.next();
        it.remove();
        
        int listSize = list.size();
        
        assertThat(listSize)
            .isEqualTo(2);
        
        assertThat(list)
            .containsExactly("d", "e");
    }
    
    @Test
    public void testInvalidPosition() {
        List list = buildList("a");
        
        try {
            list.get(1);
        } catch (Exception e) {
            assertThat(e)
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasNoCause()
                .hasMessage(null);
        }
    }
    
    private List buildList(String... entriues) {
        List list = new MySinglyList();
        
        for(String entry : entriues) {
            list.add(entry);
        }
        
        return list;
    }
}

