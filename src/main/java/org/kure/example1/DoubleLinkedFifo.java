package org.kure.example1;

import java.util.NoSuchElementException;

public interface DoubleLinkedFifo<T> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param data the element to be added to the queue
     */
    public void enqueue(T data);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() throws NoSuchElementException;

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size();

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Removes all elements from the queue, making it empty.
     */
    public void clear();

    /**
     * Displays the elements in the queue.
     */
    public void display();
}
