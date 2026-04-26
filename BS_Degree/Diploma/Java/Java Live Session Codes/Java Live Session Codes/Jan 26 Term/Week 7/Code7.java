package java3;


import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class NegativeException extends Exception{
    private int error_value;
    NegativeException(String message, int i){
        super(message);
        error_value = i;
    }
    public String toString(){
        return "NegativeException with error value: "+ error_value+"\n";
    }
}

class LinearList extends LinkedList<Integer>{
    public boolean add(int i) throws NegativeException{
        if(i<0){
            throw new NegativeException("Negative value given", i);
        }
        return super.add(i);
    }
}
public class Code7 {
    public static void main(String[] args) {
        LinkedList<Integer> sides_of_triangle_sq = new LinkedList();
        for(int i=1;i<=30;i++){
            sides_of_triangle_sq.add(i*i);
        }
        String choice = "Y";
        Scanner s = new Scanner(System.in);
        int max,min;
        System.out.println("Enter max possible value of stride: ");max = s.nextInt();s.nextLine();
        System.out.println("Enter min possible value of stride: ");min = s.nextInt();s.nextLine();

        do{
            try {
                randomHypotenuseSq(sides_of_triangle_sq,max,min);
                System.out.println("If you want to continue , enter Y");
                choice = s.nextLine();
            }catch(NegativeArraySizeException e){
                System.out.println(e);
                System.out.println("The real cause of NegativeArraySize exception is ==> "+e.getCause());
                min = 1;
            } 
            catch (Exception e) {
                System.out.println("Main method: unknown Exception");
                e.printStackTrace();
            }
        }while(choice.equalsIgnoreCase("Y"));
    }
    public static void randomHypotenuseSq(LinkedList<Integer> sides_of_triangle_sq,int max,int min) throws RuntimeException{
        //We are getting acquainted with the new concepts of Exception and thats why we are using already known
        //exceptions as examples, strictly speaking any RuntimeException/Unchecked Exception neednt and in most cases shouldnt be
        //put under catch block or used with throws keyword  
        LinearList stride = new LinearList();
        

        try{      
                    for(int i = 0;i<10;i++){
                        int val1 = min + new Random().nextInt(max - min + 1);
                        System.out.println("val: "+val1);
                        stride.add(val1);
                        
                        
                    
                        int iterations = (sides_of_triangle_sq.size()-1)/stride.get(i);
                        int[] hypotenuse_sq = new int[iterations]; 
                        
                        int j=0;int k = 0;
                        while(iterations > 0){
                            hypotenuse_sq[k++]=sides_of_triangle_sq.get(j) + 
                                                sides_of_triangle_sq.get(j+stride.get(i));
                            j= j+stride.get(i);
                            iterations--;            
                        }
                        System.out.println("Hypotenuse Squared:");
                        for(int val:hypotenuse_sq){
                            System.out.print(val+", ");
                        }
                        System.out.println("\n\n");
                    }
        }catch(ArithmeticException e){
                    System.err.println(e.getMessage());
                    System.out.println("\nArithmeticException:The last value of stride must have been 0, Please provide\nNon-zero stride");
                    System.out.println(stride);
                    
        }catch(RuntimeException e){
                   if (e instanceof ArrayIndexOutOfBoundsException) {
                        System.out.println("\nArray indexing issue");
                        e.printStackTrace();
                        System.exit(0);
                   }
                   System.out.println("Runtime Exception occurred !!!\n");
                   e.printStackTrace();
                   
        }catch(NegativeException e){
            System.out.println(e.getMessage());
            NegativeArraySizeException new_exception = new NegativeArraySizeException();
            new_exception.initCause(e);
            throw new_exception;
        }catch(Exception e){
            System.out.println("Unkown exception occurred!!!");
            e.printStackTrace();
        }
    }
}

