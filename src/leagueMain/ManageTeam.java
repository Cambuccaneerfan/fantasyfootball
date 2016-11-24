package leagueMain;

import java.util.Scanner;

import utilities.Deserializer;
import utilities.Serializer;

public class ManageTeam {

	public static void main(String[] args) {
		Deserializer deserializer = new Deserializer();
		League theLeague = deserializer.deserializeLeague();
		
		Serializer serializer = new Serializer();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("---Continue League---");
		System.out.println("");
		System.out.println("League name: " + theLeague.getLeagueName());
	    System.out.println("");
		
		for (int x = 0; x < theLeague.getNumTeams(); x++)
	    {
			System.out.println("Team number: " + (x+1));
	        theLeague.getTeam(x).teamManNameToString();
	        System.out.println("");
	    }
		
		int teamChoice;
		do {
			System.out.println("What team number are you managing?");
	    	while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	{
	    		keyboard.next();
	    		System.out.println("What team number are you managing?");
	    	}
	    	teamChoice = keyboard.nextInt();
	    } while (teamChoice < 1 || teamChoice > theLeague.getNumTeams());
	    teamChoice -= 1;  
		
	    int menuChoice;
	    do {
	    	do{
	    		System.out.println("");
	    		System.out.println("---Team Management---");
	    		theLeague.getTeam(teamChoice).teamToString();
	    	  
	    		if (!theLeague.getTeam(teamChoice).getPendingTrade().isEmpty())
	    		{
	    			System.out.println("");
	    			System.out.println("***A trade has been accepted.***");
	    		}
	    	  
	    		if (!theLeague.getTeam(teamChoice).getProposedTrade().isEmpty())
	    		{
	    			System.out.println("");
	    			System.out.println("***There has been a trade proposed to you.***");
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
	    		while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
		    	{
		    		keyboard.next();
		    		System.out.println("");
		    		System.out.println("Please enter a valid menu option.");
		    	}
	    		menuChoice = keyboard.nextInt();
	    		if (menuChoice < 0 || menuChoice > 9)
	    		{
	    			System.out.println("");
	    			System.out.println("Please enter a valid menu option.");
	    		}
	    	} while (menuChoice < 0 || menuChoice > 9);
	    	  
	    	switch (menuChoice) {
	    	case 1:
	    		ManageTeamOps.editLineup(theLeague, teamChoice);
	    		break;
	    	case 2:
	    		ManageTeamOps.dropPlayer(theLeague, teamChoice);
	    		break;
	    	case 3:
	    		ManageTeamOps.addPlayer(theLeague, teamChoice);
	    		break;
	    	case 4:
	    		ManageTeamOps.proposeTrade(theLeague, teamChoice);
	    		break;
	    	case 5:
	    		ManageTeamOps.reviewTrade(theLeague, teamChoice);
	    		break;
	    	case 6:
	    		ManageTeamOps.editTeamName(theLeague, teamChoice);
	    		break;
	    	case 7:
	    		ManageTeamOps.viewSettings(theLeague);
	    		break;
	    	case 8:
	    		ManageTeamOps.viewStandings(theLeague);
	    		break;
	    	case 9:
	    		if (teamChoice == 0)
	    		{
	    			ManageTeamOps.commissionerTools(theLeague);
	    		}
	    		else
	    		{
	    			System.out.println("");
	    			System.out.println("You must be the commissioner to access Commissioner Tools");
	    		}
	    		break;
	    	case 0:
	    		FirstPage.main(args);
	    		break;
	    	default: 
	    		break;
	    	}
	    	  
	    	serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(), 
	    			theLeague.getNumQB(), theLeague.getNumWR(), theLeague.getNumRB(), theLeague.getNumTE(), 
					theLeague.getNumBench(), theLeague.getTeamList(), theLeague.playerList());
	    } while (menuChoice != 0);
	      
	    if(keyboard != null) 
	    {
	    	keyboard.close();
	    }
	}
}