package gd_collections.lists;

import java.util.Iterator;
import java.util.LinkedList;

import gd_collections.GbList;
import gd_collections.lists.util.ArrayIterator;

public class GbLinkedList<T> implements GbList<T> {

    private Node<T> head;
    private int size;

    @SuppressWarnings("hiding")
    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<T>(value);
        if (head == null) {
            head = node;

        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(toArray());
    }

    private T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size()];
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void remove(T value) {
        Node<T> current = head;
        Node<T> prev = null;
    
        while (current != null) {
            if (current.value.equals(value)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        
        size--;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        if (builder.length() == 1)
            return "[]";
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();

    }

}
