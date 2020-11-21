public interface ILinkedList {
    void add(int index, Object element);

    void add(Object element);

    Object get(int index);

    void set(int index, Object element);

    void clear();

    boolean isEmpty();

    void remove(int index);

    int size();

    boolean contains(Object o);
}
