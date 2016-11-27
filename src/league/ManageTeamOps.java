package league;

import java.util.Scanner;

import player.Player;
import team.Team;

public class ManageTeamOps {
	public static void editLineup(League theLeague, Team theTeam, Scanner keyboard) {
		
		System.out.println("");
		System.out.println("---Edit Lineup---");
		System.out.println("");
		theTeam.teamToStringNum();
		System.out.println("");
		
		int playerChoice;
		do {
			System.out.println("Select a player to move from the bench to starting or vice versa:");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("Select a player to move from the bench to starting or vice versa:");
			}
			playerChoice = keyboard.nextInt();
		} while (playerChoice < 1 || playerChoice > theTeam.getRoster().size());
		playerChoice -= 1;

		Player thePlayer = theTeam.getTeamPlayer(playerChoice);
		String position = thePlayer.getPosition();
		if (!thePlayer.getIsStarting()) {
			if (theTeam.starterCount(position) < theLeague.getPositionMax(position)) {
				thePlayer.setStarting();
			} else {
				System.out.println("--You have the maximum number of starters at the "
						+ position + " position--");
			}
		} else if (thePlayer.getIsStarting()) {
			thePlayer.setBench();
		}
	}

	public static void dropPlayer(League theLeague, Team theTeam, Scanner keyboard) {
		int playerChoice;

		System.out.println("");
		System.out.println("---Drop Player---");
		System.out.println("");
		theTeam.teamToStringNum();
		do {
			System.out.println("");
			System.out.println("Select a player that you would like to drop:");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				continue;
			}
			playerChoice = keyboard.nextInt();
		} while (playerChoice < 1 || playerChoice > theTeam.getRoster().size());
		playerChoice -= 1;

		Player thePlayer = theTeam.getTeamPlayer(playerChoice);
		theTeam.getRoster().remove(playerChoice);
		
		thePlayer.setFreeAgent();
		theLeague.playerList().set(thePlayer.getId(), thePlayer);
	}

	public static void addPlayer(League theLeague, Team theTeam, Scanner keyboard) {

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
		if (theTeam.getRoster().size() >= theLeague.getMaxPlayers()) {
			System.out.println("");
			System.out.println("***Your team is full. You must drop a player before adding one.***");
			return;
		}

		int playerChoice;
		do {
			System.out.println("");
			System.out.println("Select a player to add:");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("");
				System.out.println("Select a player to add:");
			}
			playerChoice = keyboard.nextInt();

			if (playerChoice >= 1 && playerChoice <= theLeague.playerList().size()) {
				if (theLeague.playerList().get(playerChoice-1).getIsOwned()) {
					System.out.println("");
					System.out.println(theLeague.playerList().get(playerChoice-1).playerToString() + " is not available");
				} else {
					System.out.println("");
					System.out
							.println("***You have added " + theLeague.playerList().get(playerChoice-1).playerToString() + "***");
				}
			}
		} while (playerChoice < 1 || playerChoice > theLeague.playerList().size()
				|| theLeague.playerList().get(playerChoice-1).getIsOwned());
		playerChoice -= 1;
		
		Player thePlayer = theLeague.playerList().get(playerChoice);
		thePlayer.setIsOwned();
		theTeam.getRoster().add(theTeam.getRoster().size(), thePlayer);
	}

	public static void proposeTrade(League theLeague, Team theTeam, Scanner keyboard) {
		int teamToView;
		String decision;
		String proposal;

		System.out.println("");
		System.out.println("---Propose Trade---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			if (theLeague.getTeam(x).getManagerName() != theTeam.getManagerName()) {
				System.out.println("");
				System.out.println("Team number: " + (x + 1));
				theLeague.getTeam(x).teamManNameToString();
			}
		}
		do {
			System.out.println("");
			System.out.println("Select a team to view:");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("");
				System.out.println("Select a team to view:");
			}
			teamToView = keyboard.nextInt();
		} while (teamToView < 1 || teamToView-1 == theLeague.getTeamList().indexOf(theTeam) || teamToView > theLeague.getNumTeams());
		teamToView -= 1;
		
		Team otherTeam = theLeague.getTeam(teamToView);
		
		System.out.println("");
		System.out.println("---Propose Trade---");
		System.out.println("");
		otherTeam.teamToString();
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
					otherTeam.teamToString();
					System.out.println("");
					System.out.println("Enter your trade offer (max 64 characters):");
					proposal = keyboard.nextLine();
				} while (proposal.isEmpty() || proposal.length() > 64);

				proposal = theTeam.getManagerName() + ": " + proposal;
				otherTeam.setProposedTrade(proposal);
				return;
			}
		} while (!decision.equalsIgnoreCase("n"));
	}

	public static void reviewTrade(League theLeague, Team theTeam, Scanner keyboard) {
		int decision;
		do {
			System.out.println("");
			System.out.println("---Review Trade Proposal---");
			System.out.println("");
			System.out.println(theTeam.getProposedTrade());
			System.out.println("");
			System.out.println("Would you like to accept this trade?");
			System.out.println("1 - Accept");
			System.out.println("2 - Reject");
			System.out.println("3 - Go Back");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("");
				System.out.println("---Review Trade Proposal---");
				System.out.println("");
				System.out.println(theTeam.getProposedTrade());
				System.out.println("");
				System.out.println("Would you like to accept this trade?");
				System.out.println("1 - Accept");
				System.out.println("2 - Reject");
				System.out.println("3 - Go Back");
			}
			decision = keyboard.nextInt();
		} while (decision < 1 || decision > 3);

		switch (decision) {
		case 1:
			theLeague.setPendingTrade("Accepted by " + theTeam.getManagerName()
					+ " --- " + theTeam.getProposedTrade());
			theTeam.setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Accepted - The Commissioner Must Process It.***");
			break;
		case 2:
			theTeam.setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Rejected***");
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	public static void editTeamName(League theLeague, Team theTeam, Scanner keyboard) {
		String newTeamName;
		do {
			System.out.println("");
			System.out.println("---Edit Team Name---");
			System.out.println("");
			System.out.println("Enter your new team name:");
			newTeamName = keyboard.nextLine();
			for (int x = 0; x < theLeague.getNumTeams(); x++) {
				if (theLeague.getTeam(x).getTeamName().equalsIgnoreCase(newTeamName)) {
					System.out.println("That team name is already being used.");
					newTeamName = "";
				}
			}
		} while (newTeamName.isEmpty() || newTeamName.length() > 32);
		theTeam.setTeamName(newTeamName);
	}

	public static void commissionerTools(League theLeague, Scanner keyboard) {
		int toolChoice;
		do {
			System.out.println("");
			System.out.println("---Commissioner Tools---");
			System.out.println("1 - Edit Scores");
			System.out.println("2 - Edit Standings");
			System.out.println("3 - Review Accepted Trade");
			System.out.println("4 - Return to Team");
			while (!keyboard.hasNextInt()) {
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
			editScores(theLeague, keyboard);
			break;
		case 2:
			editStandings(theLeague, keyboard);
			break;
		case 3:
			if (theLeague.getPendingTrade().isEmpty()) {
				System.out.println("");
				System.out.println("--There are no accepted trades pending--");
				break;
			}
			reviewAcceptedTrade(theLeague, keyboard);
			break;
		case 4:
			break;
		default:
			break;
		}
	}

	public static void editScores(League theLeague, Scanner keyboard) {
		int score;

		System.out.println("");
		System.out.println("---Edit Scores---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("");
			theLeague.getTeam(x).teamManNameToString();
			System.out.println("");
			do {
				System.out.println("Enter a score for " + theLeague.getTeam(x).getTeamName());
				while (!keyboard.hasNextInt()) {
					keyboard.next();
					System.out.println("Enter a score for " + theLeague.getTeam(x).getTeamName());
				}
				score = keyboard.nextInt();
			} while (score < 0 || score > 512);
			theLeague.getTeam(x).setScore(score);
		}
	}

	public static void editStandings(League theLeague, Scanner keyboard) {
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

	public static void reviewAcceptedTrade(League theLeague, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Accepted Trade---");
		System.out.println("");
		System.out.println(theLeague.getPendingTrade());
		
		int choice;
		do {
			System.out.println("");
			System.out.println("-Has this trade been processed?-");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			while (!keyboard.hasNextInt()) {
				keyboard.next();
				System.out.println("");
				System.out.println("-Has this trade been processed?-");
				System.out.println("1 - Yes");
				System.out.println("2 - No");
			}
			choice = keyboard.nextInt();
		} while (choice < 1 || choice > 2);
		if (choice == 1) {
			theLeague.setPendingTrade("");
		}
	}
}
