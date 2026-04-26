package java3;
//the codes used in slides are mostly about concepts yet not covered in
//the course.The ideas were discussed with real examples which might
//occur while making java applications, but in the code walkthrough
//sessions we will see the exception concepts using basic things which
// are known to us
import java.util.Scanner;

public class Code6 {
    public static void main(String[] args) {
        int[] sides_of_triangle_sq = {1,4,9,16,25,36,49,64,81,100};
        Scanner s = new Scanner(System.in);
        String choice = "n";
        

        do{
            try{    
                    System.out.println("\nEnter the stride length: ");
                    int stride = s.nextInt();s.nextLine();
                    int iterations = (sides_of_triangle_sq.length)/stride;
                    int[] hypotenuse_sq = new int[iterations]; 
                    System.out.println("iterations : "+iterations);
                    int i=0;int k = 0;
                    while(iterations > 0){
                        hypotenuse_sq[k++]=sides_of_triangle_sq[i] + 
                                            sides_of_triangle_sq[i+stride];
                        i= i+stride;
                        iterations--;            
                    }
                    System.out.println("Hypotenuse Squared:");
                    for(int val:hypotenuse_sq){
                        System.out.print(val+", ");
                    }
                    System.out.println("Do you want to continue? Enter Y or N:");
                    choice = s.nextLine();
            }catch(ArithmeticException e){
                    System.out.println(e.getMessage());
                    System.out.println("\nPlease enter NON-ZERO stride\n"
                                    + "Do you want to continue? Enter Y if yes: ");
                    choice = s.nextLine();
                //If choice would have been declared in try block then 
                //we couldnt have accessed it in the catch block.
            }catch(RuntimeException e){
                   if (e instanceof ArrayIndexOutOfBoundsException) {
                        System.out.println("\nArray indexing issue");
                        e.printStackTrace();
                        System.exit(0);
                   }
                   System.out.println("Runtime Exception occurred !!!\n");
                   e.printStackTrace();
                   
            }catch(Exception e){
                    System.out.println("Unknown exception\n");
                    e.printStackTrace();
            }
        }while(choice.equalsIgnoreCase("Y"));
        

    }
}
