public class ArrayDequeTest {

    public static void test() {

        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(4);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.addLast(3);
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.printDeque();
        System.out.println(a.size());


    }

    public static void main(String[] args) {
       // System.out.println(-1%8);
        test();


    }
}