package java4;
//use of import and package statemenats
import java5.*;

class AnotherSubclass extends AccessModifierDemo{
    public void fun(){
        this.display1();
        this.display2();
        display3();
        this.display4();
    }
    public AccessModifierDemo o = new AccessModifierDemo();
    AnotherSubclass obj2 = new AnotherSubclass();
    public void fun2(){
        o.display1();
        o.display2();
        o.display3();
        o.display4();// LINE 1
        obj2.display4();// LINE 2

    }
    
} 


public class Code8 {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo();
        AnotherSubclass obj2 = new AnotherSubclass();
        
        obj.display1();
        obj.display2();
        obj.display3();
        obj.display4();

        obj2.display4();
    }
}
