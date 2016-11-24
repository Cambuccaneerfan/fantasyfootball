package leagueMain;
import java.util.Scanner;

import player.Player;
import team.Team;
import utilities.Serializer;

public class CreateLeague {

	public static void main(String[] args) {
		League theLeague = new League();
	      
	      Scanner keyboard = new Scanner(System.in);
	      
	      // Commissioner should be able to create a league, and establish the settings for the league. 
	      // The commissioner must be able to (1) set the league name, (2) number of teams in the league,
	      // (3) scoring rules, (4) maximum players per team, (4) starting players per team,  
	      // (5) the managers in the league, and also be able to (6) enter draft results. 
	      
	      System.out.println("");
	      
	      // (1) set the league name
	      while (theLeague.getLeagueName().isEmpty() || theLeague.getLeagueName().length() > 32)
	      {
	    	  System.out.println("What is the name of the league? (max 32 characters)");
	    	  theLeague.setLeagueName(keyboard.nextLine());
	      }
	      
	      // (2) number of teams in the league
	      while (theLeague.getNumTeams() < 2 || theLeague.getNumTeams() > 8)
	      {
	    	  System.out.println("How many teams are in the league? (2-8)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many teams are in the league? (2-8)");
	    	  }
	    	  theLeague.setNumTeams(keyboard.nextInt());
	      }
	      //create teams
	      for (int x = 0; x < theLeague.getNumTeams(); x++)
	      {
	    	  Team aTeam = new Team();
	    	  theLeague.getTeamList().add(aTeam);
	      }
	      keyboard.nextLine();
	      
	      // (3) scoring rules
	      int scoringChoice;
	      while (theLeague.getScoringRules().isEmpty())
	      {
	    	  do {
	    		  System.out.println("What are the scoring rules of the league?");
	    		  System.out.println("1 - Standard");
	    		  System.out.println("2 - Point-Per-Reception");
	    		  System.out.println("3 - Custom");
	    		  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    		  {
	    			  keyboard.next();
	    			  System.out.println("How many starting QBs will each team use? (0-2)");
	    		  }
	    		  scoringChoice = keyboard.nextInt();
	    	  } while (scoringChoice < 1 || scoringChoice > 3);
	    	  
	    	  if (scoringChoice == 1)
	    	  {
	    		  theLeague.setScoringRules("Standard");
	    	  }
	    	  if (scoringChoice == 2)
	    	  {
	    		  theLeague.setScoringRules("Point-Per-Reception");
	    	  }
	    	  if (scoringChoice == 3)
	    	  {
	    		  keyboard.nextLine();
	    		  while (theLeague.getScoringRules().isEmpty() || theLeague.getScoringRules().length() > 128)
	    	      {
	    			  System.out.println("Enter your custom scoring rules (max 128 characters)");
	    	    	  theLeague.setScoringRules(keyboard.nextLine());
	    	      }
	    	  }
	      }
	      
