package league;

import java.util.Scanner;

import utilities.Input;
import utilities.Serializer;

public class CreateLeague {
	/**
	 * Create a new customized league
	 * 
	 * @param keyboard  the keyboard
	 */
	public static void create(Scanner keyboard) {
		League theLeague = new League();

		// Commissioner should be able to create a league, and establish the
		// settings for the league.
		// The commissioner must be able to
		// (1) set the league name,
		// (2) number of teams in the league,
		// (3) scoring rules
		// (4) maximum players per team, (4) starting players per team,
		// (5) the managers in the league, and also be able to
		// (6) enter draft results.

		// (1) set the league name
		System.out.println("");
		System.out.println("What is the name of the league? (max 32 characters)");
		theLeague.setLeagueName(Input.validString(32, keyboard));

		// (2) number of teams in the league
		System.out.println("How many teams are in the league? (2-8)");
		theLeague.setNumTeams(Input.validInt(2, 8, keyboard));
		theLeague.createTeamList();

		// (3) scoring rules
		System.out.println("What are the scoring rules of the league?");
		System.out.println("1 - Standard");
		System.out.println("2 - Point-Per-Reception");
		System.out.println("3 - Custom");
		switch (Input.validInt(1, 3, keyboard)) {
		case 1:
			theLeague.setScoringRules("Standard");
			break;
		case 2:
			theLeague.setScoringRules("Point-Per-Reception");
			break;
		case 3:
			System.out.println("Enter your custom scoring rules (max 128 characters)");
			theLeague.setScoringRules(Input.validString(128, keyboard));
			break;
		default:
			break;
		}

		// (4) maximum players per team, (4) starting players per team... max =
		// starting + bench
		do {
			System.out.println("How many starting QBs will each team use? (0-2)");
			theLeague.setMaxQB(Input.validInt(0, 2, keyboard));
			System.out.println("How many starting WRs will each team use? (0-4)");
			theLeague.setMaxWR(Input.validInt(0, 4, keyboard));
			System.out.println("How many starting RBs will each team use? (0-4)");
			theLeague.setMaxRB(Input.validInt(0, 4, keyboard));
			System.out.println("How many starting TEs will each team use? (0-2)");
			theLeague.setMaxTE(Input.validInt(0, 2, keyboard));
			System.out.println("How many Bench players will each team use? (0-8)");
			theLeague.setMaxBench(Input.validInt(0, 8, keyboard));
			if (theLeague.getMaxPlayers() == 0) {
				System.out.println("The roster has to include at least one player!");
			}
		} while (theLeague.getMaxPlayers() == 0);
		
		// (5) the managers in the league... set team names as well
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			if (x == 0) {
				System.out.println("As the creator of the League, you will manage Team Number " + (x + 1) + ", ");
				System.out.println("and act as Commissioner. What is your name? (max 32 characters)");
			} else {
				System.out.println("Who is managing Team Number " + (x + 1) + "? (max 32 characters)");
			}
			do {
				theLeague.getTeam(x).setManagerName(Input.validString(32, keyboard));
				for (int y = 0; y < x; y++) {
					if (theLeague.getTeam(x).getManagerName().equalsIgnoreCase(theLeague.getTeam(y).getManagerName())) {
						System.out.println("That manager name is already being used.");
						theLeague.getTeam(x).setManagerName("");
					}
				}
			} while (theLeague.getTeam(x).getManagerName().isEmpty());

			System.out.println(
					"What is the name of " + theLeague.getTeam(x).getManagerName() + "'s team? (max 32 characters)");
			do {
				theLeague.getTeam(x).setTeamName(Input.validString(32, keyboard));
				for (int y = 0; y < x; y++) {
					if (theLeague.getTeam(x).getTeamName().equalsIgnoreCase(theLeague.getTeam(y).getTeamName())) {
						System.out.println("That team name is already being used.");
						theLeague.getTeam(x).setTeamName("");
					}
				}
			} while (theLeague.getTeam(x).getTeamName().isEmpty());
		}

		// (6) enter draft results using the addPlayer method
		theLeague.createPlayerList();
		for (int x = 0; x < theLeague.getMaxPlayers(); x++) {
			for (int y = 0; y < theLeague.getNumTeams(); y++) {
				ManageTeamOps.addPlayer(theLeague, theLeague.getTeam(y), keyboard);
			}
		}

		// display all teams
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

		// save new league
		Serializer serializer = new Serializer();
		serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(),
				theLeague.getPendingTrade(), theLeague.getMaxQB(), theLeague.getMaxWR(), theLeague.getMaxRB(),
				theLeague.getMaxTE(), theLeague.getMaxBench(), theLeague.getTeamList(), theLeague.playerList());
		System.out.println("");
	}
}