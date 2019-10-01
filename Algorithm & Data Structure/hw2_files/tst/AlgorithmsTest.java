import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class AlgorithmsTest {

    @Test(timeout=1000)
    public void testSortQueueExample1() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(2);
        Algorithms.sortQueue(queue);
        assertEquals(1, (int)queue.remove());
        assertEquals(2, (int)queue.remove());
        assertEquals(3, (int)queue.remove());
        assertEquals(4, (int)queue.remove());
        assertEquals(5, (int)queue.remove());
        assertEquals(0, queue.size());
    }

    @Test(timeout=1000)
    public void testSortQueueExample2() {
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("b");
        queue.add("a");
        Algorithms.sortQueue(queue);
        assertEquals("a", queue.remove());
        assertEquals("a", queue.remove());
        assertEquals("b", queue.remove());
        assertEquals("b", queue.remove());
        assertEquals("c", queue.remove());
    }

    @Test(timeout=1000)
    public void testFindMissingNumberExample1() {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 18, 20};
        assertEquals(16, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout=1000)
    public void testFindMissingNumberExample2() {
        int[] arr = {4, 1, -5};
        assertEquals(-2, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout=1000)
    public void testFindMissingNumberExample3() {
        int[] arr = {4, 2 };
        assertEquals(3, Algorithms.findMissingNumber(arr));
    }

    /*********************************************************/

    @Test(timeout=1000)
    public void testFindMissingNumberExample4() {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 18, 20};
        assertEquals(16, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample5() {
        int[] arr = {1, -1, -5};
        assertEquals(-3, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout=1000)
    public void testFindMissingNumberExample6() {
        int[] arr = {4, 1, -5};
        assertEquals(-2, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample7() {
        int[] arr = {-31, -29, -27, -23};
        assertEquals(-25, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample8() {
        int[] arr = {-29, -27};
        assertEquals(-28, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample9() {
        int[] arr = {29, -27};
        assertEquals(1, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample10() {
        int[] arr = {-1, 5};
        assertEquals(2, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample11() {
        int[] arr = {-1, 5, 11, 17, 29};
        assertEquals(23, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample12() {
        int[] arr = {-31 , -25 ,-13 ,-7 ,-1, 5, 11, 17};
        assertEquals(-19, Algorithms.findMissingNumber(arr));
    }

    @Test(timeout = 1000)
    public void testFindMissingNumberExample13() {
        int[] arr = {-31 , -35 ,-43 ,-47 ,-51, -55, -59};
        assertEquals(-39, Algorithms.findMissingNumber(arr));
    }
}
