import java.io.*;

class Employee1 implements Serializable {
    private String name;
    private transient double salary; 
    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Custom serialization method
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Write default serialized fields
        out.writeDouble(salary); // Write salary manually
    }

    // Custom deserialization method
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Read default serialized fields
        salary = in.readDouble(); // Read salary manually
    }

    @Override
    public String toString() {
        return "name: " + name + ", salary: " + salary;
    }
}

public class SerialEx2 {
    public static void main(String[] args) {
        String filePath = "Employeetransient.txt";

        // Serialization
        Employee1 emp = new Employee1("Arun", 50000.0);

        try  {
        	FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            System.out.println("Employee object serialized and saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialization
        try  {
        	FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee1 deserializedEmp = (Employee1) ois.readObject();
            System.out.println("Employee object deserialized:\n" + deserializedEmp);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
