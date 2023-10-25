import java.util.Scanner;

public class Student {
    private String first_name = "";
    private String middle_name = "";
    private String last_name = "";
    private String Suffix = "";

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setMiddleName(String middleName) {
        this.middle_name = middleName;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setSuffix(String suffix) {
        this.Suffix = suffix;
    }

    public String getSuffix() {
        return Suffix;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        System.out.print("Enter your first name: ");
        student.setFirstName(scanner.nextLine());

        System.out.print("Enter your middle name: ");
        student.setMiddleName(scanner.nextLine());

        System.out.print("Enter your last name: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Enter your suffix: ");
        student.setSuffix(scanner.nextLine());

        System.out.println("\nStudent Information:");
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Middle Name: " + student.getMiddleName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Suffix: " + student.getSuffix());
        System.out.println("Fullname: "+ student.getFirstName() + " " + student.getMiddleName()+ " " + student.getLastName()+ " " + student.getSuffix());


        scanner.close();
    }
}
