package task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class SimpleStack<T> implements Stack<T> {

    private Node<T> last;
    private int size;


    @Override
    public boolean push(T value) {
        if (size != 0) {
            last = new Node<>(value, last);
        } else {
            last = new Node<>(value);
        }
        size++;
        return true;
    }

    @Override
    public T pop() {
        T deletedValue = null;
        if (size != 0){
            deletedValue = last.getValue();
            last = last.getPrev();
            size--;
        }
        return deletedValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Node<T> {

        private T value;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
