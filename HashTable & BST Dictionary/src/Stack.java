
public class Stack {
    private static class Node{
        Object data;
        Node next;

        private Node(Object data, Node next) {
            this.data = data;
            this.next=next;
        }
    }
    Node top = null;
    int size = 0;

    public Object pop() {
       if(size()==0)
           throw new NullPointerException("Empty Stack");
        Object removed = top.data;
        top = top.next;
        size--;
        return removed;
    }


    public Object peek() {
        if(size()==0)
            throw new NullPointerException("Empty Stack");
        return top.data;
    }


    public void push(Object element) {
        top = new Node(element, top);
     size++;
    }


    public boolean isEmpty() {
        return (size()==0);
    }


    public int size() {
        return size;
    }
}
