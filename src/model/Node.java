package model;

public class Node<T> {
	
	private T info;
	private Node<T> next;
	private Node<T> before;
	
	public Node(T info) {
		this.info=info;
		next=null;
		before=null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getBefore() {
		return before;
	}

	public void setBefore(Node<T> before) {
		this.before = before;
	}


}
