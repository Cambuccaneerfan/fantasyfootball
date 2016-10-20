import java.util.Scanner;

public class PlayerTest
{
   public static void main (String[] args)
   {
      League theLeague = new League();
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("What is the name of the league?");
      theLeague.setLeagueName(keyboard.nextLine());
      
      System.out.println("Who is managing Team 1?");
      theLeague.getTeam1().setManagerName(keyboard.nextLine());
      System.out.println("What is the name of " + theLeague.getTeam1().getManagerName() + "'s team?");
      theLeague.getTeam1().setTeamName(keyboard.nextLine());
      System.out.println("Who is managing Team 2?");
      theLeague.getTeam2().setManagerName(keyboard.nextLine());
      System.out.println("What is the name of " + theLeague.getTeam2().getManagerName() + "'s team?");
      theLeague.getTeam2().setTeamName(keyboard.nextLine());
      
      System.out.println("");

      System.out.println("All Available players:");
      theLeague.getFreeAgents();
      
      System.out.println("");
      
      System.out.println("Which player did " + theLeague.getTeam1().getManagerName() + " draft? (enter number between 0 and 303)");
      theLeague.getTeam1().setTeamPlayer1(keyboard.nextInt());
      System.out.println("Which player did " + theLeague.getTeam1().getManagerName() + " draft? (enter number between 0 and 303)");
      theLeague.getTeam1().setTeamPlayer2(keyboard.nextInt());
      System.out.println("Which player did " + theLeague.getTeam2().getManagerName() + " draft? (enter number between 0 and 303)");
      theLeague.getTeam2().setTeamPlayer1(keyboard.nextInt());
      System.out.println("Which player did " + theLeague.getTeam2().getManagerName() + " draft? (enter number between 0 and 303)");
      theLeague.getTeam2().setTeamPlayer2(keyboard.nextInt());
	  
      System.out.println("");
      
      System.out.println("Top 10 Free Agents After the Draft:");
      theLeague.getFreeAgents(10);
      
      System.out.println("");
      
      System.out.println(theLeague.getLeagueName());
      
      System.out.println("Team 1");
      System.out.println(theLeague.getTeam1().teamToString());
      
      System.out.println("");
      
      System.out.println("Team 2");
      System.out.println(theLeague.getTeam2().teamToString());
      
      if(keyboard != null) 
      {
    	  keyboard.close();
      }
   }
}
