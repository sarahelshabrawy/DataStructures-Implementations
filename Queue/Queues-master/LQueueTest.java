package eg.edu.alexu.csd.datastructure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LQueueTest {
    LQueue test = new LQueue();
    @Test
    void Test(){
        assertTrue(test.isEmpty());
        for (int i = 1; i < 7; i++) {
            test.enqueue(i);
        }
        assertEquals(6,test.size());
        for (int i = 1; i < 7; i++) {
            assertEquals(i,test.dequeue());
        }
        assertThrows(java.lang.RuntimeException.class,() -> test.dequeue());
        for (int i = 1; i < 7; i++) {
            test.enqueue(i);
        }
        for (int i = 1; i < 4; i++) {
            assertEquals(i,test.dequeue());
        }
        for (int i = 7; i <10; i++) {
            test.enqueue(i);
        }
        for (int i = 4; i < 10; i++) {
            assertEquals(i,test.dequeue());
        }
        assertTrue(test.isEmpty());
    }

}