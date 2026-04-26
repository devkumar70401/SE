import java.io.*;
import java.util.Scanner;

class FileEx1 {
    public static void main(String[] args) {
        try {
            var fin = new FileInputStream("data.txt");
            var scin = new Scanner(fin);
            //var scin = new Scanner(new FileInputStream("data.txt"));
            while (scin.hasNext() == true) {
                String line = scin.next();
                System.out.println(line);
            }
            scin.close();
        } catch (IOException e) {
        }
    }
}