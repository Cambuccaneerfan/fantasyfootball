package leagueMain;

import java.util.Scanner;

public class ManageTeamOps {
	public static void editLineup (League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		int playerChoice;
		
		theLeague.getTeam(teamChoice).teamToString();
		
		do {
			System.out.println("Selecting a player will move them from the bench to starting or vice versa");
  		  	System.out.println("");
  		  	System.out.println("What player number would you like to start/bench?");
  		  	playerChoice = keyboard.nextInt();
  	  	} while (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice) == null);
		
		if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).startingIndicator().equals("BENCH"))
		{
			if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("QB"))
			{
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingQB();
			}
			else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("WR"))
			{
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingWR();
			}
			else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("RB"))
			{
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingRB();
			}
			else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getPosition().equals("TE"))
			{
				theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setStartingTE();
			}
			else
			{
				System.out.println("unknown position");
			}
		}
		else if (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).startingIndicator().equals("STARTING"))
		{
			theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setBench();
		}
	}
	
	public static void dropPlayer (League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		int playerChoice;
		
		theLeague.getTeam(teamChoice).teamToString();
		
		do {
  		  	System.out.println("What player number would you like to drop?");
  		  	playerChoice = keyboard.nextInt();
  	  	} while (theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice) == null);
		
		theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setFreeAgent();
		theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).setBench();
		theLeague.playerList().set(theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice).getId(), theLeague.getTeam(teamChoice).getTeamPlayer(playerChoice));
		theLeague.getTeam(teamChoice).getRoster().remove(playerChoice);
	}
	
	public static void addPlayer (League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		
		if (theLeague.getTeam(teamChoice).getRoster().size() >= theLeague.getMaxPlayers())
		{
			System.out.println("");
			System.out.println("***Your team is full. You must drop a player before adding one.***");
			System.out.println("");
			return;
		}
		
		System.out.println("All Available players:");
	    theLeague.getFreeAgents();
	    System.out.println("");
	    
	    System.out.println("Which player would you like to add? (enter number between 0 and " + 
	    		(theLeague.playerList().size()-1) + ")");
	    theLeague.getTeam(teamChoice).getRoster().add(theLeague.getTeam(teamChoice).getRoster().size(), theLeague.getPlayer(keyboard.nextInt()));
	    // theLeague.setTeamPlayer(teamChoice, theLeague.getTeam(teamChoice).getRoster().size(), keyboard.nextInt());
	}
	
	public static void proposeTrade (League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		int teamToView;
		String decision;
		String proposal;
		
		for (int x = 0; x < theLeague.getNumTeams(); x++)
		{
			if (x != teamChoice)
			{
				System.out.println("Team number: " + (x));
		        theLeague.getTeam(x).teamManNameToString();
		        System.out.println("");
			}
		}
		
		do{
			System.out.println("What team number would you like to view?");
			teamToView = keyboard.nextInt();
		} while (teamToView < 0 || teamToView == teamChoice || teamToView > theLeague.getNumTeams() - 1);
		
		theLeague.getTeam(teamToView).teamToString();
		
		do{
			keyboard.nextLine();
			System.out.println("");
			System.out.println("Would you like to propose a trade to this team? (y/n)");
			decision = keyboard.nextLine();
			
			if (decision.equalsIgnoreCase("y"))
			{
				System.out.println("Enter your trade offer");
				proposal = theLeague.getTeam(teamChoice).getManagerName() + ": " + keyboard.nextLine();
				theLeague.getTeam(teamToView).setProposedTrade(proposal);
				return;
			}
		} while (!decision.equalsIgnoreCase("n"));
	}
	
	public static void reviewTrade (League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		int decision;
		
		System.out.println(theLeague.getTeam(teamChoice).getProposedTrade());
		System.out.println("");
		System.out.println("Would you like to accept this trade?");
		System.out.println("1 - Accept");
		System.out.println("2 - Reject");
		System.out.println("3 - Exit");
		decision = keyboard.nextInt();
		
		switch (decision) {
		case 1:
			theLeague.getTeam(0).setPendingTrade("Accepted by " + theLeague.getTeam(teamChoice).getManagerName() + ": " +
					theLeague.getTeam(teamChoice).getProposedTrade());
			theLeague.getTeam(teamChoice).setProposedTrade("");
			System.out.println("Trade Accepted - The Commissioner Must Process It.");
			System.out.println("");
			break;
		case 2:
			theLeague.getTeam(teamChoice).setProposedTrade("");
			System.out.println("Trade Rejected");
			System.out.println("");
			break;
		case 3:
			break;
		default:
			break;
		}
	}
	
	public static void editTeamName(League theLeague, int teamChoice)
	{
		Scanner keyboard = new Scanner(System.in);
		String newTeamName;
		
		System.out.println("Enter your new team name:");
		newTeamName = keyboard.nextLine();
		
		theLeague.getTeam(teamChoice).setTeamName(newTeamName);
		
	}
}
