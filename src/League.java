import java.util.ArrayList;

public class League {
	private String leagueName;
	
	private Team team1;
	private Team team2;
	
	private static ArrayList<Player> playList;
	
	public League()
	{
		leagueName = "";
		
		team1 = new Team();
		team2 = new Team();
		
		playList = PlayerList.playerList();
	}
	
	public String getLeagueName()
	{
		return leagueName;
	}
	
	public Team getTeam1()
	{
		return team1;
	}
	
	public Team getTeam2()
	{
		return team2;
	}
	
	public static ArrayList<Player> playerList()
	{
		return playList;
	}

	public void setLeagueName(String lName)
	{
		leagueName = lName;
	}
	
	public void getFreeAgents()
	{
		for (int x = 0; x < playerList().size(); x++)
	    { 
	    	if (playerList().get(x).getIsOwned() == false)
	    	{
	    		System.out.println(x + " " + playerList().get(x).playerToString());
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
