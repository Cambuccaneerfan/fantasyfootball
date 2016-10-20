public class Team
{
   private String managerName;
   private String teamName;
	
   private Player teamPlayer1;
   private Player teamPlayer2;
   
   public Team()
   {
	  managerName = "";
	  teamName = "";
	  teamPlayer1 = new Player();
      teamPlayer2 = new Player();
   }
   
   public String getManagerName()
   {
      return managerName;
   }
   
   public String getTeamName()
   {
      return teamName;
   }
   
   public Player getTeamPlayer1()
   {
      return teamPlayer1;
   }
   
   public Player getTeamPlayer2()
   {
      return teamPlayer2;
   }
   
   public void setManagerName(String mName)
   {
      managerName = mName;
   }
   
   public void setTeamName(String tName)
   {
      teamName = tName;
   }
   
   public void setTeamPlayer1(Player p1)
   {
	   teamPlayer1 = p1;
	   p1.setIsOwned();
   }
   
   public void setTeamPlayer2(Player p2)
   {
	   teamPlayer2 = p2;
	   p2.setIsOwned();
   }
   
   public void setTeamPlayer1(int x)
   {
      teamPlayer1 = League.playerList().get(x);
      teamPlayer1.setIsOwned();
      League.playerList().set(x, teamPlayer1);
   }
   
   public void setTeamPlayer2(int x)
   {
      teamPlayer2 = League.playerList().get(x);
      teamPlayer2.setIsOwned();
      League.playerList().set(x, teamPlayer2);
   }
   
   public Player getPlayer(int y)
   {
      return League.playerList().get(y);
   }
   
   
   public String teamToString()
   {
      return "Manager: " + managerName + "\n" + "Team: " + teamName + "\n" + teamPlayer1.playerToString() + "\n" + teamPlayer2.playerToString();
   }
}
