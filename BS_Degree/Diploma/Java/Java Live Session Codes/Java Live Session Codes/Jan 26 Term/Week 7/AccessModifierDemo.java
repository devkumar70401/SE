package java5;
// NOTE:
//1:make a code8 class in java5 package and see that it's illegal
//2.packages can be accessed either by import or by fully qualified name
//3.Only one public class in a prog is allowed and that must include main method(if main present at all)
//  bcoz .java filename is same name as the public class



public class AccessModifierDemo{   
    void display1(){
        System.out.println("default access : display1 method inside "+this.getClass());
    }
    public void display2(){
        System.out.println("public access: display2 method inside "+this.getClass());
    }
    private void display3(){
        System.out.println("private access: display3 method inside "+this.getClass());
    }
    protected void display4(){
        System.out.println("protected access: display4 method inside "+this.getClass());
    }
}
class AccessModifierSubclass extends AccessModifierDemo{ //subclass in same package
    
    public void fun(){
        display1();
        display2();
        display3();
        display4();
    }
}


class Code8Demo { //unrelated class in same package
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo();
        obj.display1();
        obj.display2();
        obj.display3();
        obj.display4();
        
    }
}

