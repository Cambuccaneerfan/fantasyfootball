import java.util.ArrayList;

public class Team
{
   private String managerName;
   private String teamName;

   private ArrayList<Player> roster;
   
   private static int numQB;
   private static int numWR;
   private static int numRB;
   private static int numTE;
   private static int numBench;
   
   // Commissioner should be able to create a league, and establish the settings for the league. 
   // The commissioner must be able to set the league name, number of teams in the league,
   // scoring rules, maximum players per team, starting players per team, the managers in the league, 
   // and also be able to enter draft results.
   
   public Team()
   {
	  managerName = "";
	  teamName = "";
	  
	  roster = new ArrayList<Player>();
      
      numQB = 0;
      numWR = 0;
      numRB = 0;
      numTE = 0;
      numBench = 0;
   }
   
   public String getManagerName()
   {
      return managerName;
   }
   
   public String getTeamName()
   {
      return teamName;
   }
   
   public ArrayList<Player> getRoster()
   {
      return roster;
   }
   
   public static int getNumQB()
   {
      return numQB;
   }
   
   public static int getNumWR()
   {
      return numWR;
   }
   
   public static int getNumRB()
   {
      return numRB;
   }
   
   public static int getNumTE()
   {
      return numTE;
   }
   
   public static int getNumBench()
   {
      return numBench;
   }
   
   public static int getMaxPlayers()
   {
      return numQB + numWR + numRB + numTE + numBench;
   }
   
   public void setManagerName(String mName)
   {
      managerName = mName;
   }
   
   public void setTeamName(String tName)
   {
      teamName = tName;
   }
   
   public void setTeamPlayer(int x, int y)
   {
      roster.set(x, League.playerList().get(y));
      roster.get(x).setIsOwned();
      League.playerList().set(y, roster.get(x));
   }
   
   public static void setNumQB(int x)
   {
      numQB = x;
   }
   
   public static void setNumWR(int x)
   {
      numWR = x;
   }
   
   public static void setNumRB(int x)
   {
      numRB = x;
   }
   
   public static void setNumTE(int x)
   {
      numTE = x;
   }
   
   public static void setNumBench(int x)
   {
      numBench = x;
   }
   
   public void teamToString()
   {
	   System.out.println("Manager: " + managerName + "\n" + "Team: " + teamName);
	   for (int x = 0; x < getMaxPlayers(); x++)
  	   {
		   System.out.println(roster.get(x).playerToString());
  	   }
   }
}
