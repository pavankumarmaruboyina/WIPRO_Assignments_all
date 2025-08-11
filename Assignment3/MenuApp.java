package oopoperations;
import java.util.Scanner;

public class MenuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	MathOperations obj=new MathOperations();
	
//	System.out.println("")
	char backtomenu;
	int choice;
	do {
		 System.out.println("\n********* MENU *********");
		 System.out.println("1. Print Table of a Number");
         System.out.println("2. Calculate Factorial");
         System.out.println("3. Check Prime Number");
         System.out.println("4. Print Fibonacci Series");
         System.out.println("5. Exit");
         
         System.out.println("Enter your choice(1-5)");
         choice=sc.nextInt();
         
         switch(choice) {
         case 1:
        	 System.out.println("enter the number for table");
        	 int tab=sc.nextInt();
        	 obj.printTable(tab);
//        	 System.out.println("table of "+tab+"is"+obj.printTable(tab));
        	 break;
        	 
         case 2:
        	 System.out.println("Enter the number for factorial");
        	 int factnum=sc.nextInt();
        	 int result=obj.calculateFactorial(factnum);
        	 System.out.println("Factorial of"+factnum+"is"+result);
        	 break;
         case 3:
        	 System.out.print("Enter a number to check prime: ");
             int primeNum = sc.nextInt();
             boolean isPrime = obj.checkPrime(primeNum);
             if (isPrime)
                 System.out.println(primeNum + " is a prime number.");
             else
                 System.out.println(primeNum + " is not a prime number.");
             break;
         case 4:
        	  System.out.print("Enter number of terms for Fibonacci: ");
              int terms = sc.nextInt();
              obj.printFibonacci(terms);
              break;
         case 5:
        	 System.out.println("Exiting program. Thank you!");
             break;
             
         default:
        	 System.out.println("Invalid choice. Please enter between 1 and 5.");
        	 
         }
	

	}while(choice !=5);
	sc.close();
}
}
