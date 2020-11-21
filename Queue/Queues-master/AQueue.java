package eg.edu.alexu.csd.datastructure.queue;

public class AQueue {
    Object[] queue;
    int size=0;
    int front=0 ;
    int rear=0 ;
    int queue_size;

    public AQueue (int n) {
        queue= new Object[n];
        queue_size=n;
    }

    public void enqueue(Object item) {
        if(size==queue_size)
            throw new RuntimeException("the queue is full");
        queue[rear]= item;
        rear=(rear+1)%queue_size;
        size++;

    }

    public Object dequeue() {
        if(size==0)
            throw new RuntimeException("the queue is empty");
        Object data = queue[front];
        queue[front]=null;
        front=(front+1)%queue_size;
        size--;
        return data;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size==0);
    }

}