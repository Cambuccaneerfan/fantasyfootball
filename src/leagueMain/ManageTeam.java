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
		
		System.out.println("League name: " + theLeague.getLeagueName());
	    System.out.println("");
		
		for (int x = 0; x < theLeague.getNumTeams(); x++)
	    {
			System.out.println("Team number: " + (x));
	        theLeague.getTeam(x).teamManNameToString();
	        System.out.println("");
	    }
		
		System.out.println("What team number are you managing?");
	      int teamChoice = keyboard.nextInt();
	      
	      int choice;
	      
	      do
	      {
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
	    	  System.out.println("6 - View Accepted Trade");
	    	  System.out.println("7 - Change Team Name");
	    	  System.out.println("8 - Exit to Main Menu");
	    	  choice = keyboard.nextInt();
	    	  
	    	  switch (choice) {
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
	    		  System.out.println(theLeague.getTeam(teamChoice).getPendingTrade());
	    		  break;
	    	  case 7:
	    		  ManageTeamOps.editTeamName(theLeague, teamChoice);
	    		  break;
	    	  case 8:
	    		  FirstPage.main(args);
	    		  break;
	    	  default: 
	    		  break;
	    	  }
	    	  
	    	  serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(), 
					  theLeague.getNumQB(), theLeague.getNumWR(), theLeague.getNumRB(), theLeague.getNumTE(), 
					  theLeague.getNumBench(), theLeague.getTeamList(), theLeague.playerList());
	    	  
	      } while (choice != 88);
	      
	      if(keyboard != null) 
	      {
	    	  keyboard.close();
	      }
	}
}