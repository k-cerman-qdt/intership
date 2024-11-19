package org.kure.example3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example1.DoubleLinkedFifo;
import org.kure.example1.DoubleLinkedFifoImpl;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setup() {
        binaryTree = new BinaryTreeImpl<>();
    }

    @Test
    public void testInsert() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);

        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(7));
        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(4));

        assertFalse(binaryTree.contains(2));
        assertFalse(binaryTree.contains(6));
    }

    @Test
    public void testDelete() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);

        binaryTree.delete(3);
        binaryTree.delete(7);

        assertTrue(binaryTree.contains(5));
        assertFalse(binaryTree.contains(3));
        assertFalse(binaryTree.contains(7));
        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(4));
    }

    @Test
    public void testSize() {
        assertEquals(0, binaryTree.size());

        binaryTree.insert(5);
        assertEquals(1, binaryTree.size());

        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        assertEquals(5, binaryTree.size());

        binaryTree.delete(3);
        binaryTree.delete(7);
        assertEquals(3, binaryTree.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(binaryTree.isEmpty());

        binaryTree.insert(5);
        assertFalse(binaryTree.isEmpty());

        binaryTree.delete(5);
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    public void testGetHeight() {
        assertEquals(0, binaryTree.getHeight());

        binaryTree.insert(5);
        assertEquals(1, binaryTree.getHeight());

        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        assertEquals(3, binaryTree.getHeight());

        binaryTree.insert(9);
        binaryTree.insert(8);
        binaryTree.insert(11);
        assertEquals(4, binaryTree.getHeight());
    }

    @Test
    public void testGetMinValue() {
        assertThrows(NoSuchElementException.class, binaryTree::getMinValue);

        binaryTree.insert(5);
        assertEquals(Integer.valueOf(5), binaryTree.getMinValue());

        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        assertEquals(Integer.valueOf(1), binaryTree.getMinValue());
    }

    @Test
    public void testGetMaxValue() {
        assertThrows(NoSuchElementException.class, binaryTree::getMaxValue);

        binaryTree.insert(5);
        assertEquals(Integer.valueOf(5), binaryTree.getMaxValue());

        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        assertEquals(Integer.valueOf(7), binaryTree.getMaxValue());
    }

    @Test
    public void testNegativeAndZeroValues() {
        binaryTree.insert(0);
        binaryTree.insert(-5);
        binaryTree.insert(10);

        assertTrue(binaryTree.contains(0));
        assertTrue(binaryTree.contains(-5));
        assertTrue(binaryTree.contains(10));
        assertEquals(Integer.valueOf(-5), binaryTree.getMinValue());
        assertEquals(Integer.valueOf(10), binaryTree.getMaxValue());
    }

    @Test
    public void testSingleNodeTree() {
        binaryTree.insert(5);

        assertEquals(1, binaryTree.size());
        assertEquals(1, binaryTree.getHeight());
        assertEquals(Integer.valueOf(5), binaryTree.getMinValue());
        assertEquals(Integer.valueOf(5), binaryTree.getMaxValue());

        binaryTree.delete(5);
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    public void testDeleteNonExistentElement() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);

        binaryTree.delete(10); // Non-existent element
        assertEquals(3, binaryTree.size());
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(7));
    }

    @Test
    public void testDuplicateInsertions() {
        binaryTree.insert(5);
        binaryTree.insert(5); // Attempt to insert duplicate

        assertEquals(1, binaryTree.size());
        assertEquals(1, binaryTree.getHeight()); // Height should not increase
        assertTrue(binaryTree.contains(5));
    }


    @Test
    public void testTraverseInOrder() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);

        DoubleLinkedFifo<Integer> queue = binaryTree.traverseInOrder();// Expected output: 1 3 4 5 7

        DoubleLinkedFifo<Integer> queue2 = getQueue(1, 3, 4, 5, 7);

        assertEquals(queue, queue2);
    }

    @Test
    public void testTraversePreOrder() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);

        // Expected Preorder: 5, 3, 1, 4, 7
        DoubleLinkedFifo<Integer> expected = getQueue(5, 3, 1, 4, 7);
        DoubleLinkedFifo<Integer> actual = binaryTree.traversePreOrder();

        assertEquals(expected, actual);
    }

    @Test
    public void testTraversePostOrder() {
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);

        // Expected Postorder: 1, 4, 3, 7, 5
        DoubleLinkedFifo<Integer> expected = getQueue(1, 4, 3, 7, 5);
        DoubleLinkedFifo<Integer> actual = binaryTree.traversePostOrder();

        assertEquals(expected, actual);
    }


    private <T> DoubleLinkedFifo<T> getQueue(T... args) {
        DoubleLinkedFifo<T> queue = new DoubleLinkedFifoImpl<>();
        for (T arg : args) {
            queue.enqueue(arg);
        }
        return queue;
    }
}