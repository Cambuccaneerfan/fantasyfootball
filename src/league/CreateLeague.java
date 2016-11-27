package league;

import java.util.Scanner;

import utilities.Serializer;

public class CreateLeague {
	public static void create(Scanner keyboard) {
		League theLeague = new League();

		// Commissioner should be able to create a league, and establish the
		// settings for the league.
		// The commissioner must be able to (1) set the league name, (2) number
		// of teams in the league,
		// (3) scoring rules, (4) maximum players per team, (4) starting players
		// per team,
		// (5) the managers in the league, and also be able to (6) enter draft
		// results.

		// (1) set the league name
		System.out.println("");
		while (theLeague.getLeagueName().isEmpty() || theLeague.getLeagueName().length() > 32) {
			System.out.println("What is the name of the league? (max 32 characters)");
			theLeague.setLeagueName(keyboard.nextLine());
		}

		// (2) number of teams in the league
		while (theLeague.getNumTeams() < 2 || theLeague.getNumTeams() > 8) {
			System.out.println("How many teams are in the league? (2-8)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many teams are in the league? (2-8)");
			}
			theLeague.setNumTeams(keyboard.nextInt());
		}
		theLeague.createTeamList();

		// (3) scoring rules
		int scoringChoice;
		while (theLeague.getScoringRules().isEmpty()) {
			do {
				System.out.println("What are the scoring rules of the league?");
				System.out.println("1 - Standard");
				System.out.println("2 - Point-Per-Reception");
				System.out.println("3 - Custom");
				while (!keyboard.hasNextInt()) {
					keyboard.next();
					System.out.println("What are the scoring rules of the league?");
					System.out.println("1 - Standard");
					System.out.println("2 - Point-Per-Reception");
					System.out.println("3 - Custom");
				}
				scoringChoice = keyboard.nextInt();
			} while (scoringChoice < 1 || scoringChoice > 3);

			if (scoringChoice == 1) {
				theLeague.setScoringRules("Standard");
			}
			if (scoringChoice == 2) {
				theLeague.setScoringRules("Point-Per-Reception");
			}
			if (scoringChoice == 3) {
				keyboard.nextLine();
				while (theLeague.getScoringRules().isEmpty() || theLeague.getScoringRules().length() > 128) {
					System.out.println("Enter your custom scoring rules (max 128 characters)");
					theLeague.setScoringRules(keyboard.nextLine());
				}
			}
		}

