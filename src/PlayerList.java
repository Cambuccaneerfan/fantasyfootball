public class PlayerList
{
   public static final ArrayList<Player> playerList()
   {
      ArrayList<Player> playList = new ArrayList<Player>();
      
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
         
         playList.add(aPlayer);
      }
      
      return playList;
   }
   
   /*
   public static Player player1;
   public static Player player2;
   public static Player player3;
   public static Player player4;
   public static Player player5;
   
   
   
   
   
   public static void main (String[] args)
   {
      player1 = new Player("WR", "Antonio", "Brown", "PIT", false);
      player2 = new Player("RB", "David", "Johnson", "ARI", false);
      player3 = new Player("WR", "Julio", "Jones", "ATL", false);
      player4 = new Player("RB", "Todd", "Gurley", "LAR", false);
      player5 = new Player("RB", "Ezekiel", "Elliot", "DAL", false);
      
      System.out.println(player1.playerToString());
      System.out.println(player2.playerToString());
      System.out.println(player3.playerToString());
      System.out.println(player4.playerToString());
      System.out.println(player5.playerToString());
   }
}
   
  
   
   public PlayerList()
   {
      player1 = new Player("WR", "Antonio", "Brown", "PIT", false);
      player2 = new Player("RB", "David", "Johnson", "ARI", false);
      player3 = new Player("WR", "Julio", "Jones", "ATL", false);
      player4 = new Player("RB", "Todd", "Gurley", "LAR", false);
      player5 = new Player("RB", "Ezekiel", "Elliot", "DAL", false);
   }
   
   
   public class PlayerList
{
   public static void main (String[] args)
   {
      Player player1 = new Player();
      Player player2 = new Player();
      
      player1.setPosition(WR);
      player1.setFirstName(Antonio);
      player1.setLastName(Brown);
      player1.setNflTeam(PIT);
      
      System.out.println(player1.playerToString());
   }
}
   */
