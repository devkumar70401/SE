package week4;

/* Explanation of why we need interface and how interface provides
 * polymorphism along with customizable utility :  Lecture 2 Week 4
 */

interface Comparable{
    public abstract int cmp(Comparable s);
}
class Students implements Comparable{
    String s_name;
    int marks;
    Students(String n, int m){
        s_name = n;
        marks = m;
    }
    
    public int cmp(Comparable s){
        Students stu = (Students)s;
        if(this.marks > stu.marks) return 1;
        else if (this.marks < stu.marks) return -1;
        else return 0;
    }
    public void getDetails(){
        System.out.print("Student name: "+ s_name);
        System.out.println(",  Student marks: "+ marks);
        System.out.println("--------------------------");
    }
}
class Employees implements Comparable{
    String e_name;
    int years;
    long salary;
    Employees(String n,int y,long sal){
        e_name = n;
        years = y;
        salary = sal;
    }
    public int cmp(Comparable s){
        Employees emp = (Employees)s;
        if((this.years > emp.years) && (this.salary > 700000) ) return 1;
        else if ((this.years < emp.years)&&(emp.salary < 700000)) return -1;
        else return 0;
    }
    public void getDetails(){
        System.out.print("Employee name: "+ e_name);
        System.out.print(",  Employee years: "+ years);
        System.out.println(",  Employee salary: "+ salary);
        System.out.println("--------------------------");
    }
}
class SortFunctions{
    
    public static int partition(Comparable arr[],int first,int last){
        Comparable pivot = arr[last];
        int i = first - 1;
        for(int j = first;j<last;j++){
            if(arr[j].cmp(pivot) == 1){
                i++;
                Comparable temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        Comparable temp  = arr[i+1];
        arr[i+1] = arr[last];
        arr[last] = temp;
        return i+1;
    }
    
    public static void quicksort(Comparable[] arr, int start,int end){
        if(start < end){
            int pivot = partition(arr,start,end);
            quicksort(arr, start, pivot-1);
            quicksort(arr,pivot+1,end);
        }
    }
}

public class Code1 {
    public static void main(String args[]){
        Students s_arr[] = {
            new Students("R.Feynman",89),
            new Students("P.Higgs",65),
            new Students("CN.Rao",77),
            new Students("A.Sen",92),
            new Students("S.Raychaudhary",74)};
        Employees e_arr[] = {
            new Employees("Musk",6,950000),
            new Employees("Pichai",10,800000),
            new Employees("Krishnan",12,550000),
            new Employees("Gopinathan",18,850000),
            new Employees("Nadella",5,650000),
            new Employees("Gates",20,1200000)};

        
        SortFunctions.quicksort(s_arr, 0, 4);
        SortFunctions.quicksort(e_arr, 0, 5);

        System.out.println("\n\n"); 

        for(Comparable item : s_arr){
            ((Students)item).getDetails();
        }
        System.out.println("\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n");
        for(Comparable item : e_arr){
            ((Employees)item).getDetails();
        }
            
    }
}
