
public class Player
{
   private String position;
   private String firstName;
   private String lastName;
   private String nflTeam;
   private boolean isOwned;
   
   public Player()
   {
      position = "";
      firstName = "";
      lastName = "";
      nflTeam = "";
      isOwned = false;
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
   
   public boolean getIsOwned()
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
