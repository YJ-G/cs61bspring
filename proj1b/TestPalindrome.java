import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertTrue(palindrome.isPalindrome("cc"));
        assertTrue(palindrome.isPalindrome("ffff"));
        assertTrue(palindrome.isPalindrome("acbdbca"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("ca"));
        assertFalse(palindrome.isPalindrome("wonderful"));
        assertFalse(palindrome.isPalindrome("woon"));
        assertFalse(palindrome.isPalindrome("disis"));
        assertFalse(palindrome.isPalindrome("liek"));
    }

    @Test
    public void testisPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("acedb", new OffByOne()));
        assertTrue(palindrome.isPalindrome("a", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("ab", new OffByOne()));
        assertTrue(palindrome.isPalindrome("ba", new OffByOne()));
        assertFalse(palindrome.isPalindrome("aceds", new OffByOne()));
        assertFalse(palindrome.isPalindrome("acedss", new OffByOne()));
    }
    @Test
    public void testIsPalindromeOffByOne0Or1() {
        String s0 = "";
        String s1 = "a";
        assertTrue(palindrome.isPalindrome(s0, new OffByOne()));
        assertTrue(palindrome.isPalindrome(s1, new OffByOne()));
    }

    @Test
    public void testIsPalindromeOffByOneOdd() {
        String sTrue = "flake";
        String sFalse = "frake";
        assertTrue(palindrome.isPalindrome(sTrue, new OffByOne()));
        assertFalse(palindrome.isPalindrome(sFalse, new OffByOne()));
    }

    @Test
    public void testIsPalindromeOffByOneEven() {
        String sTrue = "abcb";
        String sFalse = "abbb";
        assertTrue(palindrome.isPalindrome(sTrue, new OffByOne()));
        assertFalse(palindrome.isPalindrome(sFalse, new OffByOne()));
    }

}
