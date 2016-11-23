package player;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerList
{
   public static ArrayList<Player> playerList()
   {
      ArrayList<Player> playList = new ArrayList<Player>();
      int i = 0;
      
      //add players in file playerList.txt to array list
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
         aPlayer.setId(i);
         i++;
         playList.add(aPlayer);
      }
      
      return playList;
   }
}