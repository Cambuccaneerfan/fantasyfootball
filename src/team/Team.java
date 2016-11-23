package team;
import java.util.ArrayList;

import player.Player;

import java.io.Serializable;

public class Team implements Serializable
{
   private String managerName;
   private String teamName;
   
   private String proposedTrade;
   private String pendingTrade;

   private ArrayList<Player> roster;
   
   public static final long serialVersionUID = 1L;
   
   // Commissioner should be able to create a league, and establish the settings for the league. 
   // The commissioner must be able to set the league name, number of teams in the league,
   // scoring rules, maximum players per team, starting players per team, the managers in the league, 
   // and also be able to enter draft results.
   
   public Team()
   {
	  managerName = "";
	  teamName = "";
	  
	  proposedTrade = "";
	  pendingTrade = "";
	  
	  roster = new ArrayList<Player>();
   }
   
   public String getManagerName()
   {
      return managerName;
   }
   
   public String getTeamName()
   {
      return teamName;
   }
   
   public String getProposedTrade()
   {
      return proposedTrade;
   }
   
   public String getPendingTrade()
   {
      return pendingTrade;
   }
   
   public ArrayList<Player> getRoster()
   {
      return roster;
   }
   
   public Player getTeamPlayer(int x)
	{
		return roster.get(x);
	}
   
   public void setManagerName(String mName)
   {
      managerName = mName;
   }
   
   public void setTeamName(String tName)
   {
      teamName = tName;
   }
   
   public void setProposedTrade(String trade)
   {
      proposedTrade = trade;
   }
   
   public void setPendingTrade(String trade)
   {
      pendingTrade = trade;
   }
   
   public void teamToString()
   {
	   System.out.println("Manager: " + managerName + "\n" + "Team: " + teamName);
	   for (int x = 0; x < roster.size(); x++)
  	   {
		   System.out.println(x + " " + roster.get(x).startingIndicator() + " " + roster.get(x).playerToString());
  	   }
   }
   
   public void teamManNameToString()
   {
	   System.out.println("Manager: " + managerName + "\n" + "Team: " + teamName);
   }
}
