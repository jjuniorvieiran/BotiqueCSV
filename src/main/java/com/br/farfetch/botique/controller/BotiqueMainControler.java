package com.br.farfetch.botique.controller;

import java.util.Scanner;

import com.br.farfetch.botique.service.BotiqueServiceImpl;

public class BotiqueMainControler {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		new BotiqueServiceImpl().processOrder(input);
		
		System.out.println("Press to exit");
		scanner.nextLine();
		scanner.close();
	}

}
