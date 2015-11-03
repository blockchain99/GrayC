package edu.duke;
import java.util.Scanner;
public class PrimeCheckMain {

	public static void main(String[] args) {
		PrimeCheck pCheck = new PrimeCheck();
		System.out.println("Input number to check pirme : ");
		Scanner inputP = new Scanner(System.in);
		int numP = inputP.nextInt();
		System.out.println(numP + " is prime number ? " +pCheck.isPrime(numP));
	}
}
