package league;

import java.util.Scanner;

import player.Player;
import team.Team;
import utilities.Input;

public class ManageTeamOps {
	/**
	 * Move players between the bench and starting positions
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void editLineup(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Edit Lineup---");
		System.out.println("");
		theTeam.teamToStringNum();
		System.out.println("");
		System.out.println("Select a player to move from the bench to starting or vice versa:");
		System.out.println("0 - Return to Team Menu");
		System.out.println("1-" + theTeam.getRoster().size() + " - Select a player to be dropped");
		
		int lineupChoice = Input.validInt(0, theTeam.getRoster().size(), keyboard);
		if (lineupChoice == 0) {
			return;
		}
		Player thePlayer = theTeam.getTeamPlayer(lineupChoice - 1);
		
		if (thePlayer.getIsStarting()) {
			thePlayer.setBench();
			return;
		}
		String position = thePlayer.getPosition();
		if (theTeam.starterCount(position) < theLeague.getPositionMax(position)) {
			thePlayer.setStarting();
		} else {
			System.out.println("");
			System.out.println("***You have the maximum number of starters at the " + position + " position***");
		}
	}

	/**
	 * Remove a player from the team and make the player a free agent.
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void dropPlayer(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Drop Player---");
		System.out.println("");
		theTeam.teamToStringNum();
		System.out.println("");
		System.out.println("   0 - Return to Team Menu");
		System.out.println("1-" + theTeam.getRoster().size() + " - Select a player to be dropped");
		int dropChoice = Input.validInt(0, theTeam.getRoster().size(), keyboard);
		if (dropChoice == 0) {
			return;
		}
		Player thePlayer = theTeam.getTeamPlayer(dropChoice - 1);

		thePlayer.setFreeAgent();
		theLeague.playerList().set(thePlayer.getId(), thePlayer);
		theTeam.getRoster().remove(thePlayer);
		System.out.println("");
		System.out.println("***You have dropped " + thePlayer.playerToString() + "***");
	}

	/**
	 * Add a free agent player to the team.
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void addPlayer(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Add Player---");
		theTeam.teamToString();
		System.out.println("");
		System.out.println("--Top 20 Free Agents--");
		theLeague.getFreeAgents(20);

		int playerChoice;
		do {
			do {
				System.out.println("");
				System.out.println("    0 - Filter Free Agents by Position");
				System.out.println("   -1 - View All Free Agents");
				System.out.println("1-" + theLeague.playerList().size() + " - Select a Player");
				playerChoice = Input.validInt(-1, theLeague.playerList().size(), keyboard);
				
				if (playerChoice == -1) {
					theLeague.getFreeAgents();
				}

				if (playerChoice == 0) {
					System.out.println("");
					System.out.println("Which position would you like to view?");
					System.out.println("1 - QB");
					System.out.println("2 - WR");
					System.out.println("3 - RB");
					System.out.println("4 - TE");
					switch (Input.validInt(1, 4, keyboard)) {
					case 1:
						System.out.println("\n--Top 20 Free Agent QBs--\n");
						theLeague.getFreeAgents(20, "QB");
						break;
					case 2:
						System.out.println("\n--Top 20 Free Agent WRs--\n");
						theLeague.getFreeAgents(20, "WR");
						break;
					case 3:
						System.out.println("\n--Top 20 Free Agent RBs--\n");
						theLeague.getFreeAgents(20, "RB");
						break;
					case 4:
						System.out.println("\n--Top 20 Free Agent TEs--\n");
						theLeague.getFreeAgents(20, "TE");
						break;
					default:
						break;
					}
				}
			} while (playerChoice < 1);
			
			
			if (theLeague.playerList().get(playerChoice - 1).getIsOwned()) {
				System.out.println("");
				System.out.println(theLeague.playerList().get(playerChoice - 1).playerToString() + " is not available");
			}
		} while (theLeague.playerList().get(playerChoice - 1).getIsOwned());

		Player thePlayer = theLeague.playerList().get(playerChoice - 1);
		thePlayer.setIsOwned();
		theTeam.getRoster().add(thePlayer);
		System.out.println("");
		System.out.println("***" + theTeam.getManagerName() + " has added " + thePlayer.playerToString() + "***");
	}

	/**
	 * Send a message to another team offering to trade players.
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void proposeTrade(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Propose Trade---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			if (!theLeague.getTeam(x).equals(theTeam)) {
				System.out.println("");
				System.out.println("Team number: " + (x + 1));
				theLeague.getTeam(x).teamManNameToString();
			}
		}
		System.out.println("");
		System.out.println("Select a team to view:");
		
		int otherTeamChoice;
		do {
			otherTeamChoice = Input.validInt(1, theLeague.getNumTeams(), keyboard) - 1;
		} while (otherTeamChoice == theLeague.getTeamList().indexOf(theTeam));
		Team otherTeam = theLeague.getTeam(otherTeamChoice);

		System.out.println("");
		System.out.println("---Propose Trade---");
		System.out.println("");
		otherTeam.teamToString();
		System.out.println("");
		System.out.println("Would you like to propose a trade to this team?");
		System.out.println("1 - Yes");
		System.out.println("2 - No, Return to Team Menu");
		
		if (Input.validInt(1, 2, keyboard) == 1) {
			System.out.println("");
			System.out.println("Enter your trade offer (max 64 characters):");
			System.out.println("0 - Return to Team Menu");
			String proposal = Input.validString(32, keyboard);
			if (proposal.equals("0")) {
				return;
			}
			otherTeam.setProposedTrade(theTeam.getManagerName() + ": " + proposal);
			System.out.println("");
			System.out.println("***You have proposed a trade:***");
			System.out.println("To " + otherTeam.getManagerName() + ": " + proposal);
		}
	}

	/**
	 * Respond to a trade that has been offered by another manager.
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void reviewTrade(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Review Proposed Trade---");
		System.out.println(theTeam.getProposedTrade());
		System.out.println("");
		System.out.println("Would you like to accept this trade?");
		System.out.println("1 - Accept");
		System.out.println("2 - Reject");
		System.out.println("0 - Return to Team Menu");

		switch (Input.validInt(0, 2, keyboard)) {
		case 1:
			theLeague.setPendingTrade("Accepted by " + theTeam.getManagerName() + " --- " + theTeam.getProposedTrade());
			theTeam.setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Accepted - The Commissioner Must Process It.***");
			break;
		case 2:
			theTeam.setProposedTrade("");
			System.out.println("");
			System.out.println("***Trade Rejected***");
			break;
		case 0:
			break;
		}
	}

	/**
	 * Change the name of the team.
	 * 
	 * @param theLeague  the league theTeam is in
	 * @param theTeam  the team being managed
	 * @param keyboard  the keyboard
	 */
	public static void editTeamName(League theLeague, Team theTeam, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Edit Team Name---");
		System.out.println("Enter your new team name: (max 32 characters)");
		System.out.println("0 - Return to Team Menu");
		
		String teamName;
		do {
			teamName = Input.validString(32, keyboard);
			if (teamName.equals("0")) {
				return;
			}
			for (int y = 0; y < theLeague.getNumTeams(); y++) {
				if (teamName.equalsIgnoreCase(theLeague.getTeam(y).getTeamName())) {
					System.out.println("That team name is already being used.");
					teamName = "";
				}
			}
		} while (teamName.isEmpty());
		theTeam.setTeamName(teamName);
	}

