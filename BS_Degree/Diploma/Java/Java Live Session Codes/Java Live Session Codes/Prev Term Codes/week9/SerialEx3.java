import java.io.*;

class Student implements Serializable {
    private String name;
    private transient double gpa;
    private transient double fees;

    public Student(String name, double gpa, double fees) {
        this.name = name;
        this.gpa = gpa;
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + ", fees=" + fees + "}";
    }

    // Custom serialization method
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // Add tags for transient fields
        out.writeUTF("GPA");
        out.writeDouble(gpa);

        out.writeUTF("FEES");
        out.writeDouble(fees);
    }

    // Custom deserialization method (no switch)
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        // Deserialization without switch
        for (int i = 0; i < 2; i++) { // 2 transient fields
            String tag = in.readUTF();

            // Check tags and assign values
            if (tag.equals("GPA")) {
                gpa = in.readDouble();
            } else if (tag.equals("FEES")) {
                fees = in.readDouble();
            } else {
                throw new IOException("Unknown tag: " + tag);
            }
        }
    }
}

public class SerialEx3 {
    public static void main(String[] args) {
        String filePath = "StudentTags.txt";

        // Serialization
        Student student = new Student("Alice", 3.9, 15000.75);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(student);
            System.out.println("Student object serialized: " + student);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialized Student object: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
