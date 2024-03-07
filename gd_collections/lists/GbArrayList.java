package gd_collections.lists;

import java.util.Arrays;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import gd_collections.GbList;
import gd_collections.lists.util.ArrayIterator;

public class GbArrayList<E> implements GbList<E> {

    private E[] values;

    private int size;

    private int capacity;

    @SuppressWarnings("unchecked")
    public GbArrayList() {
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (E[]) new Object[capacity];
        } catch(ClassCastException e) {
            e.printStackTrace();
        }
    }


    private void addCapacity() {
        capacity = capacity + capacity  / 2;
        E[] array = (E[]) new Object[capacity];
        System.arraycopy(values, 0, array, 0, values.length);

        this.values = array;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }

    @Override
    public void add(E value) {
        if (size == capacity) {
            addCapacity();
        }
        values[size++] = value;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void remove(E value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                removeByIndex(i);
                return;    
            }
        }
        throw new RuntimeException("Fall");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeByIndex(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }


    @Override
    public int size() {
        return size;
    }

}
