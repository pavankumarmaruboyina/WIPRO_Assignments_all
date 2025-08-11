package oopoperations;

public class MathOperations {

	public void printTable(int number) {


		System.out.println("Multiplication table of "+number+"is:");
		for(int i=1;i<=10;i++) {
//			System.out.println("Multiplication table of "+number+"is:");
			System.out.println(number+"X"+i+"="+(number*i));
			
		}
		
		
	}
	
	
	public int calculateFactorial(int number) {
		int fact=1;
		for(int i=1;i<=number;i++) {
			fact*=i;
			
		}
		return fact;
		
	}
	
	
	// Check if a number is prime
    public boolean checkPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
	
//	public void  checkPrime(int number) {
//		boolean isprime=true;
//		int i=2;
//		if(number<=1) {
//			isprime=false;
//			
//		}else {
//			while(i < number/2) {
//				if(number%i==0) {
//					isprime=false;
//					break;
//					
//				}
//				i++;
//				  
//			}
//		}
//		
//	
//	 if(isprime)
//		 System.out.println(number+"is a prime number");
//	 else 
//		 System.out.println(number+"is not a prime number");
////	 break;
//}
	
	
	public void printFibonacci(int terms) {
		int first=0,second=1;
		 System.out.println("Fibonacci Series up to " + terms + " terms:");
		for(int i=0;i<=terms;i++) {
		System.out.print(first+" ");
		int next=first+second;
		first=second;
		second=next;
		
	}
		System.out.println();
		
		
	}
}
