public class OffByOne implements CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    public boolean equalChars(char x, char y) {
        if (x - y == 1 || y - x == 1) {
            return true;
        } else {
            return false;
        }
    }
}