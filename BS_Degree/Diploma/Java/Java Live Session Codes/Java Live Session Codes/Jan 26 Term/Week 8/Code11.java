
//we will learn anonymous classes and then move to lambdas(anonymous methods)

// What is functional programming?

/* 
 *One issue with anonymous classes is that if the implementation of your anonymous 
 class is very simple, such as an interface that contains only one method, then the 
 syntax of anonymous classes may seem unwieldy and unclear. In these cases, you're 
 usually trying to pass functionality as an argument to another method, such as what
  action should be taken when someone clicks a button. Lambda expressions enable you to 
  do this, to treat functionality as method argument, or code as data..
  Source: Oracle java docs
*/

interface Measureable<T>{
    int measure(T o1,T o2);
    //boolean isObservable(T o1);
    //void boostLow(T o1);
}
class SoundWave{
    public double frequency; //For ease of access in this example we
    public int amplitude;    // defined both these members public, otherwise always declare members as private
    SoundWave(double frequency,int amplitude){
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

}
/*
class Sonometer implements Measureable<SoundWave>{
    
    public int measure(SoundWave obj1,SoundWave obj2){
       
        if(obj1.amplitude > obj2.amplitude)
            return 1;
        else if(obj2.amplitude > obj1.amplitude)
            return -1;
        else return 0;
    }
    public boolean isObservable(SoundWave o){
        if (o.frequency>=20.0 && o.frequency<=20000.0) return true;
        else return false;
    }
    public void boostLow(SoundWave o){
        if(o.frequency < 150)
            o.amplitude *= 1.5; 
    }
}
*/
public class Code11 {
     public static void lowEnhancer(SoundWave s1, SoundWave s2,Measureable<SoundWave> o){
            if(o.measure(s1, s2)==1 && s2.frequency < s1.frequency){
                    s2.amplitude *= 2;
            }
        }
  
    public static void main(String[] args) {
        //Sonometer s = new Sonometer(); 
        SoundWave w1 = new SoundWave(8500.0, 6);
        SoundWave w2 = new SoundWave(200.0, 3);

        //inline defn of class
        lowEnhancer(w1, w2,(obj1,obj2)->{
       
                if(obj1.amplitude > obj2.amplitude)
                    return -1;
                else if(obj2.amplitude > obj1.amplitude)
                    return 1;
                else return 0;
            }
           
        );
        System.out.println(w2.amplitude);
        
        
        
    }
}