	/**
	 * Only available to the commissioner - edit scores, edit standings, remove
	 * accepted trades after they are processed.
	 * 
	 * @param theLeague  the league the commissioner is managing
	 * @param keyboard  the keyboard
	 */
	public static void commissionerTools(League theLeague, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Commissioner Tools---");
		System.out.println("1 - Edit Scores");
		System.out.println("2 - Edit Standings");
		System.out.println("3 - Review Accepted Trade");
		System.out.println("0 - Return to Team Menu");

		switch (Input.validInt(0, 3, keyboard)) {
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
		case 0:
			break;
		}
	}

	/**
	 * Only available to the commissioner - edit this week's scores, for all managers to see.
	 * 
	 * @param theLeague  the league the commissioner is managing
	 * @param keyboard  the keyboard
	 */
	public static void editScores(League theLeague, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Edit Scores---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("");
			theLeague.getTeam(x).teamManNameToString();
			System.out.println("Current score: " + theLeague.getTeam(x).getScore());
			System.out.println("");
			System.out.println("Enter a score for " + theLeague.getTeam(x).getTeamName() + ": (max 512)");
			System.out.println("0 - Return to Team Menu");
			
			int newScore = Input.validInt(0, 512, keyboard);
			if (newScore == 0) {
				return;
			}
			theLeague.getTeam(x).setScore(newScore);
		}
		System.out.println("");
		System.out.println("***Scores Updated***");
	}

	/**
	 * Only available to the commissioner - edit the season-long record for each team.
	 * 
	 * @param theLeague  the league the commissioner is managing
	 * @param keyboard  the keyboard
	 */
	public static void editStandings(League theLeague, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Edit Standings---");
		for (int x = 0; x < theLeague.getNumTeams(); x++) {
			System.out.println("");
			theLeague.getTeam(x).teamManNameToString();
			System.out.println("Current record: " + theLeague.getTeam(x).getRecord());
			System.out.println("");
			System.out.println("Enter a new record: (max 32 characters)");
			System.out.println("0 - Return to Team Menu");
			
			String newRecord = Input.validString(32, keyboard);
			if (newRecord.equals("0")) {
				return;
			}
			theLeague.getTeam(x).setRecord(newRecord);
		}
		System.out.println("");
		System.out.println("***Standings Updated***");
	}

	/**
	 * Only available to the commissioner - once the accepted trade has been processed, 
	 * the message alerting the league to the trade can be removed.
	 * 
	 * @param theLeague  the league the commissioner is managing
	 * @param keyboard  the keyboard
	 */
	public static void reviewAcceptedTrade(League theLeague, Scanner keyboard) {
		System.out.println("");
		System.out.println("---Accepted Trade---");
		System.out.println("");
		System.out.println(theLeague.getPendingTrade());
		System.out.println("");
		System.out.println("-Has this trade been processed?-");
		System.out.println("1 - Yes");
		System.out.println("2 - No");

		if (Input.validInt(1, 2, keyboard) == 1) {
			theLeague.setPendingTrade("");
		}
	}
}
