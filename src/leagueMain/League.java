package leagueMain;
import java.util.ArrayList;

import player.Player;
import player.PlayerList;
import team.Team;

import java.io.Serializable;

public class League implements Serializable{
	private String leagueName;
	private int numTeams;
	private String scoringRules;
	   
	private int numQB;
	private int numWR;
	private int numRB;
	private int numTE;
	private int numBench;
	
	private ArrayList<Team> teamList;
	
	private ArrayList<Player> playList;
	
	public static final long serialVersionUID = 1L;
	
	// Commissioner should be able to create a league, and establish the settings for the league. 
    // The commissioner must be able to set the league name, number of teams in the league,
    // scoring rules, maximum players per team, starting players per team, the managers in the league, 
    // and also be able to enter draft results.
	
	public League()
	{
		leagueName = "";
		numTeams = 0;
		scoringRules = "";
		
		numQB = 0;
	    numWR = 0;
	    numRB = 0;
	    numTE = 0;
	    numBench = 0;
		
		teamList = new ArrayList<Team>();
		
		playList = PlayerList.playerList();
	}
	
	public String getLeagueName()
	{
		return leagueName;
	}
	
	public int getNumTeams()
	{
		return numTeams;
	}
	
	public String getScoringRules()
	{
		return scoringRules;
	}
	   
	public int getNumQB()
	{
	   return numQB;
	}
	   
	public int getNumWR()
	{
	   return numWR;
	}
	   
	public int getNumRB()
	{
	   return numRB;
	}
	   
	public int getNumTE()
	{
	   return numTE;
	}
	   
	public int getNumBench()
	{
	   return numBench;
	}
	   
	public int getMaxPlayers()
	{
	   return numQB + numWR + numRB + numTE + numBench;
	}
	
	public ArrayList<Team> getTeamList()
	{
		return teamList;
	}
	
	public Team getTeam(int x)
	{
		return teamList.get(x);
	}
	
	public ArrayList<Player> playerList()
	{
		return playList;
	}
	
	public Player getPlayer(int x)
	{
		return playList.get(x);
	}

	public void setLeagueName(String lName)
	{
		leagueName = lName;
	}
	
	public void setNumTeams(int x)
	{
		numTeams = x;
	}
	
	public void setScoringRules(String rules)
	{
		scoringRules = rules;
	}
	   
	public void setNumQB(int x)
	{
	   numQB = x;
	}
	  
	public void setNumWR(int x)
	{
	   numWR = x;
	}
	
	public void setNumRB(int x)
	{
	   numRB = x;
	}
	   
	public void setNumTE(int x)
	{
	   numTE = x;
	}
	   
	public void setNumBench(int x)
	{
	   numBench = x;
	}
	
	public void setTeamList(ArrayList<Team> tList)
	{
		teamList = tList;
	}
	
	public void setPlayerList(ArrayList<Player> pList)
	{
		playList = pList;
	}
	
	public void setTeamPlayer(int teamNum, int rosterSpot, int playerListSpot)
	   {
		  getTeam(teamNum).getRoster().set(rosterSpot, playerList().get(playerListSpot));
		  getTeam(teamNum).getRoster().get(rosterSpot).setIsOwned();
	      playerList().set(playerListSpot, getTeam(teamNum).getRoster().get(rosterSpot));
	   }
	
	public void getFreeAgents()
	{
		for (int x = 0; x < playerList().size(); x++)
	    { 
	    	if (playerList().get(x).getIsOwned() == false)
	    	{
	    		System.out.println((playerList().get(x).getId() + 1) + " - " + playerList().get(x).playerToString());
	    	}
	    }
	}
	
	public void getFreeAgents(int numToShow)
	{
		int y = 0;
		for (int x = 0; x < numToShow; x++)
	    { 
			while (playerList().get(y).getIsOwned() == true)
	        {
				y++;
	        }
	    	 
	    	if (playerList().get(y).getIsOwned() == false)
	    	{
	    		System.out.println((y+1) + " " + playerList().get(y).playerToString());
	    		y++;
	    	}
	    }
	}
}
