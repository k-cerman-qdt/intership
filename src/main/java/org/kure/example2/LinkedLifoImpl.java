package org.kure.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedLifoImpl<T> implements LinkedLifo<T> {

    @Override
    public void push(T data) {
    }

    @Override
    public T pop() {
        return null
    }

    @Override
    public T peek() {
        return null;
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
    public void clear() {
    }

    @Override
    public String display() {
        return "display me"
    }
}
