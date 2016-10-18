import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
      playerList().get(x).setIsOwned();
      startingQB = playerList().get(x);
   }
   
   public Player getPlayer(int y)
   {
      return playerList().get(y);
   }
   
   
   public String teamToString()
   {
      return startingQB.playerToString();
   }
   
   public static final ArrayList<Player> playerList()
   {
      ArrayList<Player> playList = new ArrayList<Player>();
      
      Scanner playerScan = null;

      try
      {
         playerScan = new Scanner(new FileInputStream("playerList.txt"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("playerList.txt not found.");
         System.exit(0);
      }
      
      while (playerScan.hasNext())
      {
         Player aPlayer = new Player();
    	 
         aPlayer.setPosition(playerScan.next());
    	   aPlayer.setFreeAgent();
    	  
         if (playerScan.hasNext())
         {
        	 aPlayer.setFirstName(playerScan.next());
         }
         if (playerScan.hasNext())
         {
        	 aPlayer.setLastName(playerScan.next());
         }
         if (playerScan.hasNext())
         {
        	 aPlayer.setNflTeam(playerScan.next());
         }
         
         playList.add(aPlayer); //add names in file to array list
      }
      
      return playList;
   }
}