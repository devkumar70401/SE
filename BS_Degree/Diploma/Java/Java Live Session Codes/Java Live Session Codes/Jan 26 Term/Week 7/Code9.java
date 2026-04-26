package java4;
// Assertions
// 1. Assertion checks are turned on only during development and testing.
// 2. you would not use assertions for signaling recoverable conditions to
//    another part of the program or for communicating problems to the program user.
//    Assertions should only be used to locate internal program errors during testing
// 3. Assertions are a tactical tool for testing and debugging. 
//    In contrast, logging is a strategic tool for the entire lifecycle of a program.
//    ...Reference: CORE JAVA Fundamentals by Horstmann, Prentice Hall Publications


public class Code9 {
    public static void main(String[] args) {
        java5.Fibonacci f = new java5.Fibonacci();
        int i = 8;
        System.out.println("\nSum of first "+i+" fibonacci numbers = "+f.fibSum(i));
    }
}
