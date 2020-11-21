package eg.edu.alexu.csd.datastructure.queue;

public class LQueue implements IQueue, ILinkedBased {
	private Node front, rear;
	private int currentSize;

	private class Node {
		private Object data;
		private Node next;
	}

	public LQueue() {
		front = null;
		rear = null;
		currentSize = 0;
	}

	@Override
	public void enqueue(Object item) {
		Node oldRear = rear;
		rear = new Node();
		rear.data = item;
		rear.next = null;
		if (isEmpty()) {
			front = rear;
		} else {
			oldRear.next = rear;
		}
		currentSize++;
	}

	@Override
	public Object dequeue() {
		if (isEmpty()) { /// rear = null ; ????????
			throw new RuntimeException("Queue is empty!!");
		} else {
			Object item = front.data;
			front = front.next;
			currentSize--;
			return item;
		}
	}

	@Override
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	@Override
	public int size() {
		return currentSize;
	}

}
