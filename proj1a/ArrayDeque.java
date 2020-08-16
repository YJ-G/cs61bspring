public class ArrayDeque<T> {

    private int nextFirst;
    private int nextLast;
    private int size;
    private T[] items ;
    private double upsize_factor;
    private double downsize_factor;

    public ArrayDeque() {
        items = (T[])new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        upsize_factor = 2;
        downsize_factor = 0.5;
    }

    private void resize(double factor) {
        T[] newarray = (T[])new Object[(int)(items.length*factor)];
        int currentfirst = update(nextFirst,1);
        int currentlast = update(nextLast,-1);
        if (currentfirst >currentlast) {
            System.arraycopy(items,currentfirst,newarray,newarray.length - (items.length - currentfirst),items.length - currentfirst);
            System.arraycopy(items,0,newarray,0,currentlast+1);
            nextFirst = newarray.length - (items.length - currentfirst) - 1;
            nextLast = currentlast + 1;
            items = newarray;
        } else {
            System.arraycopy(items,currentfirst,newarray,0,size);
            nextFirst = newarray.length-1;
            nextLast = size;
            items = newarray;
        }
    }

    private void upsize() {
        resize(upsize_factor);
    }

    private void downsize() {
        resize(downsize_factor);
    }

    private int update(int a, int flag) {
        if ((a + flag) >= 0) {
            return (a + flag) % items.length;
        } else {
            return (a + flag) % items.length + items.length;
        }

    }

    public void addFirst(T item) {
        if (size < items.length) {
            items[nextFirst] = item;
            size = size + 1;
            nextFirst = update(nextFirst,-1);
        } else {
            upsize();
            items[nextFirst] = item;
            size = size + 1;
            nextFirst = update(nextFirst,-1);
        }
    }

    public void addLast(T item) {
        if (size < items.length) {
            items[nextLast] = item;
            size = size + 1;
            nextLast = update(nextLast,1);
        } else {
            upsize();
            items[nextLast] = item;
            size = size + 1;
            nextLast = update(nextLast,1);
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("The Deque is empty");
        } else {
            for (int i = 1; i < size + 1; i ++) {
                System.out.print(items[(nextFirst + i) % items.length] + " ");
            }
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        } else {
            nextFirst = update(nextFirst,1);
            T a = items[nextFirst];
            items[nextFirst] = null;
            size = size - 1;
            if (items.length >= 16 && (double)size/(double)items.length < 0.26) {
                downsize();
            }
            return a;
        }
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        } else {
            nextLast = update(nextLast,-1);
            T a = items[nextLast];
            items[nextLast] = null;
            size = size - 1;
            if (items.length >= 16 && (double)size/(double)items.length < 0.26) {
                downsize();
            }
            return a;
        }
    }

    public T get(int index) {
        if (index > size - 1 || size == 0 || index < 0) {
            return null;
        } else {
            return items[update(nextFirst,index + 1)];
        }

    }


}

