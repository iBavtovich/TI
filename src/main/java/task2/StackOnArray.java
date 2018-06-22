package task2;

import java.lang.reflect.Array;

public class StackOnArray<T> implements Stack<T> {

    T[] values;
    int position;
    int size;

    public StackOnArray() {
        this.values = (T[]) new Object[10];
        this.size = 10;
        this.position = 0;
    }


    @Override
    public boolean push(T value) {
        if (position == size) {
            expandValuesArray();
        }
        values[position] = value;
        position++;
        return true;
    }

    @Override
    public T pop() {
        if (position == 0) {
            throw new ArithmeticException();
        }
        return values[--position];
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public int size() {
        return position;
    }

    private void expandValuesArray() {
        T[] newValues = (T[]) new Object[(int) (size * 1.5) + 1];
        System.arraycopy(values, 0, newValues,0, size);
        size = newValues.length;
        values = newValues;
    }
}
