package com.madhu.bank;

import java.util.Scanner;
/*
 * Simple banking application with basic operations like
 * checking balance, deposit and withdraw
 */
public class Bank {
	//adding an initial bance of 1000.00
	private static double balance = 1000.00;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to MD Bank\n");
		boolean exit = false;
		while (!exit) {
			int option = printoptionsGetinput(scanner);
			
			switch (option) {
			case 1:
				checkBalance();
				break;
			case 2:
				deposit(scanner);
				break;

			case 3:
				withdraw(scanner);
				break;
			case 4:
				System.out.println("Thank you for visiting our MD bank");
				exit = true;
				default:
					System.out.println("Sorry wrong option, please try again..");
			}

		}
	}

	private static int printoptionsGetinput(Scanner scanner) {
		System.out.println("1.Check balance\n" + "2.Deposit\n" + "3.Withdraw\n" + "4.Exit");
		System.out.println("Enter your option:");
		int option = scanner.nextInt();
		System.out.println();
		return option;
	}

	private static void withdraw(Scanner scanner) {
		checkBalance();
		System.out.println("Enter the withdraw amount");
		double withdrawAmount = scanner.nextDouble();
		if (withdrawAmount <= balance) {
			balance -= withdrawAmount;
			checkBalance();
			
		} else

			System.out.println("You can't with draw more than " + balance);
	}

	private static void deposit(Scanner scanner) {
		checkBalance();
		System.out.println("Enter the deposit amount");
		double depositAmount = scanner.nextDouble();
		balance += depositAmount;
		checkBalance();
	}

	private static void checkBalance() {
		System.out.printf("Your current balance is: %.2f" , balance);
		System.out.println();
	}
}
