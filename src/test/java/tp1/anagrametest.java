package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class anagrametest {

    @Test
    void testAnagramTrue() {
        assertTrue(Anagrame.isAnagram("listen", "silent"));
    }

    @Test
    void testAnagramFalse() {
        assertFalse(Anagrame.isAnagram("hello", "world"));
    }

    @Test
    void testAnagramWithSpaces() {
        assertTrue(Anagrame.isAnagram("anagram", " nagaram "));
    }

    @Test
    void testAnagramNull() {
        assertThrows(NullPointerException.class, () -> {
            Anagrame.isAnagram(null, "test");
        });
    }

    @Test
    void testAnagramDifferentLengths() {
        assertFalse(Anagrame.isAnagram("short", "longer"));
    }
}
