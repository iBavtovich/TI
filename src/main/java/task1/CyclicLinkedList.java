package task1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class CyclicLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public boolean add(T value) {
        if (size == 0) {
            Node<T> node = new Node<T>(value);
            node.next = node;
            node.prev = node;
            first = last = node;
        } else {
            Node<T> node = new Node<T>(last, value, first);
            last.next = node;
            first.prev = node;
            last = node;
        }
        size++;
        return true;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> node = getNodeByIndex(index);
        return node.item;
    }

    public T delete(int index) {
        checkIndex(index);

        Node<T> deleteNode = getNodeByIndex(index);
        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;

        if (index == 0) {
            first = deleteNode.next;
        } else if (index == size - 1) {
            last = deleteNode.prev;
        }
        size--;
        return deleteNode.item;
    }

    public int length() {
        return size;
    }

    public T head() {
        return first.item;
    }

    public T tail() {
        return last.item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> node;
        int median = size % 2 == 0 ? (size >> 1) - 1 : size >> 1;
        if (index <= median) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 2; i >= index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private static class Node<T> {

        T item;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.item = value;
        }

        Node(Node<T> prev, T value, Node<T> next) {
            this.item = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
