package Stringoperations;

public class stringutility {

	 public int countVowels(String str) {
	        int count = 0;
	        str = str.toLowerCase();
	        for (char ch : str.toCharArray()) {
	            if ("aeiou".indexOf(ch) != -1) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public int countConsonants(String str) {
	        int count = 0;
	        str = str.toLowerCase();
	        for (char ch : str.toCharArray()) {
	            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public boolean isPalindrome(String str) {
	        String reversed = new StringBuilder(str).reverse().toString();
	        return str.equalsIgnoreCase(reversed);
	    }

	    public String reverseString(String str) {
	        return new StringBuilder(str).reverse().toString();
	    }

	    public String toUpperCase(String str) {
	        return str.toUpperCase();
	    }

	    public String toLowerCase(String str) {
	        return str.toLowerCase();
	    }

	    public String replaceWord(String str, String oldWord, String newWord) {
	        return str.replace(oldWord, newWord);
	    }
	}

