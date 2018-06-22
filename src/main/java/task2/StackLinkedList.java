package task2;

public class StackLinkedList<T> implements Stack<T>  {

    private int size;
    private Node<T> last;

    public boolean push(T value) {
        if (isEmpty()) {
            last = new Node<T>(value);
        } else {
            last = new Node<T>(value, last);
        }
        size++;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            throw new ArithmeticException();
        } else {
            T value = last.value;
            last = last.prev;
            size--;
            return value;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
