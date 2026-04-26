package javaintro;
class Language{
    public static void fun(){
        System.out.println("parent");
    }
    public void fun2(){
        System.out.println("parent fun 2");
    }
}
class Java extends Language{
    public static void fun(){ 
        System.out.println("child");
    }
    
    public void fun3(){
        System.out.println("child fun 3");
    }
}
//Method hiding
public class Code2 {
    public static void main(String[] args) {
        Language[] arr = new Java[2]; //change java to language later
        arr[0] = new Language(); //why not shown in CT?
        arr[1] = new Java();
        arr[0].fun();
        arr[0].fun2();
        arr[1].fun();
        arr[1].fun2();//make arr ref type java, what changes here?

        Language obj4 = new Java();
        //obj4.fun();
    }
}
