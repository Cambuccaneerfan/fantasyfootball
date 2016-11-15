import java.util.Scanner;

public class PlayerTest
{
   public static void main (String[] args)
   {
      League theLeague = new League();
      
      Scanner keyboard = new Scanner(System.in);
      
      // Commissioner should be able to create a league, and establish the settings for the league. 
      // The commissioner must be able to (1) set the league name, (2) number of teams in the league,
      // (3) scoring rules, (4) maximum players per team, (4) starting players per team,  
      // (5) the managers in the league, and also be able to (6) enter draft results. 
      
      // (1) set the league name
      System.out.println("What is the name of the league?");
      theLeague.setLeagueName(keyboard.nextLine());
      // (3) scoring rules
      System.out.println("What are the scoring rules of the league?");
      theLeague.setScoringRules(keyboard.nextLine());
      // (2) number of teams in the league
      System.out.println("How many teams in the league?");
      theLeague.setNumTeams(keyboard.nextInt());
      
      for (int x = 0; x < theLeague.getNumTeams(); x++)
      {
    	  Team aTeam = new Team();
    	  theLeague.getTeamList().add(aTeam);
      }
      
      // (4) maximum players per team, (4) starting players per team... max = starting + bench
      System.out.println("How many starting QBs will each team use?");
      Team.setNumQB(keyboard.nextInt());
      System.out.println("How many starting WRs will each team use?");
      Team.setNumWR(keyboard.nextInt());
      System.out.println("How many starting RBs will each team use?");
      Team.setNumRB(keyboard.nextInt());
      System.out.println("How many starting TEs will each team use?");
      Team.setNumTE(keyboard.nextInt());
      System.out.println("How many bench players will each team have?");
      Team.setNumBench(keyboard.nextInt());
      
      keyboard.nextLine();
      
      for (int x = 0; x < theLeague.getNumTeams(); x++)
      {
    	  Player aPlayer = new Player();
    	  for (int y = 0; y < Team.getMaxPlayers(); y++)
    	  {
        	  theLeague.getTeam(x).getRoster().add(aPlayer);
    	  }
      }
      
      // (5) the managers in the league... set team names as well
      for (int x = 0; x < theLeague.getNumTeams(); x++)
      {
    	  System.out.println("Who is managing Team " + (x+1) + "?");
    	  theLeague.getTeam(x).setManagerName(keyboard.nextLine());
    	  System.out.println("What is the name of " + theLeague.getTeam(x).getManagerName() + "'s team?");
          theLeague.getTeam(x).setTeamName(keyboard.nextLine());
      }
      
      System.out.println("");

      System.out.println("All Available players:");
      theLeague.getFreeAgents();
      
      System.out.println("");
      
      // (6) enter draft results      
      for (int x = 0; x < Team.getMaxPlayers(); x++)
      {
    	  for (int y = 0; y < theLeague.getNumTeams(); y++)
          {
    		  System.out.println("Which player did " + theLeague.getTeam(y).getManagerName() + " draft? (enter number between 0 and 303)");
    	      theLeague.getTeam(y).setTeamPlayer(x, keyboard.nextInt());
          }
      }
      
      System.out.println("");
      
      System.out.println("Top 10 Free Agents After the Draft:");
      theLeague.getFreeAgents(10);
      
      System.out.println("");
      System.out.println("////////////////////////////////");
      System.out.println("");
      
      System.out.println("League name: " + theLeague.getLeagueName());
      System.out.println("");
      
      for (int x = 0; x < theLeague.getNumTeams(); x++)
      {
    	  System.out.println("Team " + (x+1));
          theLeague.getTeam(x).teamToString();
          System.out.println("");
      }
      
      if(keyboard != null) 
      {
    	  keyboard.close();
      }
   }
}
