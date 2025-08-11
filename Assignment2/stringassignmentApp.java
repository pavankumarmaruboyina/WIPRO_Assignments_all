package Stringoperations;
import java.util.Scanner;
public class stringassignmentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        stringutility util = new stringutility();
	        String str;

	        System.out.print("Enter a string: ");
	        str = sc.nextLine();

	        int choice;
	        char continueMenu;

	        do {
	            System.out.println("\n********* MENU *********");
	            System.out.println("1. Count Vowels");
	            System.out.println("2. Count Consonants");
	            System.out.println("3. Check Palindrome");
	            System.out.println("4. Reverse String");
	            System.out.println("5. Convert to Uppercase");
	            System.out.println("6. Convert to Lowercase");
	            System.out.println("7. Replace Word");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume leftover newline

	            switch (choice) {
	                case 1:
	                    System.out.println("Vowels: " + util.countVowels(str));
	                    break;
	                case 2:
	                    System.out.println("Consonants: " + util.countConsonants(str));
	                    break;
	                case 3:
	                    if (util.isPalindrome(str))
	                        System.out.println("The string is a Palindrome.");
	                    else
	                        System.out.println("The string is NOT a Palindrome.");
	                    break;
	                case 4:
	                    System.out.println("Reversed String: " + util.reverseString(str));
	                    break;
	                case 5:
	                    System.out.println("Uppercase: " + util.toUpperCase(str));
	                    break;
	                case 6:
	                    System.out.println("Lowercase: " + util.toLowerCase(str));
	                    break;
	                case 7:
	                    System.out.print("Enter the word to replace: ");
	                    String oldWord = sc.nextLine();
	                    System.out.print("Enter the new word: ");
	                    String newWord = sc.nextLine();
	                    str = util.replaceWord(str, oldWord, newWord);
	                    System.out.println("Updated String: " + str);
	                    break;
	                case 8:
	                    System.out.println("Exiting the program. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }

	            System.out.print("Back to Menu? (Y/N): ");
	            continueMenu = sc.next().charAt(0);
	            sc.nextLine(); // consume leftover newline

	        } while (continueMenu == 'Y' || continueMenu == 'y');

	        System.out.println("Program terminated.");
	        sc.close();

	}

}
