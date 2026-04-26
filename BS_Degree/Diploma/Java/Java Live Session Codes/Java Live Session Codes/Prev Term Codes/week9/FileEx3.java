import java.io.*;
import java.util.Scanner;

class FileEx3 {
    public static void main(String[] args) {
        // copy infile.txt ->outfile.txt
        try {
            var in = new Scanner(new FileInputStream("infile.txt"));
            var out = new PrintWriter(new FileOutputStream("outfile.txt",true));

            while (in.hasNext()) {
                String line = in.nextLine();
                out.println(line);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("input file not found");
        }
    }
}