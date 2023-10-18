import java.util.Scanner;

class AnimalsAndSound {
   public static void main(String[] args) {
      Animal animal = new Animal();
      int num;
      char ans;
      Scanner scanner = new Scanner(System.in);

      do {
         System.out.println("This program will tell the sound of an Animal.");
      do {
         System.out.println("Enter a number between 1-4");
         System.out.println(" 1 = frog \n 2 = sheep \n 3 = goat \n 4 = monkey ");
               System.out.print("Enter a number:");
      num = scanner.nextInt();

      if (num > 4 || num < 1) {
         System.out.println("   !!!invalid entry!!! \nPlease enter a number from 1-4 ");
      
      } 
      } while (num > 4 || num < 1);

      switch (num) {
         case 1:
            animal.frog();
      break;
         case 2:
            animal.sheep();
      break;
         case 3:
            animal.goat();
      break;
         case 4:
            animal.monkey();
      break;
      }

      System.out.println("\nDo you wish to try again? [Y/N]");
      ans = scanner.next().charAt(0);
      } while (ans == 'Y' || ans == 'y');

      System.out.println("Thanks! Have a great day!!");
      scanner.close();
      }
      }

      class Animal {
      public void frog() {
         System.out.println("Monkey = Kokak! Kokak! Kokak!");
      }

      public void sheep() {
         System.out.println("Sheep = Baa! Baa! Baa!");
      }

      public void goat() {
         System.out.println("Goat = Meh! Meh! Meh! ");
      }

      public void monkey() {
         System.out.println("Monkey = Ooh! Ooh! Aah! Aah!");
   }
}