package tp1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzz() {
        // Cas pour multiples de 3 et 5 (FizzBuzz)
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));

        // Cas pour multiples de 3 seulement (Fizz)
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));

        // Cas pour multiples de 5 seulement (Buzz)
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));

        // Cas pour des nombres qui ne sont pas multiples de 3 ni de 5
        assertEquals("7", FizzBuzz.fizzBuzz(7));
        assertEquals("11", FizzBuzz.fizzBuzz(11));

        // Cas pour les valeurs invalides (inférieures ou égales à 1)
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
    }
}
