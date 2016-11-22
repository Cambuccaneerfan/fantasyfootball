import java.util.ArrayList;
import java.io.Serializable;

public class League implements Serializable{
	private String leagueName;
	private int numTeams;
	private String scoringRules;
	
	private ArrayList<Team> teamList;
	
	private static ArrayList<Player> playList;
	
	// Commissioner should be able to create a league, and establish the settings for the league. 
    // The commissioner must be able to set the league name, number of teams in the league,
    // scoring rules, maximum players per team, starting players per team, the managers in the league, 
    // and also be able to enter draft results.
	
	public League()
	{
		leagueName = "";
		numTeams = 0;
		scoringRules = "";
		
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
	
	public ArrayList<Team> getTeamList()
	{
		return teamList;
	}
	
	public Team getTeam(int x)
	{
		return teamList.get(x);
	}
	
	public static ArrayList<Player> playerList()
	{
		return playList;
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
	
	public void setTeamList(ArrayList<Team> tList)
	{
		teamList = tList;
	}
	
	public void setPlayerList(ArrayList<Player> pList)
	{
		playList = pList;
	}
	
	public void getFreeAgents()
	{
		for (int x = 0; x < playerList().size(); x++)
	    { 
	    	if (playerList().get(x).getIsOwned() == false)
	    	{
	    		System.out.println(playerList().get(x).getId() + " " + playerList().get(x).playerToString());
	    	}
	    }
	}
	
	public void getFreeAgents(int numToShow)
	{
		int y = 0;
		for (int x = 0; x < numToShow; x++)
	    { 
			while (League.playerList().get(y).getIsOwned() == true)
	        {
				y++;
	        }
	    	 
	    	if (League.playerList().get(y).getIsOwned() == false)
	    	{
	    		System.out.println(y + " " + League.playerList().get(y).playerToString());
	    		y++;
	    	}
	    }
	}
}
