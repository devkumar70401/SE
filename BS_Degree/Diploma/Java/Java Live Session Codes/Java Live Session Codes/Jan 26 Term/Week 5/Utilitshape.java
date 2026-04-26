import java.lang.reflect.*;
import java.util.Random;

public class Utilitshape {
    private static Shape s;

    public static void main(String[] args) throws Exception {
        int choice = new Random().nextInt(30);
        if(choice % 2 == 0) 
            s = new Circle(10.0);
        else if(choice % 2 !=0 && choice % 5 == 0)
            s = new Square(5.0);
        else
            s = new Rectangle(12.0,6.0);

        System.out.println(s.getClass());
        Object[] a = {};
        Class c = s.getClass();
        Field[] fields = c.getFields();
        Method[] methods = c.getMethods();
        methods[0].invoke(s,a);
        
    }
}
class Shape{
    public void draw(){
        System.out.println("draw a SHAPE");
    }
}
class Circle extends Shape{
    double radius;
    Circle(double r){
        radius = r;
    }
    public void draw(){
        double area = 3.14*radius*radius; 
        System.out.println("Circle of area "+area);
    }
}

class Square extends Shape{
    double side;
    Square(double s){
        side = s;
    }
    public void draw(){
        double area = side*side; 
        System.out.println("Square of area "+area);
    }
}

class Rectangle extends Shape{
    double length;
    double width;
    Rectangle(double l,double w){
        length = l; width = w;
    }
    public void draw(){
        double area = length*width; 
        System.out.println("Rectanle of area "+area);
    }
}