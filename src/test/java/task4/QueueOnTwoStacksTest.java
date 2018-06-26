package task4;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class QueueOnTwoStacksTest {

    private Queue<Integer> queue;

    @Before
    public void init() {
        queue = new QueueOnTwoStacks<>();
    }

    @Test
    public void offer() {
        assertThat(queue.size(), is(0));
        queue.offer(1);
        assertThat(queue.size(), is(1));
        queue.offer(2);
        assertThat(queue.size(), is(2));
        assertTrue(queue.offer(3));
    }

    @Test
    public void poll() {
        assertNull(queue.poll());
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
        assertThat(queue.size(), is(6));
    }

    @Test
    public void size() {
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        assertThat(queue.size(), is(10));
        for (int i = 0; i < 10; i++) {
            queue.poll();
        }
        assertThat(queue.size(), is(0));

    }

}