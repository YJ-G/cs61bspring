public class LinkedListDeque<T>{
    private class Node{
        public Node prev;
        public T item;
        public Node next;
        public Node(Node i, T j, Node k){
            prev = i;
            item = j;
            next = k;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        size = 0;
    }

    public void addFirst(T item){
        if(size == 0){
            sentinel.next = new Node(sentinel, item, sentinel);
            size = size + 1;
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size = size + 1;
        }

    }

    public void addLast(T item){
        if(size == 0){
            sentinel.next = new Node(sentinel, item, sentinel);
            size = size + 1;
            sentinel.prev = sentinel.next;
        }
        else {
            sentinel.prev.next = new Node(sentinel.prev, item, sentinel);
            size = size + 1;
        }
    }

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
            return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(size == 0){
            System.out.println("The Deque is empty");
        }
        else{
            Node sentinel_al = sentinel;
            for(int i = size; i > 0; i--){
                System.out.print(sentinel_al.next.item + " ");
                sentinel_al = sentinel_al.next;
        }
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        else {

            T removeditem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
            return removeditem;

        }
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        else {
            T removeditem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
            return removeditem;
        }
    }

    public T get(int index){
        if(index > size - 1 || size == 0 || index < 0){
            return null;
        }
        else {
             Node sentinel_al = sentinel;
            for(int i = index+1; i > 0; i--){
                sentinel_al = sentinel_al.next;
            }
            return sentinel_al.item;
        }
    }

    private T getRecursive(int index, Node sen){
        if(index > size - 1 || size == 0 || index < 0){
            return null;
        }
        else if(index == 0 ){
            return sen.next.item;
        }
        else {

            return getRecursive(index - 1, sen.next);
        }

    }
    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }
}