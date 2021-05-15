package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		MakeChange checkout = new MakeChange();

		checkout.promptCustomer("getItem");
		double itemPrice = scanner.nextDouble();
		checkout.promptCustomer("");
		double tender = scanner.nextDouble();

		checkout.changeReturn(itemPrice, tender);


	}

	private void promptCustomer(String type) {
		if (type.equals("getItem")) {
			System.out.print("Please enter the item price: ");
		} else {
			System.out.print("Please enter tender provided: ");
		}
	}

	private boolean verifyEnoughTender(double itemPrice, double tender) {
		if (tender >= itemPrice) {
			return true;
		}

		System.out.printf("Amount: %.2f, Tendered: %.2f, Result: Error message", itemPrice, tender);

		return false;
	}

	private void changeReturn(double itemPrice, double tender) {
		
		//verify enough tender for purchase//
			
		if (verifyEnoughTender(itemPrice, tender)) {            

			double changeAmount = tender - itemPrice;

			int tenDollar = (int) changeCounter(changeAmount, 10);
			changeAmount %= 10;

			int fiveDollar = (int) changeCounter(changeAmount, 5);
			changeAmount %= 5;

			int oneDollar = (int) changeCounter(changeAmount, 1);
			changeAmount %= 1;

			int quarter = (int) changeCounter(changeAmount, .25);
			changeAmount %= .25;

			int dime = (int) (changeAmount / .10);
			changeAmount %= .10;

			int nickel = (int) (changeAmount / .05);
			changeAmount %= .05;

			int penny = (int) (changeCounter(changeAmount, .01) + .5);
			changeAmount %= .01;
			
			//user Output invocation
			
			userChangeProvided(tenDollar, fiveDollar, oneDollar, quarter, dime, nickel, penny, itemPrice, tender);
		}
	}

	// Returns max times you can receive a bill from changeAmount
	private double changeCounter(double changeAmount, double modForCash) {
		return changeAmount / modForCash;
	}

	// Concatenate a string for user output of change
	private void userChangeProvided(int ten, int five, int one, int quarter, int dime, int nickel, int penny,
			double itemPrice, double tender) {
		
		String result = String.format("Amount: %.2f, Tendered: %.2f, Result:", itemPrice, tender);
		
		//TODO refactor into method
		
		if (ten > 1) {
			result += " " + ten + " ten dollar bills,";
		} else if (ten > 0) {
			result += " " + ten + " ten dollar bill,";
		}
		if (five > 1) {
			result += " " + five + " five dollar bills,";
		} else if (five > 0) {
			result += " " + five + " five dollar bill,";
		}
		if (one > 1) {
			result += " " + one + " one dollar bills,";
		} else if (one > 0) {
			result += " " + one + " one dollar bill,";
		}
		if (quarter > 1) {
			result += " " + quarter + " quarters,";
		} else if (quarter > 0) {
			result += " " + quarter + " quarter,";
		}
		if (dime > 1) {
			result += " " + dime + " dimes,";
		} else if (dime > 0) {
			result += " " + dime + " dime,";
		}
		if (nickel > 1) {
			result += " " + nickel + " nickles,";
		} else if (nickel > 0) {
			result += " " + nickel + " nickel,";
		}
		//TODO remove the commas if only a penny in string
		if (penny > 1) {
			result += " " + penny + " pennies.";
		} else if (penny > 0) {
			result += " " + penny + " penny.";
		}

		System.out.println(result);
		//TODO account for missing certain currencies on output with commas
	}

}
