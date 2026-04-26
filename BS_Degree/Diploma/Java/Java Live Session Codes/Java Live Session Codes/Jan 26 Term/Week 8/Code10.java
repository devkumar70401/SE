

//functional Interfaces have 1 method declaration
//Remember , I asked you guys to write a simple swap method in
//java1/Code3.java program. Tried that? what happened?

class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date birthday;

    public Employee(String n,double s){
        name = n;
        salary = s;
        birthday = new Date();
    }
    public void setname(String n){
        name = n;
    }
    public void setbday(int dd, int mm, int yy){
        birthday.update(dd, mm, yy);
    }
    public String toString(){
        //return this.name + " : " + this.salary+" : ";
        return this.name + " : " + this.salary+" : "+this.birthday;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public Object clone() throws CloneNotSupportedException{
       Employee temp = (Employee)super.clone();
       temp.birthday = (Date)birthday.clone();
       return temp;
    }
   
}
class Date implements Cloneable{
    private int day;
    private int month;
    private int year;

    public void update(int d,int m,int y){
        day = d; month = m; year = y;
    }
    public String toString(){
        return day+"-"+month+'-'+year;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    //Exception thrown during overriding must be more 
    //specific(subtype of original declaration's throws clause) and
    //access modifier can be loosened while overriding but can't be tightened
}

public class Code10{
    public static void main(String args[])throws Exception{
        Employee e1 = new Employee("Dhruv",21500.0);
        //Shallow copy
        Employee e2 = e1;
       // e2.setname("George");
        //System.out.print(e1+"\n"+e2);

        //Deep copy
        Employee e3 = new Employee(e1.getName(),e1.getSalary());
        e3.setname("Gregori perelman");
        e3.setbday(18, 02, 1985);
        //System.out.println(e1+"\n"+e3);

        //Cloning
        Employee e4 = (Employee)e3.clone();
        e4.setname("Carl Sagan");
        e4.setbday(25, 12, 1999);

        System.out.println(e3+"\n"+e4);
        
        //Deep level cloning
       /* Employee e5 =  new Employee("Gregori",45000);
        e5.setbday(18, 04, 1999);
        Employee e6 = (Employee)e5.clone();
        e6.setname("Galileo");
        e6.setbday(5, 12, 2002);
        System.out.println(e5+"\n"+e6);
        */
    }
}

