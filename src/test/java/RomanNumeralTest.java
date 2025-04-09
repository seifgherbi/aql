package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {

    @Test
    public void testToRomanValidNumbers() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("III", RomanNumeral.toRoman(3));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("L", RomanNumeral.toRoman(50));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("C", RomanNumeral.toRoman(100));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("D", RomanNumeral.toRoman(500));
        assertEquals("CM", RomanNumeral.toRoman(900));
        assertEquals("M", RomanNumeral.toRoman(1000));
        assertEquals("MMMCMXCIV", RomanNumeral.toRoman(3994)); // Cas maximal
    }

    @Test
    public void testToRomanInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0)); // Nombres inférieurs à 1
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000)); // Nombres supérieurs à 3999
    }
}
l