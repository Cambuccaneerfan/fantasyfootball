package main;

import java.util.Scanner;

import league.CreateLeague;
import league.ManageTeam;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~Fantasy Football~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
			System.out.println("---Main Menu---");
			System.out.println("");
			System.out.println("1 - Create New League");
			System.out.println("2 - Continue Saved League");
			System.out.println("3 - Load Sample League");
			System.out.println("");
			System.out.println("0 - Exit");
			
			int choice;
			do {
				while (!keyboard.hasNextInt()) {
					keyboard.nextLine();
				}
				choice = keyboard.nextInt();
				keyboard.nextLine();
			} while (choice < 0 || choice > 3);

			if (choice == 1) {
				CreateLeague.create(keyboard);
			}
			if (choice == 2) {
				ManageTeam.manage(keyboard);
			}
			if (choice == 3) {
				ManageTeam.loadSample(keyboard);
			}
			if (choice == 0) {
				if (keyboard != null) {
					keyboard.close();
				}
				System.exit(0);
			}
		}
	}
}