public class NumbersPrintln
{
   public static void main(String[] args)
   {
      int billingDate = 10;      
      String month = "December ";
      String month1 = "Bills are sent on day ";
      String month2 = " of the month";
      String month3 = "Next bill:";
      
      System.out.print(month1);
      System.out.print(billingDate);
      System.out.println(month2);
      System.out.println(month3 + month + billingDate);
   }
}