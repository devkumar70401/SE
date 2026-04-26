import java.io.*;
import java.util.*;

class FileEx2 {
    public static void main(String[] args) throws IOException {
        // create file input.txt
        // append mode = false (default) (will overwrite)
        // var fout = new FileOutputStream("c:\\root\\output.txt");
        // append mode = true
        var fout = new FileOutputStream("output.txt");
        var pout = new PrintWriter(fout);
        // pout var = new PrintWriter(new FileOutputStream("output.txt"););
        String msg = "Hello, world";
        pout.println(msg);
        pout.close();
    }
}