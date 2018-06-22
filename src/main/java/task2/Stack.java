package task2;

interface Stack<T> {

    boolean push(T value);

    T pop();

    boolean isEmpty();

    int size();
}
