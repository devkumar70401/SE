package javaintro;

class MartialArts{
    String origin_country;
    MartialArts(String origin_country){
        this.origin_country = origin_country;
    }

    public boolean equals(Object o){
       //you may also check using instanceof as shown in lectures
        if(o==this) 
            return true;
        else if(((MartialArts)o).origin_country == this.origin_country) 
            return true;   
        else 
            return false;
    }
}
//Point to Ponder: when should we have equals overidden in subclasses 
//in a similar kind of inheritance structure? how will we call the
//corresponding equals version?
class KravMaga extends MartialArts{
    KravMaga(String c){
        super(c);
    }

    public String toString(){
        return "This is a Krav-Maga object";
    }
}
class Taekwondo extends MartialArts{
    Taekwondo(String c){
        super(c);
    }
}
class Hapkido extends MartialArts{
    Hapkido(String c){
        super(c);
    }
} 

public class Code4 {
    public static void main(String args[]){
        KravMaga o1 = new KravMaga("Israel");
        Taekwondo o2 = new Taekwondo("Korea");
        Hapkido o3 = new Hapkido("Korea");
        
        //without toString override
            System.out.println(o2);
            System.out.println(o3);
        //with toString override
            System.out.println(o1);
        
        System.out.println(o2.equals(o3));
        System.out.println(o1.equals(o2));
        


    }
}
