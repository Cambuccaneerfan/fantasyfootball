
public class Player
{
   private String position;
   private String firstName;
   private String lastName;
   private String nflTeam;
   private Boolean isOwned;
   
   public Player()
   {
      position = "";
      firstName = "";
      lastName = "";
      nflTeam = "";
      isOwned = false;
   }
   
   public Player(String pos, String first, String last, String team, Boolean owned)
   {
      position = pos;
      firstName = first;
      lastName = last;
      nflTeam = team;
      isOwned = owned;
   }
   
   public Player(Player aPlayer)
   {
      if (aPlayer == null)
         {
            System.out.println("Fatal Error.");
            System.exit(0);
         }

         position = aPlayer.position;
         firstName = aPlayer.firstName;
         lastName = aPlayer.lastName;
         nflTeam = aPlayer.nflTeam;
         isOwned = aPlayer.isOwned;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public String getNflTeam()
   {
      return nflTeam;
   }
   
   public Boolean getIsOwned()
   {
      return isOwned;
   }
      
   public void setPosition(String pos)
   {
      position = pos;
   }
   
   public void setFirstName(String first)
   {
      firstName = first;
   }
   
   public void setLastName(String last)
   {
      lastName = last;
   }
   
   public void setNflTeam(String team)
   {
      nflTeam = team;
   }
   
   public void setIsOwned()
   {
      isOwned = true;
   }
   
   public void setFreeAgent()
   {
      isOwned = false;
   }
      
   public String playerToString()
   {
      return getPosition() + " " + getFirstName() + " " + getLastName() + " " + getNflTeam();
   }
}