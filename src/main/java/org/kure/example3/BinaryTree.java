package org.kure.example3;

import org.kure.example1.DoubleLinkedFifo;

import java.util.NoSuchElementException;

/**
 * Represents a generic Binary Tree structure that supports basic operations such as
 * insertion, deletion, search, traversal, and utility methods for managing tree data.
 *
 * @param <T> the type of elements stored in the binary tree. The type must be comparable.
 */
public interface BinaryTree<T> {

    /**
     * Inserts a new key into the binary tree.
     *
     * @param key the key to be inserted into the tree.
     *            Duplicate keys may be ignored based on implementation.
     */
    public void insert(T key);

    /**
     * Deletes a key from the binary tree.
     *
     * @param key the key to be deleted from the tree.
     *            If the key does not exist, the tree remains unchanged.
     */
    public void delete(T key);

    /**
     * Searches for the specified key in the binary tree.
     *
     * @param key the key to search for
     * @return the key if it exists in the tree, or {@code null} if the key is not found
     */
    public T search(T key);

    /**
     * Checks whether a key exists in the binary tree.
     * This is functionally identical to {@link #search(Object)}.
     *
     * @param key the key to check for existence.
     * @return {@code true} if the key exists in the tree, {@code false} otherwise.
     */
    public boolean contains(T key);

    /**
     * Returns the total number of elements currently stored in the binary tree.
     *
     * @return the size of the tree.
     */
    public int size();

    /**
     * Checks whether the binary tree is empty.
     *
     * @return {@code true} if the tree contains no elements, {@code false} otherwise.
     */
    public boolean isEmpty();

    /**
     * Calculates the height of the binary tree.
     * The height is defined as the number of edges on the longest path from the root
     * to a leaf node.
     *
     * @return the height of the tree. Returns 0 for an empty tree.
     */
    public int getHeight();

    /**
     * Finds the minimum value stored in the binary tree.
     *
     * @return the smallest value in the tree.
     * @throws NoSuchElementException if the tree is empty.
     */
    public T getMinValue() throws NoSuchElementException;

    /**
     * Finds the maximum value stored in the binary tree.
     *
     * @return the largest value in the tree.
     * @throws NoSuchElementException if the tree is empty.
     */
    public T getMaxValue() throws NoSuchElementException;

    /**
     * Performs an in-order traversal of the binary tree.
     * In-order traversal visits nodes in ascending order for a Binary Search Tree.
     *
     * @return a {@link DoubleLinkedFifo} containing the elements in in-order sequence.
     */
    public DoubleLinkedFifo<T> traverseInOrder();

    /**
     * Performs a pre-order traversal of the binary tree.
     * Pre-order traversal visits the root node before its subtrees.
     *
     * @return a {@link DoubleLinkedFifo} containing the elements in pre-order sequence.
     */
    public DoubleLinkedFifo<T> traversePreOrder();

    /**
     * Performs a post-order traversal of the binary tree.
     * Post-order traversal visits the root node after its subtrees.
     *
     * @return a {@link DoubleLinkedFifo} containing the elements in post-order sequence.
     */
    public DoubleLinkedFifo<T> traversePostOrder();
}
