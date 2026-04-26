
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * one big advantage of using streams is parallel computation on data stored
 * in collections. normally if we try to do so, we will have errors
 * at runtime, we cannot modify the collection data parallely 
 * without duplicating the collection into another temporary collection
 * and running two separate threads on them. But with streams no need
 * for a separate collection as multiple streams can be created from
 * same collection data and can be operated upon simultaneously on
 * two threads
 * second advantage is lazy evaluation  
 */
class DemoUtility{
    public static Double getDouble(){
        Random s = new Random();
        return Math.sqrt(s.nextDouble());
    }
}

public class Code12 {
    public static void main(String[] args) {
        List<String> wordlist = new LinkedList(
            Arrays.asList("Moriarty","Lex Luthor","Dr. Octopus"));
        Stream<String> wordstream1 = wordlist.stream();
        
        String[] wordarr = {"Price","Woods","Ghost","McTavish"};
        Stream<String> wordstream2 = Stream.of(wordarr);

        Stream<String> echos = Stream.generate(()->"Echo");
        Stream<String> echos2 = Stream.generate(()->{
                Random r = new Random();
                String rstring="";
                int length = r.nextInt(14)+1;
                for(int i=1;i<=length;i++)
                    rstring = rstring + (char)(r.nextInt(26)+65);
                return rstring;
            }
        );
        
        Stream<Double> randomds = Stream.generate(Math::random);
        Stream<Double> randomds2 = Stream.generate(DemoUtility::getDouble);
        //randomds2.forEach(i -> System.out.print(i));
        Stream<Character> alphas = Stream.iterate('A',n->n<=90,n->(char)(n+1));
        //alphas.forEach(i -> System.out.print(i+" : "));
        //alphas.forEach(i -> System.out.print(i+" : "));
        //What is this exception?
        
       /* Stream<List<String>> startlongwords = wordstream1                       //show using echos2 also in place of wordstream1
                                    .filter(w -> w.length()>5)
                                    .map(s -> explode(s));
                                    
        startlongwords.forEach(l -> System.out.println(l));                                
        */
         Stream<String> startlongwords = wordstream1                       
                                    .filter(w -> w.length()>5)
                                    .map(s -> explode(s))
                                    .flatMap(list -> list.stream());
           startlongwords.forEach(element -> System.out.println(element));                                
        

        Stream<List<String>> startlongwords2 = echos2
                                    .limit(10)                        
                                    .filter(w -> w.length()>8)
                                    .map(s -> explode(s));
                                    //.flatMap(list -> list.stream());
        startlongwords2.forEach(l -> System.out.println(l)); 

        Optional<Double> maxrand = Stream.generate(Math::random)
                                    .limit(10)
                                    .filter(n -> n<0.0001)
                                    .max(Double::compareTo);

        // ============================ Week 9 =============================
        
        Double fixrand = maxrand.orElse(-1.0);
        
        var results = new ArrayList<Double>();
        maxrand.ifPresentOrElse(v -> results.add(v) ,
                             ()->System.out.println("Illegal"));
        
        // from streams back to collections
        Stream<Integer> perfectsq = Stream.iterate(1,i -> i<=625,i -> i*i);
        List<Integer> result = perfectsq.collect(Collectors.toList());                     
        Set<Double> result2 = Stream.generate(Math::random).limit(20)            
                              .collect(Collectors.toSet());
        
        LinkedList<Integer> li = Stream.iterate(1,i->i+1).limit(50)
                                 .collect(Collectors.toCollection(
                                    LinkedList::new));//constructor of Linkedlist 

        Map<Integer,String> lengthmap = Stream.generate(()->{
              Random r = new Random();
                String rstring="";
                int length = r.nextInt(14)+1;
                for(int i=1;i<=length;i++)
                    rstring = rstring + (char)(r.nextInt(26)+65);
                return rstring;
            }).limit(20)
              .collect(Collectors.toMap(
                                     i->i.length(), 
                                     Function.identity() // you can also write i-> i
                                  )
                      );

    }
    
    
    
    
    public static List<String> explode(String s){
        LinkedList<String> l = new LinkedList();
        for(int i=0;i<s.length();i++){
            String str = s.charAt(i)+"";
            l.add(str);
        }
        return l;
    }
}
