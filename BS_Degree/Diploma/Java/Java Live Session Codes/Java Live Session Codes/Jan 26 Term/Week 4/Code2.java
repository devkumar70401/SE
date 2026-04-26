package week4;

/*Iterators: 
 * We have already seen the use of interfaces to interact with a 
 * private class using a public object, and how such an approach provides
 * security/encapsulation along with utility. Here we will observe one
 * such application of interfaces with private class which is iterators.
 * */

import java.util.Random;
interface Iterable{ 
	boolean has_next();
	Object get_next();
}
//used the interface name as Iterable instead of Iterator(in slide)

class Linearlist{
	
	private class Node{
		int data;
		Node next;
		
		Node(Object o){	
			this.data = (Integer)o;
			this.next = null;
		}
		private int get_data() {
			return (this.data);
		}
	}
	
	private Node head;
	private int size;
	
	
	public Linearlist() {
		size = 0;
		head = null;
	}
	public void append(Object o) {
		
		if(head == null) {
			Node n = new Node(o);
			head = n;
		}
		else {
			Node m;
			for(m = head ; m.next != null; m = m.next) {}
			Node n = new Node(o);
			m.next = n;
		}
		size++;
	}
	
	public int show_data(Object o) {
		return ((Node)o).get_data();
	}
	
	private class Iter implements Iterable{ 
		
		private Node position;
		
		Iter(){
			position = head;
		}
		public boolean has_next() {
			if(position == null)
				return false;
			else
				return true;
		}
		public Object get_next() {
			Node temp = position;
			position = position.next;
			return temp;
		}
	}
	
	public Iterable get_iterator() {
		Iterable it = new Iter();	//Iter it =  new Iter() in slides
		return it;
	}
}

public class Code2 {

	public static void main(String[] args) {
		
		Linearlist l = new Linearlist();
		for(int c = 1;c <= 10 ; c++)
			l.append(Integer.valueOf(new Random().nextInt(50))); // 0 to 50 is range
		
		Object o;		
		Iterable i = l.get_iterator();
		
		//Task : Count the values > 20
		int count = 0;
		while(i.has_next()) {
			o = i.get_next();
			int value = l.show_data(o);
			System.out.print(value + ", ");
			if(value > 20)	count++;
		}
		System.out.println("\nNumber of values greater than 20 in the random list is  : "
				+ count);

	}

}
