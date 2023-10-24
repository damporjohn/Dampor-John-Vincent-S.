import java.util.Scanner;

public class Person {
   private String fName;
   private String mName;
   private String lName;
   private int age;
   private String bday;
   private String add;

   public Person(String fName, String mName, String lName, int age, String bday, String add) {
      this.fName = fName;
      this.mName = mName;
      this.lName = lName;
      this.age = age;
      this.bday = bday;
      this.add = add;
   }

   public String getFirstName() {
      return fName;
   }

   public void setFirstName(String firstName) {
      this.fName = fName;
   }

   public String getMiddleName() {
      return mName;
   }

   public void setMiddleName(String middleName) {
      this.mName = mName;
   }

   public String getLastName() {
      return lName;
   }

   public void setLastName(String lastName) {
      this.lName = lName;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getBirthday() {
      return bday;
   }

   public void setBirthday(String birthday) {
      this.bday = bday;
   }

   public String getAddress() {
      return add;
   }

   public void setAddress(String address) {
      this.add = add;
   }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name:");
        String fName = scanner.nextLine();

        System.out.println("Enter the middle name:");
        String mName = scanner.nextLine();

        System.out.println("Enter the last name:");
        String lName = scanner.nextLine();

        System.out.println("Enter the age:");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter the birthday (YYYY-MM-DD):");
        String bday = scanner.nextLine();

        System.out.println("Enter the address:");
        String add = scanner.nextLine();
      Person person = new Person(fName, mName, lName, age, bday, add);
   
      System.out.println("\nPerson Information:\n");
      System.out.println("First Name: " + person.getFirstName());
      System.out.println("Middle Name: " + person.getMiddleName());
      System.out.println("Last Name: " + person.getLastName());
      System.out.println("Age: " + person.getAge());
      System.out.println("Birthday: " + person.getBirthday());
      System.out.println("Address: " + person.getAddress());
   
      scanner.close();
   }
}