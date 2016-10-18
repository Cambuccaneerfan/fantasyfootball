public class PlayerTest
{
   public static void main (String[] args)
   {
      Team team1 = new Team();
      team1.setStartingQB(1);      
      
      System.out.println("Free Agents");
      
      int x = 0;
      for (x = 0; x < PlayerList.playerList().size(); x++)
      {
         if (!team1.getPlayer(x).getIsOwned())
         {
            System.out.println(team1.getPlayer(x).playerToString());
         }
         
      }
      
      System.out.println("Owned");
      System.out.println(team1.teamToString());
   }
}
