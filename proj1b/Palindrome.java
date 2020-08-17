public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> a = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            a.addLast(word.charAt(i));
        }
        return a;
    }
    private boolean isPalindromeHelper(Deque a) {
        if (a.size() == 0 || a.size() ==1) {
            return true;
        } else {
            char b = (char) a.removeFirst();
            char c = (char) a.removeLast();
            if (b == c) {
                return isPalindromeHelper(a);
            } else {
                return false;
            }
        }

    }

    public boolean isPalindrome(String word) {
        Deque<Character> a = wordToDeque(word);
        return isPalindromeHelper(a);

    }
    private boolean isPalindromeHelper(Deque a, CharacterComparator cc) {
        if (a.size() == 0 || a.size() ==1) {
            return true;
        } else {
            char b = (char) a.removeFirst();
            char c = (char) a.removeLast();
            if (cc.equalChars(b, c)) {
                return isPalindromeHelper(a, cc);
            } else {
                return false;
            }
        }

    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> a = wordToDeque(word);
        return isPalindromeHelper(a, cc);
    }
}