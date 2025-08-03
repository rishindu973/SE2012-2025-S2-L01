improt java.util.Scanner;


public class Welcome{
    public static void main(String args[]){
       String FirstName,LastName;
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter your First Name: ");
       FirstName = sc.nextLine();
       System.out.print("Enter your Last Name: ");
       LastName = sc.nextLine();
       System.out.printf("Welcome to the Second Year %s %s",FirstName,LastName);
          
       sc.close();
  }
}