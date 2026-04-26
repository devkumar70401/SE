



/*
 * if we want to have structural polymorphism in java we can try by using 
 * Object type which can accept all kinds of object but we run into 
 * problems like,
 * 1)Can not enforce homogeneity
 * 2)Can not enforce selective subtype-supertype behaviour
 *    It might appear we can do so by implementin an interface but no
 * 3)Risk of exception at runtime because of wrong instance type handling. 
 */

//GENERIC LINKEDLIST


interface Iterable{ 
	boolean has_next();
	Object get_next();
}
//used the interface name as Iterable instead of Iterator(in slide)

class LinkedList<T>{
	

	
	private int size;
	private Node first;

	public LinkedList() {
		size = 0;
		first = null;
	}

	public T head(){      // information about head() is not provided
		T returnval;      // but we can use this list as a FIFO order 
		returnval = first.data; //linkedlist and hence use this 
		first = first.next; //method to return the head-value and move  
		size--;            //the first reference ahead
		return returnval;
	}					    
	//generic method
	public void insert(T newdata){  
		if(first == null) {
			Node n = new Node(newdata);
			first = n;
		}
		else {
			Node m;
			for(m = first ; m.next != null; m = m.next) {}
			Node n = new Node(newdata);
			m.next = n;
		}
		size++;
	}
	private class Node{
		private T data;
		private Node next;
		
		Node(T o){	
			this.data = o;
			this.next = null;
		}
	}
	
	private class Iter implements Iterable{ 
		
		private Node position;
		
		Iter(){
			position = first;
		}
		public boolean has_next() {
			if(position == null)
				return false;
			else
				return true;
		}
		public T get_next() {  //Here we changed the definition to return the
			Node temp = position; //data rather than the Node object
			position = position.next;
			return temp.data;
		}
	}
	
	public Iterable get_iterator() {
		Iterable it = new Iter();	//Iter it =  new Iter() in slides
		return it;
	}
}
interface Printable{
	void getValue();
}
class Ticket implements Printable{
	private String id;
	Ticket(String i){
		id = i;
	}
	public void getValue(){
		System.out.println("Ticket id: "+id);
	}
}
class Date implements Printable{
	private String date;
	Date(String d){
		date = d;
	}
	public void getValue(){
		System.out.println("Today's date: "+date);
	}
}
public class Code5 {
    public static void main(String args[]){
       LinkedList<Ticket> ticketlist = new LinkedList<Ticket>();
	   LinkedList<Date> datelist = new LinkedList<Date>();
	   LinkedList<Circle> circlelist = new LinkedList<Circle>();
	   LinkedList<Square> squarelist = new LinkedList<Square>();
	   LinkedList<Rectangle> rectanglelist = new LinkedList<Rectangle>();	
	   LinkedList<Shape> shapelist = new LinkedList<Shape>();
	   Ticket t1 = new Ticket("CLX5543H");
	   Ticket t2 = new Ticket("AQI6657B");
	   Date d1 = new Date("26-January-2025");
	   Date d2 = new Date("15-August-2025");
	   
	   circlelist.insert(new Circle(23.7));
	   squarelist.insert(new Square(10));
	   rectanglelist.insert(new Rectangle(10.0,20.0));
	   shapelist.insert(new Shape());
	  
	 
	   drawAll(squarelist);
	   drawAll(circlelist);
	   drawAll(rectanglelist);
	   drawAll(ticketlist);
	   drawAll(datelist);

	   ticketlist.insert(t1); ticketlist.insert(t2);
	   datelist.insert(d1); datelist.insert(d2);
	   

	  
	   printlist(ticketlist);
	   printlist(datelist);

	   
	   
			   
    }
	//LinkedList<Object> l will not work because generics and collections
	// are non covariant i.e. they are invariant Lec-5.3
	public static <T> void printlist(LinkedList<?> l){ //wildcard can be used
		Object o;
		Iterable i = l.get_iterator();
		while(i.has_next()){
			o = i.get_next();
		    ((Printable)o).getValue();
	    } 
	}
	public static void drawAll(LinkedList<? extends Shape> l){
		Object o;
		Iterable i = l.get_iterator();
		while(i.has_next()){
			o = i.get_next();
			((Shape)o).draw();
	}
	
}

	










}
