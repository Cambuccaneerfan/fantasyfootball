package main;

import java.util.Scanner;

import league.CreateLeague;
import league.ManageTeam;

public class Main {
	public static void main(String[] args) {
		while (true) {
			Scanner keyboard = new Scanner(System.in);
			int choice = -1;
			do {
				System.out.println("");
				System.out.println("~~~Fantasy Football~~~");
				System.out.println("");
				System.out.println("---Main Menu---");
				System.out.println("");
				System.out.println("1 - Create New League");
				System.out.println("2 - Continue Saved League");
				System.out.println("3 - Load Sample League");
				System.out.println("");
				System.out.println("0 - Exit");

				while (!keyboard.hasNextInt()) // ask again if anything other
												// than an integer is entered
				{
					keyboard.next();
					System.out.println("");
					System.out.println("~~~Fantasy Football~~~");
					System.out.println("");
					System.out.println("---Main Menu---");
					System.out.println("");
					System.out.println("1 - Create a new League");
					System.out.println("2 - Continue saved League");
					System.out.println("3 - Load Sample League");
					System.out.println("");
					System.out.println("0 - Exit");
				}

				choice = keyboard.nextInt();
			} while (choice < 0 || choice > 3);

			if (choice == 1) {
				CreateLeague.create();
			}
			if (choice == 2) {
				ManageTeam.manage();
			}
			if (choice == 3) {
				ManageTeam.loadSample();
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