		// (4) maximum players per team, (4) starting players per team... max =
		// starting + bench
		do {
			System.out.println("How many starting QBs will each team use? (0-2)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many starting QBs will each team use? (0-2)");
			}
			theLeague.setMaxQB(keyboard.nextInt());
		} while (theLeague.getMaxQB() < 0 || theLeague.getMaxQB() > 2);
		do {
			System.out.println("How many starting WRs will each team use? (0-4)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many starting WRs will each team use? (0-4)");
			}
			theLeague.setMaxWR(keyboard.nextInt());
		} while (theLeague.getMaxWR() < 0 || theLeague.getMaxWR() > 4);
		do {
			System.out.println("How many starting RBs will each team use? (0-4)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many starting RBs will each team use? (0-4)");
			}
			theLeague.setMaxRB(keyboard.nextInt());
		} while (theLeague.getMaxRB() < 0 || theLeague.getMaxRB() > 4);
		do {
			System.out.println("How many starting TEs will each team use? (0-2)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many starting TEs will each team use? (0-2)");
			}
			theLeague.setMaxTE(keyboard.nextInt());
		} while (theLeague.getMaxTE() < 0 || theLeague.getMaxTE() > 2);
		do {
			System.out.println("How many bench players will each team have? (0-8)");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("How many starting RBs will each team use? (0-8)");
			}
			theLeague.setMaxBench(keyboard.nextInt());
		} while (theLeague.getMaxBench() < 0 || theLeague.getMaxBench() > 8);
		keyboard.nextLine();

		// (5) the managers in the league... set team names as well
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			while (theLeague.getTeam(x).getManagerName().isEmpty()
					|| theLeague.getTeam(x).getManagerName().length() > 32) {
				if (x == 0) {
					System.out.println("As the creator of the League, you will manage Team Number " + (x + 1) + ", ");
					System.out.println("and act as Commissioner. What is your name? (max 32 characters)");
					theLeague.getTeam(x).setManagerName(keyboard.nextLine());
				} else {
					System.out.println("Who is managing Team Number " + (x + 1) + "? (max 32 characters)");
					theLeague.getTeam(x).setManagerName(keyboard.nextLine());
				}
				for (int y = 0; y < x; y++) {
					if (theLeague.getTeam(x).getManagerName().equalsIgnoreCase(theLeague.getTeam(y).getManagerName())) {
						System.out.println("That manager name is already being used.");
						theLeague.getTeam(x).setManagerName("");
					}
				}
			}
			while (theLeague.getTeam(x).getTeamName().isEmpty() || theLeague.getTeam(x).getTeamName().length() > 32) {
				System.out.println("What is the name of " + theLeague.getTeam(x).getManagerName()
						+ "'s team? (max 32 characters)");
				theLeague.getTeam(x).setTeamName(keyboard.nextLine());
				for (int y = 0; y < x; y++) {
					if (theLeague.getTeam(x).getTeamName().equalsIgnoreCase(theLeague.getTeam(y).getTeamName())) {
						System.out.println("That team name is already being used.");
						theLeague.getTeam(x).setTeamName("");
					}
				}
			}
		}

		// (6) enter draft results
		theLeague.createPlayerList();
		int draftChoice = -1;
		for (int x = 0; x < theLeague.getMaxPlayers(); x++) {
			for (int y = 0; y < theLeague.getNumTeams(); y++) {
				do {
					if (draftChoice == -1) {
						System.out.println("");
						System.out.println("All Available players:");
						theLeague.getFreeAgents();
						System.out.println("");
					}
					if (draftChoice == -2) {
						System.out.println("");
						System.out.println("Top 20 Available players:");
						theLeague.getFreeAgents(20);
						System.out.println("");
					}

					System.out.println("Which player did " + theLeague.getTeam(y).getManagerName()
							+ " draft? (enter number between 1 and " + (theLeague.playerList().size()) + ")");
					System.out.println("Enter -1 to view all available players");
					System.out.println("Enter -2 to view the top 20 available players");
					while (!keyboard.hasNextInt()) {
						keyboard.next();
						System.out.println("Which player did " + theLeague.getTeam(y).getManagerName()
								+ " draft? (enter number between 1 and " + (theLeague.playerList().size()) + ")");
						System.out.println("Enter -1 to view all available players");
						System.out.println("Enter -2 to view the top 20 available players");
					}
					draftChoice = keyboard.nextInt();

					if (draftChoice >= 1 && draftChoice <= theLeague.playerList().size()) {
						if (theLeague.playerList().get(draftChoice - 1).getIsOwned()) {
							System.out.println(theLeague.playerList().get(draftChoice - 1).playerToString()
									+ " has already been drafted");
							System.out.println("");
						} else {
							System.out.println(theLeague.getTeam(y).getManagerName() + " has selected "
									+ theLeague.playerList().get(draftChoice - 1).playerToString());
							System.out.println("");
						}
					}
				} while (draftChoice < 1 || draftChoice > theLeague.playerList().size()
						|| theLeague.playerList().get(draftChoice - 1).getIsOwned());
				draftChoice -= 1;
				theLeague.setDraftResult(y, draftChoice);
			}
		}

		System.out.println("");
		System.out.println("////////////////////////////////");
		System.out.println("");
		System.out.println("League name: " + theLeague.getLeagueName());
		System.out.println("");
		System.out.println("~~Commissioner~~");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("Team Number: " + (x + 1));
			theLeague.getTeam(x).teamToString();
			System.out.println("");
		}

		Serializer serializer = new Serializer();
		serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(),
				theLeague.getPendingTrade(), theLeague.getMaxQB(), theLeague.getMaxWR(), theLeague.getMaxRB(),
				theLeague.getMaxTE(),theLeague.getMaxBench(), theLeague.getTeamList(), theLeague.playerList());
		System.out.println("");
	}
}