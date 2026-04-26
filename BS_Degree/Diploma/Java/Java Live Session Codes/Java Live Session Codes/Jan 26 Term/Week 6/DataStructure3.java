
import java.util.*;

class Person{

    String name;
    //String profession;

    Person(String n){
        name=n;
    }
    public String toString(){
        return "\n"+name;
    }

     
    public int hashCode() {
        
        return this.name.hashCode(); 
        
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person o = (Person) obj;
        if(this.name == o.name)
            return true;
        else
            return false;
    }
     
    
}

public class DataStructure3 {
    public static void main(String args[]){
        HashMap<String,List<String>> map = new HashMap();
        map.put("Physicists",Arrays.asList(
            "Ashok Sen","SN Bose","RFeynman","P.Higgs"));
        map.put("Actors",Arrays.asList(
            "DiCaprio","AlPacino","MerylS","RobertDowneyJr","Tom Hanks"));
        map.put("Novelists",Arrays.asList(
            "Shakespeare","Dickens","Dostoevsky","Tolstoy","Tom Hanks"));

        System.out.println(map.get("Actors"));
        System.out.println((map.get("Novelists").getFirst()));

        System.out.println(map.getOrDefault("Physicists", Arrays.asList(   
                         "MarieCurie","CVRaman")));
        System.out.println(map.getOrDefault("Footballer", Arrays.asList(   
                         "No Footballer")));
        
        Set<Person> characters = new HashSet<>();
        for(Map.Entry<String,List<String>> s:map.entrySet()){
            characters.add(new Person(s.getValue().getLast()));
        }
        System.out.println("characters:\n"+characters);

        System.out.println(map);
        Map<String,List<String>> map2 = new TreeMap(map);
        System.out.println("map2:\n"+map2);
        map.remove("Actors");
        System.out.println(map);
    
    
    }
}
