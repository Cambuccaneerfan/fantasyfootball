package league;

import java.util.Scanner;

public class ManageTeamOps {
	
	public static void editLineup(League theLeague, int teamChoice) {
		Scanner keyboard = new Scanner(System.in);
		int playerChoice;

		System.out.println("");
		System.out.println("---Edit Lineup---");
		System.out.println("");
		theLeague.getTeam(teamChoice).teamToStringNum();
		System.out.println("");

		do {
			System.out.println("Select a player to move from the bench to starting or vice versa:");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("Select a player to move from the bench to starting or vice versa:");
			}
			playerChoice = keyboard.nextInt();
		} while (playerChoice < 1 || playerChoice > theLeague.getTeam(teamChoice).getRoster().size());
		playerChoice -= 1;

		if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).startingIndicator().equals("BENCH")) {
			if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("QB")
					&& theLeague.getTeam(teamChoice).countQB() < theLeague.getNumQB()) {
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingQB();
			} else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("WR")
					&& theLeague.getTeam(teamChoice).countWR() < theLeague.getNumWR()) {
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingWR();
			} else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("RB")
					&& theLeague.getTeam(teamChoice).countRB() < theLeague.getNumRB()) {
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingRB();
			} else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("TE")
					&& theLeague.getTeam(teamChoice).countTE() < theLeague.getNumTE()) {
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingTE();
			} else {
				System.out.println("--You have the maximum number of starters at the "
						+ theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition() + " position--");
			}
		} else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).startingIndicator().equals("~~START~~")) {
			theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setBench();
		}
	}

	public static void dropPlayer(League theLeague, int teamChoice) {
		Scanner keyboard = new Scanner(System.in);
		int playerChoice;

		System.out.println("");
		System.out.println("---Drop Player---");
		System.out.println("");
		theLeague.getTeam(teamChoice).teamToStringNum();

		do {
			System.out.println("");
			System.out.println("Select a player that you would like to drop:");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("");
				System.out.println("Select a player that you would like to drop:");
			}
			playerChoice = keyboard.nextInt();
		} while (playerChoice < 1 || playerChoice > theLeague.getTeam(teamChoice).getRoster().size());
		playerChoice -= 1;

		theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setFreeAgent();
		theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setBench();
		theLeague.playerList().set(theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getId(),
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice));
		theLeague.getTeam(teamChoice).getRoster().remove(playerChoice);
	}

	public static void addPlayer(League theLeague, int teamChoice) {
		Scanner keyboard = new Scanner(System.in);

		if (theLeague.getTeam(teamChoice).getRoster().size() >= theLeague.getMaxPlayers()) {
			System.out.println("");
			System.out.println("***Your team is full. You must drop a player before adding one.***");
			return;
		}

		System.out.println("");
		System.out.println("---Add Player---");
		System.out.println("");
		System.out.println("-All Free Agents-");
		System.out.println("");
		theLeague.getFreeAgents();
		System.out.println("");
		System.out.println("-Top 20 Free Agents-");
		System.out.println("");
		theLeague.getFreeAgents(20);

		int playerChoice;
		do {
			System.out.println("");
			System.out.println("Select a player to add:");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("");
				System.out.println("Select a player to add:");
			}
			playerChoice = keyboard.nextInt();

			if (playerChoice >= 1 && playerChoice <= theLeague.playerList().size()) {
				playerChoice -= 1;
				if (theLeague.getPlayer(playerChoice).getIsOwned()) {
					System.out.println("");
					System.out.println(theLeague.getPlayer(playerChoice).playerToString() + " is not available");
				} else {
					System.out.println("");
					System.out
							.println("***You have added " + theLeague.getPlayer(playerChoice).playerToString() + "***");
				}
			}
		} while (playerChoice < 0 || playerChoice > theLeague.playerList().size() - 1
				|| theLeague.getPlayer(playerChoice).getIsOwned());

		theLeague.getPlayer(playerChoice).setIsOwned();
		theLeague.getTeam(teamChoice).getRoster().add(theLeague.getTeam(teamChoice).getRoster().size(),
				theLeague.getPlayer(playerChoice));
	}

	public static void proposeTrade(League theLeague, int teamChoice) {
		Scanner keyboard = new Scanner(System.in);
		int teamToView;
		String decision;
		String proposal;

		System.out.println("");
		System.out.println("---Propose Trade---");

		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			if (x != teamChoice) {
				System.out.println("");
				System.out.println("Team number: " + (x + 1));
				theLeague.getTeam(x).teamManNameToString();
			}
		}

		do {
			System.out.println("");
			System.out.println("Select a team to view:");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("");
				System.out.println("Select a team to view:");
			}
			teamToView = keyboard.nextInt();
		} while (teamToView < 1 || teamToView == teamChoice + 1 || teamToView > theLeague.getNumTeams());
		teamToView -= 1;

		System.out.println("");
		System.out.println("---Propose Trade---");
		System.out.println("");
		theLeague.getTeam(teamToView).teamToString();

		do {
			keyboard.nextLine();
			System.out.println("");
			System.out.println("Would you like to propose a trade to this team? (y/n)");
			decision = keyboard.nextLine();

			if (decision.equalsIgnoreCase("y")) {
				do {
					System.out.println("");
					System.out.println("---Propose Trade---");
					System.out.println("");
					theLeague.getTeam(teamToView).teamToString();
					System.out.println("");
					System.out.println("Enter your trade offer (max 64 characters):");
					proposal = keyboard.nextLine();
				} while (proposal.isEmpty() || proposal.length() > 64);

				proposal = theLeague.getTeam(teamChoice).getManagerName() + ": " + proposal;
				theLeague.getTeam(teamToView).setProposedTrade(proposal);

				return;
			}
		} while (!decision.equalsIgnoreCase("n"));
	}

	public static void reviewTrade(League theLeague, int teamChoice) {
		if (theLeague.getTeam(teamChoice).getProposedTrade().isEmpty()) {
			System.out.println("");
			System.out.println("--You have not been offered a trade--");
			return;
		}

		Scanner keyboard = new Scanner(System.in);
		int decision;

		do {
			System.out.println("");
			System.out.println("---Review Trade Proposal---");
			System.out.println("");
			System.out.println(theLeague.getTeam(teamChoice).getProposedTrade());
			System.out.println("");
			System.out.println("Would you like to accept this trade?");
			System.out.println("1 - Accept");
			System.out.println("2 - Reject");
			System.out.println("3 - Go Back");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("");
				System.out.println("---Review Trade Proposal---");
				System.out.println("");
				System.out.println(theLeague.getTeam(teamChoice).getProposedTrade());
				System.out.println("");
				System.out.println("Would you like to accept this trade?");
				System.out.println("1 - Accept");
				System.out.println("2 - Reject");
				System.out.println("3 - Go Back");
			}
			decision = keyboard.nextInt();
		} while (decision < 0 || decision > 3);

		switch (decision) {
		case 1:
			theLeague.getTeam(0).setPendingTrade("Accepted by " + theLeague.getTeam(teamChoice).getManagerName()
					+ " --- " + theLeague.getTeam(teamChoice).getProposedTrade());
			theLeague.getTeam(teamChoice).setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Accepted - The Commissioner Must Process It.***");
			break;
		case 2:
			theLeague.getTeam(teamChoice).setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Rejected***");
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	public static void editTeamName(League theLeague, int teamChoice) {
		Scanner keyboard = new Scanner(System.in);
		String newTeamName;

		do {
			System.out.println("");
			System.out.println("---Edit Team Name---");
			System.out.println("");
			System.out.println("Enter your new team name:");
			newTeamName = keyboard.nextLine();
		} while (newTeamName.isEmpty() || newTeamName.length() > 32);

		theLeague.getTeam(teamChoice).setTeamName(newTeamName);
	}

	public static void viewSettings(League theLeague) {
		System.out.println("");
		System.out.println("---League Settings---");
		System.out.println("League Name: " + theLeague.getLeagueName());
		System.out.println("Scoring Rules: " + theLeague.getScoringRules());
		System.out.println("Starting Positions: (" + theLeague.getMaxPlayers() + " player maximum)");
		System.out.println(theLeague.getNumQB() + " QB");
		System.out.println(theLeague.getNumWR() + " WR");
		System.out.println(theLeague.getNumRB() + " RB");
		System.out.println(theLeague.getNumTE() + " TE");
		System.out.println(theLeague.getNumBench() + " Bench");
	}

	public static void viewStandings(League theLeague) {
		System.out.println("");
		System.out.println("---League Standings---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("");
			theLeague.getTeam(x).teamManNameToString();
			;
			System.out.println("Record: " + theLeague.getTeam(x).getRecord());
			System.out.println("This week's score: " + theLeague.getTeam(x).getScore());
		}
	}

	public static void commissionerTools(League theLeague) {
		Scanner keyboard = new Scanner(System.in);
		int toolChoice;

		do {
			System.out.println("");
			System.out.println("---Commissioner Tools---");
			System.out.println("1 - Edit Scores");
			System.out.println("2 - Edit Standings");
			System.out.println("3 - Review Accepted Trade");
			System.out.println("4 - Return to Team");
			while (!keyboard.hasNextInt()) // ask again if anything other than
											// an integer is entered
			{
				keyboard.next();
				System.out.println("");
				System.out.println("---Commissioner Tools---");
				System.out.println("1 - Edit Scores");
				System.out.println("2 - Edit Standings");
				System.out.println("3 - Review Accepted Trade");
				System.out.println("4 - Return to Team");
			}
			toolChoice = keyboard.nextInt();
		} while (toolChoice < 1 || toolChoice > 4);

		switch (toolChoice) {
		case 1:
			editScores(theLeague);
			break;
		case 2:
			editStandings(theLeague);
			break;
		case 3:
			reviewAcceptedTrade(theLeague);
			break;
		case 4:
			break;
		default:
			break;
		}
	}

	public static void reviewAcceptedTrade(League theLeague) {
		if (theLeague.getTeam(0).getPendingTrade().isEmpty()) {
			System.out.println("");
			System.out.println("--There are no accepted trades pending--");
			return;
		}

		System.out.println("");
		System.out.println("---Accepted Trade---");
		System.out.println("");
		System.out.println(theLeague.getTeam(0).getPendingTrade());
	}

	public static void editScores(League theLeague) {
		Scanner keyboard = new Scanner(System.in);
		int score;

		System.out.println("");
		System.out.println("---Edit Scores---");

		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("");
			theLeague.getTeam(x).teamManNameToString();
			System.out.println("");

			do {
				System.out.println("Enter a score for " + theLeague.getTeam(x).getTeamName());
				while (!keyboard.hasNextInt()) // ask again if anything other
												// than an integer is entered
				{
					keyboard.next();
					System.out.println("Enter a score for " + theLeague.getTeam(x).getTeamName());
				}
				score = keyboard.nextInt();
			} while (score < 0 || score > 512);
			theLeague.getTeam(x).setScore(score);
		}
	}

	public static void editStandings(League theLeague) {
		Scanner keyboard = new Scanner(System.in);
		String record;

		System.out.println("");
		System.out.println("---Edit Standings---");

		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			do {
				System.out.println("");
				theLeague.getTeam(x).teamManNameToString();
				System.out.println("Current record: " + theLeague.getTeam(x).getRecord());
				System.out.println("");
				System.out.println("Enter a new record:");
				record = keyboard.nextLine();
			} while (record.isEmpty() || record.length() > 32);
			theLeague.getTeam(x).setRecord(record);
		}
	}
}
