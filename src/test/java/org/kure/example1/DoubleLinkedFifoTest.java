package org.kure.example1;


import org.junit.jupiter.api.Test;
import org.kure.example1.DoubleLinkedFifoImpl;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedFifoTest {


    @Test
    void testSize() {
        DoubleLinkedFifoImpl<String> queue = new DoubleLinkedFifoImpl<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeue() {
        DoubleLinkedFifoImpl<Integer> queue = new DoubleLinkedFifoImpl<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test()
    public void testDequeueEmpty() {
        DoubleLinkedFifoImpl<Integer> queue = new DoubleLinkedFifoImpl<>();
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test()
    public void testPeekEmpty() {
        DoubleLinkedFifoImpl<Integer> queue = new DoubleLinkedFifoImpl<>();
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    public void testPeek() {
        DoubleLinkedFifoImpl<String> queue = new DoubleLinkedFifoImpl<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        assertEquals("Apple", queue.peek());
        assertEquals(3, queue.size());

        queue.dequeue();
        assertEquals("Banana", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void clear() {
        DoubleLinkedFifoImpl<String> queue = new DoubleLinkedFifoImpl<>();
        queue.enqueue("Apple");

        queue.clear();

        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmpty() {
        DoubleLinkedFifoImpl<Integer> queue = new DoubleLinkedFifoImpl<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(5);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
