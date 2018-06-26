package task4;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {


    private Stack<Integer> stack;

    @Before
    public void before() {
        stack = new SimpleStack<>();
    }

    @Test
    public void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.size(), Is.is(3));
    }

    @Test
    public void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.pop(), Is.is(4));
        assertThat(stack.pop(), Is.is(3));
        assertThat(stack.pop(), Is.is(2));
        assertThat(stack.pop(), Is.is(1));
        assertThat(stack.size(), Is.is(0));
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void size() {
        assertThat(stack.size(), Is.is(0));
        stack.push(1);
        assertThat(stack.size(), Is.is(1));
    }
}