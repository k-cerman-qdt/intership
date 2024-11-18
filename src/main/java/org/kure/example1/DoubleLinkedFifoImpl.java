package org.kure.example1;

import java.util.NoSuchElementException;

public class DoubleLinkedFifoImpl<T> implements DoubleLinkedFifo<T> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void enqueue(T data) {

    }

    @Override
    public T dequeue() throws NoSuchElementException {
        return null;
    }

    @Override
    public T peek() throws NoSuchElementException {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public void display() {
        System.out.println("Vypis muj obsah :)");
    }
}
