package task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CyclicLinkedListTest {


    @Test
    public void add() {
        CyclicLinkedList<Integer> list = new CyclicLinkedList<Integer>();
        list.add(5);
        assertThat(list.length(), is(1));
        assertThat(list.get(0), is(5));
    }

    @Test
    public void get() {
        CyclicLinkedList<Integer> list = new CyclicLinkedList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        assertThat(list.length(), is(4));
        assertThat(list.get(0), is(5));
        assertThat(list.get(1), is(6));
        assertThat(list.get(2), is(7));
        assertThat(list.get(3), is(10));
    }

    @Test
    public void delete() {
        CyclicLinkedList<Integer> list = new CyclicLinkedList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        assertThat(list.length(), is(4));
        assertThat(list.get(2), is(7));
        list.delete(2);
        assertThat(list.length(), is(3));
        assertThat(list.get(2), is(10));
    }

    @Test
    public void head() {
        CyclicLinkedList<Integer> list = new CyclicLinkedList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        assertThat(list.head(), is(5));
        list.delete(0);
        assertThat(list.head(), is(6));
    }

    @Test
    public void tail() {
        CyclicLinkedList<Integer> list = new CyclicLinkedList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        assertThat(list.tail(), is(10));
        list.delete(list.length() - 1);
        assertThat(list.tail(), is(7));
    }
}