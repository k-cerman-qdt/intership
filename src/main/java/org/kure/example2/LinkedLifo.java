package org.kure.example2;

import java.util.NoSuchElementException;

public interface LinkedLifo<T> {

        /**
         * Pushes an element onto the top of the stack.
         *
         * @param data the element to be pushed onto the stack
         */
        public void push(T data);

        /**
         * Removes and returns the element at the top of the stack.
         *
         * @return the element at the top of the stack
         * @throws NoSuchElementException if the stack is empty
         */
        public T pop() throws NoSuchElementException;

        /**
         * Returns the element at the top of the stack without removing it.
         *
         * @return the element at the top of the stack
         * @throws NoSuchElementException if the stack is empty
         */
        public T peek() throws NoSuchElementException;

        /**
         * Returns the number of elements in the stack.
         *
         * @return the number of elements in the stack
         */
        public int size();

        /**
         * Checks if the stack is empty.
         *
         * @return true if the stack is empty, false otherwise
         */
        public boolean isEmpty();

        /**
         * Removes all elements from the stack, making it empty.
         */
        public void clear();

        String display();
}
