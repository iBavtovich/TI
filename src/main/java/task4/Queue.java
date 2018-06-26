package task4;

public interface Queue<T> {

    boolean offer(T value);

    T poll();

    int size();

    boolean isEmpty();
}
