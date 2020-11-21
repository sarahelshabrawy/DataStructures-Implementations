package eg.edu.alexu.csd.datastructure.linkedList.cs24_cs28;

public class SinglyLinkedList implements ILinkedList {
    private class Node {
        private Object data;
        private Node next;
        private Node(Object element) {
            this.data = element;
            this.next = null;
        }
    }
    private Node head;
    private int size=0 ;
    SinglyLinkedList() {
        head = null ;
    }

    @Override
    public void add(int index, Object element) {
        if(index>=0) {
            Node node = new Node(element);
            node.data = element ;
            node.next = null;
            if(index==0) {
                node.next = head;
                head = node;
            }else {
                Node n = head;
                for(int i=0;i<index-1;i++) {
                    n=n.next;
                }
                node.next = n.next;
                n.next = node;
            }
            size++;
        }else
            throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    @Override
    public void add(Object element) {
        Node node = new Node(element);
        node.data = element ;
        node.next = null;
        if(head==null) {
            head =node;
        }else {
            Node n = head;
            while(n.next!=null) {
                n = n.next;
            }
            n.next = node ;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if(index>=size || index <0) {
            throw new ArrayIndexOutOfBoundsException("List is out of size");
        }else if(index==0) {
            Node n = head ;
            return n.data;
        }else {
            Node n = head ;
            for(int i=0 ; i<index ;i++) {
                n=n.next;
            }
            return n.data;
        }
    }

    @Override
    public void set(int index, Object element) {
        if(index>=size || index <0) {
            throw new ArrayIndexOutOfBoundsException("List is out of size");
        }else if(index==0) {
            Node n = head ;
            n.data = element;
        }else {
            Node n = head ;
            for(int i=0 ; i<index ;i++) {
                n=n.next;
            }
            n.data = element;
        }

    }

    @Override
    public void clear() {
        if(size>0) {
            while(size>0){
                remove(0);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;

    }

    @Override
    public void remove(int index) {
        if(size>0 && index>=0 && index<size) {
            if(size==1) {
                head = null ;
            }else if(index == 0) {
                head = head.next;
            }else {
                Node n = head;
                Node n1 = null ;
                for(int i=0;i<index-1;i++) {
                    n=n.next;
                }
                n1 = n.next;
                n.next = n1.next;
                n1 = null ;
            }
            size--;
        }else
            throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        SinglyLinkedList sublist = new SinglyLinkedList();
        //ILinkedList sublist = (ILinkedList) new LinkedList<Object>();
        Node n2 = head;
        for(int i=0 ;i<fromIndex ; i++) {
            if(n2.next == null)
                throw new ArrayIndexOutOfBoundsException("List is out of size");
            else
                n2 = n2.next ;
        }
        for(int i=fromIndex ;i<=toIndex ; i++) {
            if(n2.next == null)
                throw new ArrayIndexOutOfBoundsException("List is out of size");
            else {
                sublist.add(n2.data);
                n2 = n2.next ;
            }
        }
        return  sublist ;
    }

    @Override
    public boolean contains(Object o) {
        if(size==0) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        }else {
            Node n = head;
            boolean flag = false;
            while(n!=null) {
                if(n.data==o) {
                    flag = true;
                    break;
                }else {
                    n = n.next;
                }
            }
            return flag;
        }
    }
    public void print (){
        SinglyLinkedList.Node current = head;
        System.out.println("PRINTING STARTS");
        System.out.println("size is " + size());
        for (int i = 0; i < size ; i++) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("PRINTING ENDSSSSSSSSSS !!!");
    }
}
