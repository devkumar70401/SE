package java5;
import java.util.logging.*;

public class Fibonacci{

    private final static Logger l1 = Logger.getGlobal();
    private final static Logger l2 = Logger.getLogger("mylogger");

    static{
        l1.setLevel(Level.FINEST);
        l2.setLevel(Level.FINE);
    }

    public int fibN(int n){
        if(n==1 || n==2)    return n-1;
        else{
            return fibN(n-1)+fibN(n-2);
        }
    }
    public long fibSum(int i){
        l1.info("fibSum is used: l1");
        l2.info("fibSum is used: l2");
        assert i >= 1:"Argument given to this method, must be greater than 1 !!!\n"+
                        "Entered value: "+i;
        
        long sum = 0;
        for(int j = i; j>=1 ; j--){
            sum += fibN(j);
        }
        return sum;
        
        
    }
}
