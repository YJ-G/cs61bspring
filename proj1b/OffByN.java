public class OffByN implements CharacterComparator {
    private int offValue;
    public OffByN(int N) {
        offValue = N;
    }
    public boolean equalChars(char x, char y) {
        if (x - y == offValue || y - x == offValue) {
            return true;
        } else {
            return false;
        }
    }

}