import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayGridTest {
    static final int WIDTH = 10;
    static final int HEIGHT = 15;
    Grid<String> grid;

    /**
     * Populates a new grid to be used in testing
     */
    @Before
    public void setup() {
        grid = new ArrayGrid<>(WIDTH, HEIGHT);

        grid.add(5, 5, "Override me");
        grid.add(5, 5, "Hello");
        grid.add(0, 0, "World");
        grid.add(0, 14, "UQ");
        grid.add(9, 0, "COMP3506");
        grid.add(9, 14, "COMP7505");
    }

    /**
     * Assert that the grid is correctly populated
     */
    void assertItems() {
        assertEquals("Hello", grid.get(5, 5));
        assertEquals("World", grid.get(0, 0));
        assertEquals("UQ", grid.get(0, 14));
        assertEquals("COMP3506", grid.get(9, 0));
        assertEquals("COMP7505", grid.get(9, 14));
    }

    /**
     * Assert that the grid is empty
     */
    void assertEmpty() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                assertNull(grid.get(i, j));
            }
        }
    }

    @Test(timeout=1000)
    public void testGet() {
        assertItems();
    }

    @Test(timeout=1000)
    public void testRemove() {
        assertTrue(grid.remove(5, 5));
        assertTrue(grid.remove(0, 0));
        assertTrue(grid.remove(0, 14));
        assertTrue(grid.remove(9, 0));
        assertTrue(grid.remove(9, 14));

        assertFalse(grid.remove(5, 5));
        assertEmpty();
    }

    @Test(timeout=1000)
    public void testResizeLarger() {
        grid.resize(WIDTH + 10, HEIGHT + 10);
        assertItems();

        assertNull(grid.get(19, 24));
    }
}
