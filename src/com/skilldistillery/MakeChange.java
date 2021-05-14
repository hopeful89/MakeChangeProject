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

		// TODO user is prompted again for amount tendered by customer ///////////Story2
		// TODO random function if wanted
		// TODO Display appropriate message if tender less than price ///////////Story 3

		// TODO return change to customer largest to smallest /////////// Story 4
	}

	private void promptCustomer(String type) {
		if(type.equals("getItem")) {
			System.out.print("Please enter the item price: ");			
		}else {
			System.out.print("Please enter tender provided: ");						
		}
	}
}
