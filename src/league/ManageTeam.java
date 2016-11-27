package league;

import java.util.Scanner;

import team.Team;
import utilities.Deserializer;
import utilities.Serializer;

public class ManageTeam {
	public static void loadSample(Scanner keyboard) {
		Deserializer deserializer = new Deserializer();
		League theLeague = deserializer.deserializeSampleLeague();

		Serializer serializer = new Serializer();
		serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(),
				theLeague.getPendingTrade(), theLeague.getMaxQB(), theLeague.getMaxWR(), theLeague.getMaxRB(),
				theLeague.getMaxTE(),theLeague.getMaxBench(), theLeague.getTeamList(), theLeague.playerList());

		manage(keyboard);
	}

	public static void manage(Scanner keyboard) {
		Deserializer deserializer = new Deserializer();
		Serializer serializer = new Serializer();

		League theLeague = deserializer.deserializeSavedLeague();

		System.out.println("");
		System.out.println("---Continue League---");
		System.out.println("");
		System.out.println("League name: " + theLeague.getLeagueName());
		System.out.println("");
		System.out.println("~~Commissioner~~");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("Team number: " + (x + 1));
			theLeague.getTeam(x).teamManNameToString();
			System.out.println("");
		}

		int teamChoice;
		do {
			System.out.println("What team number are you managing?");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("What team number are you managing?");
			}
			teamChoice = keyboard.nextInt();
		} while (teamChoice < 1 || teamChoice > theLeague.getNumTeams());
		teamChoice -= 1;

		Team theTeam = theLeague.getTeam(teamChoice);
		
		int menuChoice;
		do {
			do {
				System.out.println("");
				System.out.println("---Team Management---");
				theTeam.teamToString();
				if (!theLeague.getPendingTrade().isEmpty()) {
					System.out.println("");
					System.out.println("***A trade has been accepted.***");
					System.out.println(theLeague.getPendingTrade());
				}
				if (!theTeam.getProposedTrade().isEmpty()) {
					System.out.println("");
					System.out.println("***There has been a trade proposed to you.***");
					System.out.println(theTeam.getProposedTrade());
				}
				System.out.println("");
				System.out.println("1 - Edit Lineup");
				System.out.println("2 - Drop Player");
				System.out.println("3 - Add Player");
				System.out.println("4 - Propose Trade");
				System.out.println("5 - Review Trade Offer");
				System.out.println("6 - Change Team Name");
				System.out.println("7 - View League Settings");
				System.out.println("8 - View Scores and Standings");
				System.out.println("9 - Commissioner Tools (edit standings, process trades)");
				System.out.println("0 - Exit to Main Menu");
				while (!keyboard.hasNextInt()) {
					keyboard.next();
					System.out.println("");
					System.out.println("Please enter a valid menu option.");
				}
				menuChoice = keyboard.nextInt();
			} while (menuChoice < 0 || menuChoice > 9);

			switch (menuChoice) {
			case 1:
				ManageTeamOps.editLineup(theLeague, theTeam, keyboard);
				break;
			case 2:
				ManageTeamOps.dropPlayer(theLeague, theTeam, keyboard);
				break;
			case 3:
				ManageTeamOps.addPlayer(theLeague, theTeam, keyboard);
				break;
			case 4:
				ManageTeamOps.proposeTrade(theLeague, theTeam, keyboard);
				break;
			case 5:
				if (theTeam.getProposedTrade().isEmpty()) {
					System.out.println("");
					System.out.println("--You have not been offered a trade--");
				} else {
					ManageTeamOps.reviewTrade(theLeague, theTeam, keyboard);
				}
				break;
			case 6:
				ManageTeamOps.editTeamName(theLeague, theTeam, keyboard);
				break;
			case 7:
				theLeague.viewSettings();
				break;
			case 8:
				theLeague.viewStandings();
				break;
			case 9:
				if (teamChoice == 0) {
					ManageTeamOps.commissionerTools(theLeague, keyboard);
				} else {
					System.out.println("");
					System.out.println("--You must be the commissioner to access Commissioner Tools--");
				}
				break;
			case 0:
				break;
			default:
				break;
			}

			serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(),
					theLeague.getPendingTrade(), theLeague.getMaxQB(), theLeague.getMaxWR(), theLeague.getMaxRB(),
					theLeague.getMaxTE(),theLeague.getMaxBench(), theLeague.getTeamList(), theLeague.playerList());
		} while (menuChoice != 0);
	}
}