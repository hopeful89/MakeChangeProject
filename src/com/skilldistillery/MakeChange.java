package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		MakeChange checkout = new MakeChange();

//		checkout.promptCustomer("getItem");
//		double itemPrice = scanner.nextDouble();
//		checkout.promptCustomer("");
//		double tender = scanner.nextDouble();
		
//		checkout.changeReturn(itemPrice, tender);
		checkout.changeReturn(2.96, 20.00);

		// TODO random function if wanted

		// TODO return change to customer largest to smallest /////////// Story 4
	}

	private void promptCustomer(String type) {
		if (type.equals("getItem")) {
			System.out.print("Please enter the item price: ");
		} else {
			System.out.print("Please enter tender provided: ");
		}
	}
	
	private boolean verifyEnoughTender(double itemPrice, double tender) {
		if(tender >= itemPrice) {
			System.out.println("You have enough money");
			return true;
		}
		System.out.println("Not enough tender provided for purchase.");
		return false;
	}
	
	private void changeReturn(double itemPrice, double tender) {
		if(verifyEnoughTender(itemPrice, tender)) {
			double changeAmount = tender - itemPrice;
			int tenDollar = (int)changeCounter(changeAmount, 10);
			changeAmount %= 10;
			int fiveDollar = (int)changeCounter(changeAmount, 5);
			changeAmount %= 5;
			int oneDollar = (int)changeCounter(changeAmount, 1);
			changeAmount %= 1;
			int quarter = (int)changeCounter(changeAmount, .25);
			changeAmount %= .25;
			int dime = (int)(changeAmount / .10);
			changeAmount %= .10;
			int nickel = (int)(changeAmount / .05);
			changeAmount %= .05;
			int penny = (int)changeCounter(changeAmount, .01);
			changeAmount %= .01;
			System.out.println(penny);
		}
	}
	
	private double changeCounter(double changeAmount, double modForCash) {
		return changeAmount / modForCash;
	}
}
