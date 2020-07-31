package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = scanner.nextInt();
		System.out.print("Holder: ");
		scanner.nextLine();
		String holder = scanner.nextLine();
		System.out.print("Initial balance: ");
		Double balance = scanner.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = scanner.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		
		try {
			System.out.print("Enter amount for withdraw: ");
			Double amount = scanner.nextDouble();
			account.withDraw(amount);
			System.out.println(account);
		}
		catch (DomainExceptions e) {
			System.out.print("Withdraw error: " + e.getMessage());
		}
		
		scanner.close();
	}

}
