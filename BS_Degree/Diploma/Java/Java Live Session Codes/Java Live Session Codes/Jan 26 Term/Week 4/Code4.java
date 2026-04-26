package week4alter;

class A{
	public static void  display() {
		System.out.println("A");
	}
}
class B extends A{
	public static void  display() {
		System.out.println("B");
	}
}

public class Code4 {

	public static void main(String[] args) {
		A obj = new B();
		obj.display();

	}

}
