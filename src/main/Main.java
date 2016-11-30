package main;

import java.util.Scanner;

import league.CreateLeague;
import league.ManageTeam;
import utilities.Input;

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
			
			switch (Input.validInt(0, 3, keyboard)) {
				case 1:
					System.out.println("");
					System.out.println("Creating a new league will overwrite the existing saved league.");
					System.out.println("Would you like to continue?");
					System.out.println("1 - Yes, Create New League");
					System.out.println("2 - No, Return to Main Menu");
					if (Input.validInt(1, 2, keyboard) == 1) {
						CreateLeague.create(keyboard);
					}
					break;
				case 2:
					ManageTeam.manage(keyboard);
					break;
				case 3:
					System.out.println("");
					System.out.println("Loading the sample league will overwrite the existing saved league.");
					System.out.println("Would you like to continue?");
					System.out.println("1 - Yes, Load Sample League");
					System.out.println("2 - No, Return to Main Menu");
					if (Input.validInt(1, 2, keyboard) == 1) {
						ManageTeam.loadSample(keyboard);
					}
					break;
				case 0:
					System.out.println("");
					System.out.println("Are you sure you want to exit?");
					System.out.println("1 - Yes, Exit");
					System.out.println("2 - No, Return to Main Menu");
					if (Input.validInt(1, 2, keyboard) == 1) {
						keyboard.close();
						System.exit(0);
					}
					break;
			}
		}
	}
}