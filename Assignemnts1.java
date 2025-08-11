package Assignments;
import java.util.Scanner;

public class Assignemnts1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char backToMenu;
		
		
		do {
			  System.out.println("1. Print Table of a Number");
	          System.out.println("2. Calculate Factorial");
	          System.out.println("3. Check Prime Number");
	          System.out.println("4. Print Fibonacci Series");
	          System.out.println("5. Exit");
			
	         System.out.println("enter ypur choice");
	         int choice=sc.nextInt();
	         
	         switch(choice) {
	         //Print Table
	         case 1:
	        	 System.out.println("Enter the number");
	        	 int tableNum=sc.nextInt();
	        	 System.out.println("Multiplication Table of "+tableNum+":");
	        	 for(int i=1;i<=10;i++) {
	        		 System.out.println(tableNum+"X"+i+"="+(tableNum*i));
	        		 
	        	 }
	        	 break;
	        	 //Factorial 
	         case 2:
	        	 System.out.println("enter the number");
	        	 int factnum=sc.nextInt();
	        	 long factorial=1;
	        	 for(int i=1;i<=factnum;i++) {
	        		 factorial *=i;
	        	 }
	        	 System.out.println("Factorial of "+factnum+"is"+factorial);
	        	 break;
	        	//Prie check 
	         case 3:
	        	 System.out.println("Enter the number");
	        	 int primenum=sc.nextInt();
	        	 boolean isprime=true;
	        	 int i=2;
	        	 
	        	 if(primenum <=1) {
	        		 isprime=false;
	        		 
	      
	        	 }else {
	        		 while(i <= primenum/2) {
	        			 if(primenum % i ==0) {
	        				 isprime=false;
	        				 break;
	        				 
	        				
	        			 }
	        			 i++;
	        		 }
	        	 }
	        	 if(isprime)
	        		 System.out.println(primenum+"is a prime number");
	        	 else 
	        		 System.out.println(primenum+"is not a prime number");
	        	 break;
	        	 
	         case 4:
	        	 System.out.println("Enter the number of terms:");
	        	 int terms=sc.nextInt();
	        	 int first=0, second=1;
	        	 System.out.println("Fibonacci Series: ");
	        	 
	        	 for(int j=1;j<=terms;j++) {
	        		 System.out.print(first+" ");
	        		 int next=first+second;
	        		 first=second;
	        		 second=next;
	        			 
	        	 }
	        	 System.out.println();
	        	 break;
	        	 
	         case 5://EXIT
	        	 System.out.println("Exit the program");
	        	 sc.close();
	        	 return;
	        	 
	         default:
	        	 System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            
	         }
	         
	         System.out.print("Back to Menu? (Y/N): ");
	            backToMenu = sc.next().charAt(0);
		}while (backToMenu == 'Y' || backToMenu == 'y');
	    System.out.println("Program terminated.");
        sc.close();

	}

}
