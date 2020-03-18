package eg.edu.alexu.csd.datastructure.linkedList.cs24_cs28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SinglyTest {
    @Test
    void test() {

        // 1 - Initialize the linked list to point to implementation and add some nodes to the list.
        SinglyLinkedList p = new SinglyLinkedList() ;
        ILinkedList sublist = new SinglyLinkedList();
        p.add(0,10);
        p.add(20);
        p.add(2,30);
        p.add(40);
        p.add(50);
        p.add(5,60);

        // 2 - Test the correct insertion of nodes by calling the get() method for all possible indices and test invalid index .
        assertThrows(java.lang.ArrayIndexOutOfBoundsException.class,() -> p.add(-1,100),"Invalid index");
        assertThrows(java.lang.ArrayIndexOutOfBoundsException.class,() -> p.add(-2,200),"Invalid index");
        assertEquals(10,p.get(0));
        assertEquals(20,p.get(1));
        assertEquals(30,p.get(2));
        assertEquals(40,p.get(3));
        assertEquals(50,p.get(4));
        assertEquals(60,p.get(5));
        assertThrows(java.lang.ArrayIndexOutOfBoundsException.class,() -> p.get(-1),"Invalid index");
        assertThrows(java.lang.ArrayIndexOutOfBoundsException.class,() -> p.get(-2),"Invalid index");


        // 3 - Add one more node at an index in the middle of the list then test using get() method .
        p.add(3,35);
        assertEquals(35,p.get(3));


        // 4 - call the set() method then Use the get() method to test if the node is updated properly.
        p.set(1,25);
        assertEquals(25,p.get(1));


        // 5 - Use sublist() to choose some elements of the list. Assure that the size of the sublist is
        //correct and the elements are the desired ones.
        sublist = p.sublist(1,3);
        assertEquals(25,sublist.get(0));
        assertEquals(30,sublist.get(1));
        assertEquals(35,sublist.get(2));
        assertEquals(3,sublist.size());


        // 6 - Remove one node from the list and assert that the size of the list has been decreased and
        //that the node has been deleted properly
        p.remove(4);
        assertEquals(6,p.size());
        assertEquals(50,p.get(4));


        // 7 - Test the contains() method by calling the method with two integers: one that is in the
        //list and another that is not in the list.
        assertFalse(p.contains(150));
        assertTrue(p.contains(60));


        // 8 - Clear the elements of the list. Assure that the list is Empty
        p.clear();
        assertTrue(p.isEmpty());


    }
}
