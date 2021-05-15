package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		MakeChange checkout = new MakeChange();

		// PROMPT USER FOR INPUT AND STORE
		boolean enteringItems = true;
		
		while(enteringItems) {
			checkout.promptCustomer("getItem");
			double itemPrice = scanner.nextDouble();
			
			checkout.promptCustomer("");
			double tender = scanner.nextDouble();
			
			checkout.changeReturn(itemPrice, tender);
			checkout.promptCustomer("continue");
			
			String customerOption = scanner.next();
			
			if(customerOption.equalsIgnoreCase("Y") || customerOption.equalsIgnoreCase("Yes")) {
				continue;
			}else {
				enteringItems = false;
			}
		}
		scanner.close();
	}

	private void promptCustomer(String type) {
		if(type.equals("continue")){
			System.out.print("Would you like to enter another item Y | N: ");
		}else if (type.equals("getItem")) {
			System.out.print("Please enter the item price: ");
		}else {
			System.out.print("Please enter tender provided: ");
		}
	}

	// CHECKS IF ENOUGH TENDER WAS PROVIDED FOR PURCHASE

	private boolean verifyEnoughTender(double itemPrice, double tender) {
		if (tender >= itemPrice && itemPrice > 0) {
			return true;
		}

		System.out.printf("Amount: %.2f, Tendered: %.2f, Result: Error message", itemPrice, tender);

		return false;
	}

	private void changeReturn(double itemPrice, double tender) {

	// VERIFY ENOUGH TENDER FOR PURCHASE //

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

	// USER OUTPUT INVOCATION

			userChangeProvided(tenDollar, fiveDollar, oneDollar, quarter, dime, nickel, penny, itemPrice, tender);
		}
	}

	// RETURNS MAX BILLS DIVISIBLE

	private double changeCounter(double changeAmount, double modForCash) {
		return changeAmount / modForCash;
	}

	// OUTPUTS FINAL RESULT FROM STRING BUILDER TO USER

	private void userChangeProvided(int ten, int five, int one, int quarter, int dime, int nickel, int penny,
			double itemPrice, double tender) {

		String finalResult = String.format("Amount: %.2f, Tendered: %.2f, Result:", itemPrice, tender);
		String tempString = "";

	// CALL STRING BUILDER

		tempString = userChangeStringBuilder(tempString, ten, "ten dollar", " bill,", "bills,");
		tempString = userChangeStringBuilder(tempString, five, "five dollar", " bill,", "bills,");
		tempString = userChangeStringBuilder(tempString, one, "one dollar", " bill,", "bills,");
		tempString = userChangeStringBuilder(tempString, quarter, "quarter,", "", "quarters,");
		tempString = userChangeStringBuilder(tempString, dime, "dime,", "", "dimes,");
		tempString = userChangeStringBuilder(tempString, nickel, "nickel,", "", "nickels,");
		tempString = userChangeStringBuilder(tempString, penny, "penny", "", "pennies");

	// REMOVE COMMAS AT END IF REQUIRED

		tempString = checkRemoveComma(tempString);

		finalResult += tempString + ".";

		System.out.println(finalResult);
	}

	// PROVIDES STRING FOR OUTPUT

	private String userChangeStringBuilder(String current, int typeOfCurrency, String billType, String billSingular,
			String billPlural) {

		if (typeOfCurrency > 1) {

			if (billType.contains("quarter") || billType.contains("dime") || billType.contains("nickel") || billType.contains("penny")) {
				current += " " + typeOfCurrency + " " + billPlural;
				return current;
			} else {
				current += " " + typeOfCurrency + " " + billType + " " + billPlural;
				return current;
			}

		} else if (typeOfCurrency > 0) {
			current += " " + typeOfCurrency + " " + billType + billSingular;
			return current;
		} else {
			return current;
		}
	}

	// CHECKS FOR COMMAS IN THE CASE THAT THERE IS NO PENNIES

	private String checkRemoveComma(String tempString) {

		int length = tempString.length();
		String lastChar = String.valueOf(tempString.charAt(length - 1));

		if (lastChar.equals(",")) {
			return tempString.substring(0, length - 1);
		} else {
			return tempString;
		}
	}
}
