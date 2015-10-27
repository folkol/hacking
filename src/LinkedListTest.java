import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class LinkedListTest {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("Again");

        System.out.println(list.containsAll(Arrays.asList("Hello", "World", "Again")));

        System.out.println(list.size());
        System.out.println(list.contains("Hello"));
        System.out.println(list.contains("Nisse"));

        list.remove("Hello");
        list.remove("Hello");
        list.remove("Hello");
        list.remove("Hello");
        System.out.println(list.contains("Hello"));
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());

        list.add("Test");
        System.out.println(list.size());

        list.add(0, "Test");
        System.out.println(list.size());
        list.add(2, "Test2");
        System.out.println(list.size());
        System.out.println(list.contains("Test"));

        list.forEach(System.out::print);
    }

    static class LinkedList<T> implements List<T> {

        static class Node<T> {
            T val;
            Node<T> next;

            public Node() {
            }

            public Node(T e) {
                val = e;
            }
        }

        Node<T> root = new Node<T>();
        int size;

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return root.next == null;
        }

        @Override
        public boolean contains(Object o) {
            Node<T> node = root.next;
            while (node != null) {
                if (Objects.equals(node.val, o)) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                Node<T> n = root;

                @Override
                public boolean hasNext() {
                    return n.next != null;
                }

                @Override
                public T next() {
                    n = n.next;
                    return n.val;
                }
            };
        }

        @Override
        public Object[] toArray() {
            Object[] ar = new Object[size];
            int c = 0;
            Iterator<T> it = iterator();
            while(it.hasNext()) {
                ar[c++] = it.next();
            }
            return null;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            if(size > a.length) {
                a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            Iterator<T> it = (Iterator<T>) iterator();
            int c = 0;
            while(it.hasNext()) {
                a[c++] = it.next();
            }
            if(a.length > size) {
                a[size] = null;
            }
            return null;
        }

        @Override
        public boolean add(T e) {
            Node<T> n = new Node<T>(e);

            Node<T> current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
            size++;

            return true;
        }

        @Override
        public boolean remove(Object o) {
            Node<T> prev = root;
            Node<T> node = root.next;
            while (node != null) {
                if (Objects.equals(node.val, o)) {
                    prev.next = node.next;
                    size--;
                    return true;
                }
                prev = prev.next;
                node = node.next;
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            for(Object o : c) {
                if(!this.contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            c.forEach(x -> add(x));
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends T> c) {
            c.forEach(x -> add(index, x));
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            c.forEach(x -> remove(x));
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void clear() {
            root.next = null;
            size = 0;
        }

        @Override
        public T get(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public T set(int index, T element) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void add(int index, T element) {
            if(index < 0) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> cur = root;
            for(int c = 0; c < index; c++) {
                if(cur.next == null) {
                    throw new IndexOutOfBoundsException();
                }
                cur = cur.next;
            }
            Node<T> n = new Node<>(element);
            n.next = cur.next;
            cur.next = n;
            size++;
        }

        @Override
        public T remove(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int indexOf(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public ListIterator<T> listIterator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ListIterator<T> listIterator(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<T> subList(int fromIndex, int toIndex) {
            // TODO Auto-generated method stub
            return null;
        }

    }

}
