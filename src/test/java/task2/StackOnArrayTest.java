package task2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StackOnArrayTest {

    @Test
    public void push() {
        Stack<Integer> stack = new StackOnArray<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertThat(stack.size(), is(1));
        stack.push(10);
        assertThat(stack.size(), is(2));
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        assertThat(stack.size(), is(11));
    }

    @Test
    public void pop() {
        Stack<Integer> stack = new StackOnArray<>();
        stack.push(1);
        stack.push(10);
        assertThat(stack.pop(), is(10));
        assertThat(stack.size(), is(1));
        assertThat(stack.pop(), is(1));
        assertThat(stack.size(), is(0));
    }

    @Test(expected = ArithmeticException.class)
    public void popException() {
        Stack<Integer> stack = new StackOnArray<>();
        stack.pop();
    }

    @Test
    public void isEmpty() {
        Stack<Integer> stack = new StackOnArray<>();
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void size() {
        Stack<Integer> stack = new StackOnArray<>();
        stack.push(1);
        assertThat(stack.size(), is(1));
        stack.pop();
        assertThat(stack.size(), is(0));
    }
}