package idk;
import java.util.Scanner;

public class class_one {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an option:");
		System.out.println("===============================");
		System.out.println("1. Find the biggest integer.");
		System.out.println("2. Find your marks.");
		System.out.println("3. Find your body mass index.");
		System.out.println("4. Counter of positive numbers.");
		System.out.println("5. Find if a number is an armstrong number.");
		System.out.println("6. Password validator.");
		System.out.println("7. List sum.");
		System.out.println("8. Count the ocurrences in the phrase.");
		System.out.println("9. Get the gcd of 2 numbers.");
		System.out.println("10. Execise.");
		System.out.println("11. Fibonacci.");
		System.out.print("Here: ");
		int numero = scanner.nextInt();
		
		if(numero == 1) {
			int[] int_list = new int[3];
			for(int i=0;i<=2;i++) {
				System.out.print("Enter the " + (i+1) + " number: ");
				int_list[i] = scanner.nextInt();
			}
			int n = getTheBiggest(int_list[0],int_list[1],int_list[2]);
			System.out.println("The biggest number between "+int_list[0]+","+int_list[1]+","+int_list[2]+","+ " is: " + n);
		} else if(numero == 2) {
			System.out.print("Enter your mark: ");
			int mark = scanner.nextInt();
			System.out.println("Your mark obtained is: " + getTheGrade(mark));
		} else if(numero == 3) {
			System.out.print("Enter yout body mass index: ");
			double bmi = scanner.nextDouble();
			System.out.println("Your BMI obtained is: " + bodyMassIndex(bmi));
		} else if(numero == 4) {
			int[] int_list = new int[3];
			for(int i=0;i<=2;i++) {
				System.out.print("Enter the " + (i+1) + " number: ");
				int_list[i] = scanner.nextInt();
			}
			int n = countPositiveNums(int_list[0],int_list[1],int_list[2]);
			System.out.println("Total positive numbers: " + n);
		} else if(numero == 5) {
			System.out.print("Enter the number: ");
			int num = scanner.nextInt();
			if(isArmstrongNumber(num)) {
				System.out.println("The number " + num + " is an armstrong number");
			} else {
				System.out.println("The number " + num + " is not an armstrong number");
			}
		} else if(numero == 6) {
			System.out.print("Enter yout password: ");
			String pass = scanner.next();
			if(checkPassword(pass)) {
				System.out.println("Your password is strong!");
			} else {
				System.out.println("Your password is weak.");
			}
		} else if(numero == 7) {
			System.out.print("Enter the length of the list: ");
			int length = scanner.nextInt();
			int[] nums = new int[length];
			for(int i=0; i<length; i++) {
				System.out.print("Enter the number " + (i+1) + " : ");
				int num = scanner.nextInt();
				nums[i] = num;
			}
			System.out.println("The list summatory is: " + sumPositiveNums(nums));
		} else if(numero == 8) {
			System.out.print("Enter your phrase: ");
		    scanner.nextLine();
		    String phrase = scanner.nextLine();
		    System.out.print("Enter the character: ");
		    String letter = scanner.next();
		    System.out.println("The quantity of the letter '" + letter + "' in the phrase '" + phrase + "' is: " + countOccurrences(phrase, letter));
		} else if(numero == 9) {
			System.out.print("Enter the first number: ");
		    int n1 = scanner.nextInt();
		    System.out.print("Enter the second number: ");
		    int n2 = scanner.nextInt();
		    System.out.println("The GCD of " + n1 + " and " + n2 + " is: " + gcd(n1,n2));
		} else if(numero == 11) {
			System.out.println("Enter the number: ");
			int n1 = scanner.nextInt();
			System.out.println("Fibonacci of " + n1 + " is: " + fibo(n1));		}
		
		scanner.close();
	}
	
	public static int getTheBiggest(int n1, int n2, int n3) {	
		int biggest = n1;
		if(biggest < n2) {
			biggest = n2;
		} else if(biggest < n3) {
			biggest = n3;
		}
		return biggest;
	}
	
	public static char getTheGrade(int mark) {
		if(mark >= 90) {
			return 'A';
		} else if(mark >= 80) {
			return 'B';
		} else if(mark >= 70) {
			return 'C';
		} else if(mark >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}
	
	public static String bodyMassIndex(double bmi) {
		String out = new String();
		if(bmi >= 25) {
			out = "Overweight";
		} else if(bmi < 25 && bmi >= 18.5) {
			out = "Noraml (Healthy Weight)";
		} else if(bmi < 18.5 && bmi >= 16) {
			out = "Underweight";
		} else if(bmi < 16 && bmi >= 15) {
			out = "Severely Underweight";
		} else {
			out = "Very Severely Underweight";
		}
		return out;
	}
	
	public static int countPositiveNums(int n1, int n2, int n3) {
		int count = 0;
		int[] int_list = {n1,n2,n3};
		for(int i=0; i<=2; i++) {
			if(int_list[i] >= 0) {
				count += 1;
			}
		}
		return count;
	}
	
	public static boolean isArmstrongNumber(int num) {
		int hundreds = num/100;
		int tens = (num - hundreds*100)/10;
		int units = (num - hundreds*100 - tens*10);
		double amstrongNumber = Math.pow(hundreds, 3) + Math.pow(tens, 3) + Math.pow(units, 3);
		return amstrongNumber == num;
	}
	
	public static boolean checkPassword(String pass) {
		if(pass.length() < 8) {
			return false;
		} else {
			
			boolean hasUpperCase = false;
			boolean hasLowerCase = false;
			boolean hasDigits = false;
			boolean hasSymbols = false;
			
			for(char c: pass.toCharArray()) {
				if (Character.isUpperCase(c)) {
	                hasUpperCase = true;
	            } else if(Character.isLowerCase(c)) {
	            	hasLowerCase = true;
	            } else if(Character.isDigit(c)) {
	            	hasDigits = true;
	            } else{
	            	hasSymbols = true;
	            }
			}
	        int typesCount = 0;
	        if (hasUpperCase) typesCount++;
	        if (hasLowerCase) typesCount++;
	        if (hasDigits) typesCount++;
	        if (hasSymbols) typesCount++;
	        
	        return typesCount >= 3;
		}
	}
	
	public static int sumPositiveNums(int [] nums) {
		int sum = 0;
		for(int i : nums) {
			if (i >= 0){
				sum += i;
			}
		}
		return sum;
	}
	
	public static int countOccurrences(String phrase, String letter) {
		int quantity = 0;
		String phrase_lower = phrase.toLowerCase();
		String letter_lower = letter.toLowerCase();
	    char targetChar = letter_lower.charAt(0);
		for(char c: phrase_lower.toCharArray()) {
			if(targetChar == c) {
				quantity += 1;
			}
		}
		return quantity;
	}
	
	public static int gcd(int n1, int n2) {
		if(n1 == 0 || n2 == 0) {
			if(n1!=0) {
				return n1;
			} else {
				return n2;
			}
		} else {
			if(n1>n2) {
				return gcd(n1-n2,n2);
			} else {
				return gcd(n2-n1,n1);
			}
		}
	}
	
	public static int fibo(int n1) {
		if(n1 <= 1) {
			return n1;
		} else {
			return fibo(n1-1) + fibo(n1-2);
		}
	}
	
}
