package tp1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class palindrometest {

    @Test
    void testPalindromeSimple() {
        assertTrue(palindrome.isPalindrome("kayak"));
    }
}
