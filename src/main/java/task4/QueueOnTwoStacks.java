package task4;


/*
 * На основе двух стэков реализовать очередь
 */
public class QueueOnTwoStacks<T> implements Queue<T> {

    Stack<T> writingStack;
    Stack<T> readingStack;

    int size;
    boolean isReading;

    public QueueOnTwoStacks() {
        writingStack = new SimpleStack<>();
        readingStack = new SimpleStack<>();
        size = 0;
    }

    @Override
    public boolean offer(T value) {
        if (isReading) {
            for (int i = 0; i < size; i++) {
                writingStack.push(readingStack.pop());
            }
            isReading = false;
        }
        writingStack.push(value);
        size++;
        return true;
    }

    @Override
    public T poll() {
        if (size ==0) {
            return null;
        }

        if (!isReading) {
            for (int i = 0; i < size; i++) {
                readingStack.push(writingStack.pop());
            }
            isReading = true;
        }
        size--;
        return readingStack.pop();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
