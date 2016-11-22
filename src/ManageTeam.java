import java.util.Scanner;

public class ManageTeam {

	public static void main(String[] args) {
		Deserializer deserializer = new Deserializer();
		League theLeague = deserializer.deserializeLeague();
		
		Serializer serializer = new Serializer();
		Scanner keyboard = new Scanner(System.in);
		
		for (int x = 0; x < theLeague.getNumTeams(); x++)
	    {
			System.out.println("Team " + (x+1));
	        theLeague.getTeam(x).teamManNameToString();
	        System.out.println("");
	    }
		
		System.out.println("What team number are you managing?");
	      int teamBeingManaged = keyboard.nextInt() - 1;
	      
	      int playerBeingManaged;
	      int choice;
	      
	      do
	      {
	    	  theLeague.getTeam(teamBeingManaged).teamToString();
	            
	    	  do
	    	  {
	    		  System.out.println("You can start/bench a player, add/drop a player, or propose a trade.");
	    		  System.out.println("What player number would you like to edit? Enter 99 to exit");
	    		  playerBeingManaged = keyboard.nextInt();
	    		  
	    		  if (playerBeingManaged == 99)
	    		  {
	    			  System.exit(0);
	    		  }
	    	  } while (theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged) == null);
	      
	    	  System.out.println("");
	    	  System.out.println(theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).playerToString());
	    	  System.out.println("");
	    	  System.out.println("1 Start");
	    	  System.out.println("2 Bench");
	    	  System.out.println("3 Drop");
	    	  System.out.println("4 Trade");
	    	  choice = keyboard.nextInt();
	    	  
	    	  //start
	    	  if (choice == 1)
	    	  {
	    		  if (theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).getPosition().equals("QB"))
	    		  {
	    			  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setStartingQB();
	    		  }
	    		  else if (theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).getPosition().equals("WR"))
	    		  {
	    			  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setStartingWR();
	    		  }
	    		  else if (theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).getPosition().equals("RB"))
	    		  {
	    			  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setStartingRB();
	    		  }
	    		  else if (theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).getPosition().equals("TE"))
	    		  {
	    			  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setStartingTE();
	    		  }
	    		  else
	    		  {
	    			  System.out.println("unknown position");
	    		  }
	    	  }
	    	  //bench
	    	  else if (choice == 2)
	    	  {
	    		  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setBench();
	    	  }
	    	  //drop
	    	  else if (choice == 3)
	    	  {
	    		  theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).setFreeAgent();
	    		  //getting nullpointerexception for next line
	    		  League.playerList().set(theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged).getId(), theLeague.getTeam(teamBeingManaged).getTeamPlayer(playerBeingManaged));
	    		  theLeague.getTeam(teamBeingManaged).getRoster().remove(playerBeingManaged);
	    	  }
	    	  // trade
	    	  else if (choice == 4)
	    	  {
	    		  System.out.println("under construction");
	    	  }
	    	  else
	    	  {
	    		  System.out.println("incorrect entry");
	    	  }
	    	  
	    	  serializer.serializeLeague(theLeague.getLeagueName(), theLeague.getNumTeams(), theLeague.getScoringRules(), theLeague.getTeamList(), League.playerList());
	  		
	    	  
	      } while (choice != 88);
	      
	      if(keyboard != null) 
	      {
	    	  keyboard.close();
	      }

	}

}
