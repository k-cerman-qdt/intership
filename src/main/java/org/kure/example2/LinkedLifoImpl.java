package org.kure.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedLifoImpl<T> implements LinkedLifo<T> {
    private Element<T> head;

    private record Element<T>(Element<T> prev, T data) {
    }

    @Override
    public void push(T data) {
        if (head == null) {
            head = new Element<>(null, data);
        } else {
            Element<T> current = head;
            head = new Element<>(current, data);
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.prev;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public int size() {
        int i = 0;
        if (head == null) {
            return i;
        }
        Element<T> x = head;
        while (x != null) {
            i++;
            x = x.prev;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public String display() {
        List<String> res = new ArrayList<>();
        Element<T> x = head;
        while (x != null) {
            res.add(x.data.toString());
            x = x.prev;
        }
        return String.join(", ", res);
    }
}
