package task4;

public interface Stack<T> {

    boolean push(T value);

    T pop();

    boolean isEmpty();

    int size();
}
