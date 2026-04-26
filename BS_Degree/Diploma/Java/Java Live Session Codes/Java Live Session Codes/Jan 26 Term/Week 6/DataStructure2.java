
import java.util.*;
import java.util.LinkedList;



public class DataStructure2 {
     public static Integer fib(int n){
        if(n==1 || n==2)    return n-1;
        else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet();
        Set<Integer> s2 = new HashSet(Arrays.asList(50,51,52,53,54,55));
        for(int i =1;i<=10;i++)
            s1.add(DataStructure2.fib(i));
        System.out.println("s1: "+s1);
 
        s1.add(8);s1.add(13);
        System.out.println("s1 after adding duplicates: "+s1);
        
        for(int i =1;i<10;i++){
            s1.addAll(s2);
        }
        System.out.println("s1 and s2 merged together as s1: "+s1);
        System.out.println(s1.contains(100));
        //Why another ds just for checking if present or not?

        //you may use an iterator to work on sets but the cases where
        //we need to use this ds we mostly check membership

        Set<Integer> ts1 = new TreeSet(s1);
        Set<Integer> ts2 = new TreeSet();
        ts2.add(99);ts2.add(67);ts2.add(99);
        ts2.add(178);ts2.add(12);ts2.add(67);
        System.out.println("ts2: "+ts2);

        ts2.addAll(ts1);
        System.out.println("ts2 and ts1 merged into ts2: "+ ts2);
        System.out.println(ts2.contains(13));


        //LinkedList is an impl,ementation clas of deque
        //which in turn is a sub-interface of Queue interface, so a LinkedList
        //supports methods of both a queue and a stack.
        LinkedList<Integer> l = new LinkedList(
                                      Arrays.asList(78,99,121,12));
        l.addFirst(20);l.addLast(100);l.removeFirst();l.removeLast();
        //Some concrete classes of Queue
        Queue<Integer> q = new LinkedList();//could have also written Deque 
               
        //q.remove();//underflow
        System.out.println("q.poll"+q.poll());
        q.add(80); //exception can be shown on bounded ds like ArrayBlockingQueue
        q.offer(90);
        q.peek();
        System.out.println("before merging:" +q);
        q.addAll(l);
        System.out.println("after merging:" +q);
        q.offer(600);
        q.poll();
        System.out.println("after last poll:"+q);
        q.remove(); //also removes from first pos as expected in queue
        System.out.println("after last remove:"+q);

        //Priority queue
        PriorityQueue<Integer> pri_q1 = new PriorityQueue(l);
        PriorityQueue<Integer> pri_q2 = new PriorityQueue();
        
        System.out.println("pri_q1:" + pri_q1);
        
        pri_q2.add(22);pri_q2.add(-6);pri_q2.add(53);pri_q2.add(8);
        System.out.println("pri_q2:" + pri_q2);
        System.out.println(pri_q2.peek());
        while(!pri_q2.isEmpty()){
            System.out.println(pri_q2.poll());
        }
        //Customizing the elemental comparison is very essential
        //for priority queue uses, we will therefore visit later


    }
}
/*
 * Geek Peek: Trivia Chips
 * Time taken for checking whether an item is present in a data set or not can monstrously
 * vary between the data structures used to represent that data set. 
 * Suppose a data set of integer is 50000000TB in size, such a data set if represented using
 * list and hash set, the search times will be 198 years in case of list, whereas
 * only 200 nanoseconds for a hash table/set.
 * Moral of the story: Learn data structures and algorithms (PDSA) properly
 */