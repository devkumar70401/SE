


// define class Marks 
class Marks implements Cloneable{
    private int mathMarks;
    private int scienceMarks;
    private int englishMarks;

    public Marks(int MM, int SM, int EM){
        this.mathMarks = MM;
        this.scienceMarks = SM;
        this.englishMarks = EM;
    }
    public int getMathMarks(){
        return this.mathMarks;
    }
    public int getScienceMarks(){
        return this.scienceMarks;
    }
    public int getEnglishMarks(){
        return this.englishMarks;
    }
    public void setmathMarks(int m){
        this.mathMarks = m;
    }
    public void setscienceMarks(int m){
        this.scienceMarks = m;
    }
    public void setenglishMarks(int m){
        this.englishMarks = m;
    }
    public Marks clone() throws CloneNotSupportedException{
        return (Marks)super.clone();
    }
}

public class StudentRecords implements Cloneable {
    private String name;
    private int rollNumber;
    private Marks marks;

    
    public StudentRecords(String name, int rollNumber, Marks marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    // define the clone method
    public StudentRecords clone() throws CloneNotSupportedException{
        StudentRecords studentClone = (StudentRecords)super.clone();
        studentClone.marks = (Marks)marks.clone();
    }

    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Math Marks: " + marks.getMathMarks());
        System.out.println("Science Marks: " + marks.getScienceMarks());
        System.out.println("English Marks: " + marks.getEnglishMarks());
    }

    
    public static void main(String[] args) {
        
        Marks originalMarks = new Marks(85, 90, 80);
        StudentRecords originalStudent = new StudentRecords("Alice", 101, originalMarks);

        
        System.out.println("Original Student Details:");
        originalStudent.displayDetails();
        System.out.println();

        // create the clone, change the details and print the original and clone details 
        StudentRecords clonedStudent = originalStudent.clone();
        clonedStudent.marks.setmathMarks(95);
        clonedStudent.marks.setscienceMarks(92);
        clonedStudent.marks.setenglishMarks(88);

        System.out.println("Cloned Student Details:");
        clonedStudent.displayDetails();

        System.out.println("Original Student Details after updation in clone:");
        originalStudent.displayDetails();
    }
}

