package model;

import java.util.ArrayList;
import java.util.Comparator;

public class ListedCircled<T> {

	private Comparator<T> comparator;
	private Node<T> head;

	public ListedCircled(Comparator<T> comparator) {
		this.comparator = comparator;
		head=null;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void addFirst(T info) {
		Node<T> node=new Node<T>(info);
		if(isEmpty()) {
			head=node;
			head.setNext(node);
		}else {
			node.setNext(head.getNext());
			head.setNext(node);
		}
	}
	
	public Node<T> findNode(T info){
		Node<T> it=head;
		do {
			if(comparator.compare(info, it.getInfo())==0) {
				return it;
			}
			it=it.getNext();
		}while(it!=head);
		return null;
	}
	
	/*public void addEnd(T info) {
		Node<T> node=new Node<T>(info);
		if(isEmpty()){
			head=node;
			head.setNext(node);
		}else {
			node.setNext(head.getNext());
			head.setNext(node.getNext());
			node=head.getNext();
			
		}
	}*/
	
	
	public void addEnd(T info)	{
		Node<T> node= new Node<T>(info);
		if (isEmpty()) {
			
			head.setNext(node);
			head.setBefore(node);
			
		}else {
		    node.setNext(head.getNext());
			head.getNext().setBefore(node);
			head.setNext(node);
			node.setBefore(head);
			head=node;
			
		}
		
	}
	 
	
	

	
	/*public Node<T> deleteNode(Node<T> node) {
		Node<T> aux=head;
		do {
			if(aux.getNext()==node) {
				aux.setNext(node.getNext());
				return node;
			}
			aux=aux.getNext();
		} while (aux!=head);
		return null;
	}*/
	  
	public Node<T> deleteNode(Node<T> node){
		Node<T> aux=head;
		do{
			if(node==head && aux.getNext()==head){
				aux.setNext(node.getNext());
				head=aux;
				return node;
			}else{
				if(aux.getNext()==node){
					aux.setNext(node.getNext());
					return node;
				}
				
			}
			aux=aux.getNext();
		}while(aux!=head);
		return null;
	}
	 
	
	public void addSorted(T info) {
		Node<T> node=new Node<T>(info);
		if(isEmpty()){
			head=node;
			head.setNext(node);
		}else {
			Node<T> aux=head;
			if(comparator.compare(info, head.getNext().getInfo())<0) {
				addFirst(info);
			}else if(comparator.compare(info, head.getInfo())>0){
				addEnd(info);
			}else {
				Node<T> act=head;
				while(comparator.compare(info, act.getNext().getInfo())>0) {
					act=act.getNext();
				}
				
			}
		}
	}
	
	public T findObject(T info) {
		Node<T> node=head;
		
		do {
			if(comparator.compare(node.getInfo(),info)==0) {
				return node.getInfo();
			}
			node=node.getNext();
		} while (node!=head);
		return null;
	}
	
	public ArrayList<T> getList(){
		Node<T> it=head;
		ArrayList<T> out=new ArrayList<T>();
		do {
			out.add(it.getNext().getInfo());
			it=it.getNext();
		}while(it!=head);
		return out;
	}
	
	public T getObject(int pos) {
		Node<T> node=head; 
		for (int i = 1; i <= getList().size(); i++) {
			if(i==pos) {
				return node.getInfo();
			}
			node=node.getNext();
		}
		
		return null;
	}
}
	

