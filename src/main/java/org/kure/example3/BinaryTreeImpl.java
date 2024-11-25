package org.kure.example3;

import org.kure.example1.DoubleLinkedFifo;

import java.util.NoSuchElementException;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

    @Override
    public void insert(T key) {

    }

    @Override
    public void delete(T key) {

    }

    @Override
    public T search(T key) {
        return null;
    }

    @Override
    public boolean contains(T key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public T getMinValue() throws NoSuchElementException {
        return null;
    }

    @Override
    public T getMaxValue() throws NoSuchElementException {
        return null;
    }

    @Override
    public DoubleLinkedFifo<T> traverseInOrder() {
        return null;
    }

    @Override
    public DoubleLinkedFifo<T> traversePreOrder() {
        return null;
    }

    @Override
    public DoubleLinkedFifo<T> traversePostOrder() {
        return null;
    }
}
