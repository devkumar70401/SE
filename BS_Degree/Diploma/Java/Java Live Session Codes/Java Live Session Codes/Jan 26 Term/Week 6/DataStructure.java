

import java.util.*;
import java.util.LinkedList;

public class DataStructure {
    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>();
        //In slides the example is shown using Collection reference
         
        //but in this case we will not be able to use 
        //methods declared and defined only in LinkedList class 
        for(int i=1;i<=10;i++){
            alist.add(fib(i));
        }
        System.out.println("Array List");
        for(int i=0;i<alist.size();i++)
            System.out.print(alist.get(i)+", ");// 20 ms (2*10)---arraylist
            //2*(1+2+3+4+......+9)= 90 ms    --linkedlist    
        

        List<Integer> llist = new LinkedList<>();
        for(int i=11;i<=20;i++){
            llist.add(fib(i));
        }
        System.out.println("\nLinked List");
        //change every even element to 0
        for(Integer x : llist){
            System.out.print(x+" ,");
            if(x%2==0) {
                int temp = llist.indexOf(x);
                llist.set(temp, 0);
            }
        }
        System.out.println();
        
        //remove every alternate element with 0 as value
        // boolean flag = false; 
      /*   for(Integer x : llist){
            if(x==0) {
                if(flag){
                    int index = llist.indexOf(x);
                    llist.remove(index);
                }
                flag = !flag;
            }
        }*/
        
        
        System.out.println("Modified linked list: ");
        for(Integer x : llist){
            System.out.print(x+" ,");
        }
        
        // We saw the problem of ConcurrentModificationException
        // so we use iterator whenever we want to modify the Collection
        // while iterating simultaneously
        ListIterator<Integer> itr = llist.listIterator();
        boolean flag2 = false;
        while(itr.hasNext()){
            int val = itr.next();
            if(val==0){
                if(flag2){
                    itr.remove();
                }
                flag2 = !flag2;
            }
        }
        System.out.println("\nModified linked list with iterator: ");
        for(Integer x : llist){
            System.out.print(x+" ,");
        }

        System.out.println("\n============================================");
        ArrayList<Fighter> fighters = new ArrayList();
        fighters.add(new Fighter("Jon", 28));
        fighters.add(new Fighter("Khabib", 29));
        fighters.add(new Fighter("Daniel", 22));
        fighters.add(new Fighter("Demetrious", 27));
        System.out.println(fighters);
        
        Collections.sort(fighters);
        System.out.println(fighters);
        
    }
    public static Integer fib(int n){
        if(n==1 || n==2)    return n-1;
        else{
            return fib(n-1)+fib(n-2);
        }
    }
}
class Fighter implements Comparable<Fighter>{
    String name;
    int wins;

    public Fighter(String name,int wins) {
        this.name = name;
        this.wins = wins;
    }
    public int compareTo(Fighter obj){
        return obj.wins-this.wins;
    }
    public String toString(){
        return "\nname: "+name + " , wins: "+wins;
    }
} 
//we will revisit collections and discuss about thread safety and synchronized
// collections like vectors as in contrast to arraylists
//Also we will learn about Comparator uses once we cover
//Lambdas and functional programming

/* Geek Peek: Algorithm Appetizer
 * We used a recursive implementation of Fibonacci series. 
 * Wanna check out about a recursive function which grows faster than any
 * exponential function? : ACKERMANN Function 
 * Questions you need to ask : 
 * What are total recursive functions?
 * What are primitive recursive function?
 * Can I implement a total recursive functive, iteratively using only for(1 to n) loops?
 * 
 */