	      // (4) maximum players per team, (4) starting players per team... max = starting + bench
	      do {
	    	  System.out.println("How many starting QBs will each team use? (0-2)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many starting QBs will each team use? (0-2)");
	    	  }
	    	  theLeague.setNumQB(keyboard.nextInt());
	      } while (theLeague.getNumQB() < 0 || theLeague.getNumQB() > 2);
	      do {
	    	  System.out.println("How many starting WRs will each team use? (0-4)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many starting WRs will each team use? (0-4)");
	    	  }
	    	  theLeague.setNumWR(keyboard.nextInt());
	      } while (theLeague.getNumWR() < 0 || theLeague.getNumWR() > 4);
	      do {
	    	  System.out.println("How many starting RBs will each team use? (0-4)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many starting RBs will each team use? (0-4)");
	    	  }
	    	  theLeague.setNumRB(keyboard.nextInt());
	      } while (theLeague.getNumRB() < 0 || theLeague.getNumRB() > 4);
	      do {
	    	  System.out.println("How many starting TEs will each team use? (0-2)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many starting TEs will each team use? (0-2)");
	    	  }
	    	  theLeague.setNumTE(keyboard.nextInt());
	      } while (theLeague.getNumTE() < 0 || theLeague.getNumTE() > 2);
	      do {
	    	  System.out.println("How many bench players will each team have? (0-8)");
	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	  {
	    		  keyboard.next();
	    		  System.out.println("How many starting RBs will each team use? (0-8)");
	    	  }
	    	  theLeague.setNumBench(keyboard.nextInt());
	      } while (theLeague.getNumBench() < 0 || theLeague.getNumBench() > 8);
	      keyboard.nextLine();
	      
	      // create roster spots (empty Players)
	      for (int x = 0; x < theLeague.getNumTeams(); x++)
	      {
	    	  Player aPlayer = new Player();
	    	  for (int y = 0; y < theLeague.getMaxPlayers(); y++)
	    	  {
	        	  theLeague.getTeam(x).getRoster().add(aPlayer);
	    	  }
	      }
	      
	      // (5) the managers in the league... set team names as well
	      for (int x = 0; x < theLeague.getNumTeams(); x++)
	      {
	    	  while (theLeague.getTeam(x).getManagerName().isEmpty() || theLeague.getTeam(x).getManagerName().length() > 32)
	    	  {
	    		  if (x == 0)
	    		  {
	    			  System.out.println("As the creator of the League, you will manage Team Number " + (x+1) + ", ");
	    			  System.out.println("and act as Commissioner. What is your name? (max 32 characters)");
		    		  theLeague.getTeam(x).setManagerName(keyboard.nextLine());
	    		  }
	    		  else
	    		  {
	    			  System.out.println("Who is managing Team Number " + (x+1) + "? (max 32 characters)");
	    			  theLeague.getTeam(x).setManagerName(keyboard.nextLine());
	    		  }
	    	  }
	    	  while (theLeague.getTeam(x).getTeamName().isEmpty() || theLeague.getTeam(x).getTeamName().length() > 32)
	    	  {
	    		  System.out.println("What is the name of " + theLeague.getTeam(x).getManagerName() + "'s team? (max 32 characters)");
	          	  theLeague.getTeam(x).setTeamName(keyboard.nextLine());
	    	  }
	      }
	      
	      // (6) enter draft results 
		  int draftChoice = -1;
	      for (int x = 0; x < theLeague.getMaxPlayers(); x++)
	      {
	    	  for (int y = 0; y < theLeague.getNumTeams(); y++)
	          {
	    		  do {
	    			  if (draftChoice == -1)
	    			  {
	    				  System.out.println("");

	    			      System.out.println("All Available players:");
	    			      theLeague.getFreeAgents();
	    			      
	    			      System.out.println("");
	    			  }
	    			  if (draftChoice == -2)
	    			  {
	    				  System.out.println("");

	    			      System.out.println("Top 20 Available players:");
	    			      theLeague.getFreeAgents(20);
	    			      
	    			      System.out.println("");
	    			  }
	    			  
	    			  System.out.println("Which player did " + theLeague.getTeam(y).getManagerName() + 
		    				  " draft? (enter number between 1 and " + (theLeague.playerList().size()) + ")");
	    			  System.out.println("Enter -1 to view all available players");
	    			  System.out.println("Enter -2 to view the top 20 available players");
	    	    	  while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
	    	    	  {
	    	    		  keyboard.next();
	    	    		  System.out.println("Which player did " + theLeague.getTeam(y).getManagerName() + 
	    	    				  " draft? (enter number between 1 and " + (theLeague.playerList().size()) + ")");
	    	    		  System.out.println("Enter -1 to view all available players");
		    			  System.out.println("Enter -2 to view the top 20 available players");
	    	    	  }
	    	    	  draftChoice = keyboard.nextInt();

	    			  if (draftChoice >= 1 && draftChoice <= theLeague.playerList().size())
	    			  {
	    				  if (theLeague.getPlayer(draftChoice-1).getIsOwned())
		    			  {
		    				  System.out.println(theLeague.getPlayer(draftChoice-1).playerToString() + " has already been drafted");
		    			  }
	    				  else
	    				  {
	    					  System.out.println(theLeague.getTeam(y).getManagerName() + " has selected " + 
	    							  theLeague.getPlayer(draftChoice-1).playerToString());
	    				  }
	    			  }
	    	      } while (draftChoice < 1 || draftChoice > theLeague.playerList().size() || 
	    	    		  theLeague.getPlayer(draftChoice-1).getIsOwned());
	    		  
	    		  draftChoice -= 1;	    		  
	    	      theLeague.setTeamPlayer(y, x, draftChoice);
	          }
	      }
	      
	      System.out.println("");
	      System.out.println("////////////////////////////////");
	      System.out.println("");
	      
	      System.out.println("League name: " + theLeague.getLeagueName());
	      System.out.println("");
	      
	      for (int x = 0; x < theLeague.getNumTeams(); x++)
	      {
	    	  System.out.println("Team Number: " + (x+1));
	          theLeague.getTeam(x).teamToString();
	          System.out.println("");
	      }
	      
	      Serializer serializer = new Serializer();
		  serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(), 
				  theLeague.getNumQB(), theLeague.getNumWR(), theLeague.getNumRB(), theLeague.getNumTE(), 
				  theLeague.getNumBench(), theLeague.getTeamList(), theLeague.playerList());
	      
		  System.out.println("");
		  FirstPage.main(args);
		  
	      if(keyboard != null) 
		  {
	    	  keyboard.close();
		  }

	}

}
