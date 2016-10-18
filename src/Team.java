import java.util.ArrayList;

public class Team
{
   private Player startingQB;
   
   public Team()
   {
      startingQB = new Player();
   }
   
   public Team(Player QB)
   {
      startingQB = QB;
   }
   
   public Team(Team aTeam)
   {
      if (aTeam == null)
         {
            System.out.println("Fatal Error.");
            System.exit(0);
         }

         startingQB = aTeam.startingQB;
   }
   
   public Player getStartingQB()
   {
      return startingQB;
   }
   
   public void setStartingQB(Player QB)
   {
      QB.setIsOwned();
      startingQB = QB;
   }
   
   public void setStartingQB(int x)
   {
      PlayerList.playerList().get(x).setIsOwned();
      startingQB = PlayerList.playerList().get(x);
   }
   
   public Player getPlayer(int y)
   {
      return PlayerList.playerList().get(y);
   }
   
   
   public String teamToString()
   {
      return startingQB.playerToString();
   }
}
