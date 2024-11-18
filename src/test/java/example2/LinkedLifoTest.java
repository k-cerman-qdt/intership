package example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example2.LinkedLifo;
import org.kure.example2.LinkedLifoImpl;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedLifoTest {

    private LinkedLifo<Integer> lifo;

    @BeforeEach
    public void setup() {
        lifo = new LinkedLifoImpl<>();
    }

    @Test
    public void testPush() {
        lifo.push(5);
        lifo.push(3);
        lifo.push(7);

        assertEquals(3, lifo.size());
        assertEquals(Integer.valueOf(7), lifo.peek());
    }

    @Test
    public void testPop() {
        lifo.push(5);
        lifo.push(3);
        lifo.push(7);

        assertEquals(Integer.valueOf(7), lifo.pop());
        assertEquals(Integer.valueOf(3), lifo.pop());
        assertEquals(Integer.valueOf(5), lifo.pop());
        assertTrue(lifo.isEmpty());
    }

    @Test
    public void testPopEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            lifo.pop();
        });
    }

    @Test
    public void testPeek() {
        lifo.push(5);
        lifo.push(3);
        lifo.push(7);

        assertEquals(Integer.valueOf(7), lifo.peek());
        assertEquals(3, lifo.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, lifo.size());

        lifo.push(5);
        assertEquals(1, lifo.size());

        lifo.push(3);
        lifo.push(7);
        assertEquals(3, lifo.size());

        lifo.pop();
        lifo.pop();
        assertEquals(1, lifo.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(lifo.isEmpty());

        lifo.push(5);
        assertFalse(lifo.isEmpty());

        lifo.pop();
        assertTrue(lifo.isEmpty());
    }

    @Test
    public void testClear() {
        lifo.push(5);
        lifo.push(3);
        lifo.push(7);

        lifo.clear();

        assertTrue(lifo.isEmpty());
        assertEquals(0, lifo.size());
    }

}