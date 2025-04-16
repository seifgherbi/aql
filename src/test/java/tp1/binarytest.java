package tp1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tp1.binarysearch;

public class binarytest {

    @Test
    public void testBinarySearch_ElementFound() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int element = 5;
        int result = binarysearch.binarySearch(array, element);
        assertEquals(4, result, "The element should be at index 4.");
    }

    @Test
    public void testBinarySearch_ElementNotFound() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int element = 10;
        int result = binarysearch.binarySearch(array, element);
        assertEquals(-1, result, "The element should not be found.");
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        int[] array = {};
        int element = 5;
        int result = binarysearch.binarySearch(array, element);
        assertEquals(-1, result, "The element should not be found in an empty array.");
    }

    @Test
    public void testBinarySearch_NullArray() {
        int element = 5;
        assertThrows(NullPointerException.class, () -> {
            binarysearch.binarySearch(null, element);
        }, "Array must not be null");
    }
}
