package javaintro;

class A{
    public void fun1(){
        System.out.println("A");
    }
   
}
class B extends A{
    public void fun2(){
        System.out.println("B");
    }
}
class C extends A{
    public void fun3(){
        System.out.println("C");
    }
}
class D extends A{
    public void fun4(){
        System.out.println("D");
    }
}

public class Code7 {
    public static void main(String[] args) {
        A[] arr = {new B(),new C(),new D()};
       // (arr[0]).fun2(); //why is this error?
        ((B)(arr[0])).fun2();
    }
}
//if you try to call a non overridden method of a object but multiple
//  subtypes are stored inside refrence supertype array
//in such a situation programmer has to do explicit type casting,
//  in order to let the compiler know that
//this particular reference stores the corresponding object