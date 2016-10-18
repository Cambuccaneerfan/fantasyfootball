public class PlayerList
{
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
   
   /*
   
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

   
   public PlayerList()
   
   
   
   public PlayerList()
   {
      player1 = new Player();
      player2 = new Player();
      player3 = new Player();
      player4 = new Player();
      player5 = new Player();
   }
   
   public Player(String first, String last, String pos, String team, boolean owned)
   {
      firstName = first;
      lastName = last;
      position = pos;
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

         firstName = aPlayer.firstName;
         lastName = aPlayer.lastName;
         position = aPlayer.position;
         nflTeam = aPlayer.nflTeam;
         isOwned = aPlayer.isOwned;
   }
   
   
   
   
   
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   public String getNflTeam()
   {
      return nflTeam;
   }
   
   public boolean getisOwned()
   {
      return isOwned;
   }
      
   public void setFirstName(String first)
   {
      firstName = first;
   }
   
   public void setLastName(String last)
   {
      lastName = last;
   }
   
   public void setPosition(String pos)
   {
      position = pos;
   }
   
   public void setNflTeam(String team)
   {
      nflTeam = team;
   }
   
   public void setIsOwned(boolean owned)
   {
      isOwned = owned;
   }
      
   public String playerToString()
   {
      return getPosition() + " " + getFirstName() + "" + getLastName() + " " + getNflTeam();
   }
   
      
   
   
   
   public String playerToString()
   {
      if (position.equals("QB") || position.equals("OL") || position.equals("DL"))
      {
         return getAge() + " " + getPosition() + " " + getPassing() + " " + getRushing() + " " + getFirstName() + " " + getLastName();
      }
      else if (position.equals("K") || position.equals("P"))
      {
         return getAge() + " " + getPosition() + "  " + getSpecialTeams() + " " + getFirstName() + " " + getLastName();
      }
      else
      {
         return getAge() + " " + getPosition() + " " + getPassing() + " " + getRushing() + " " + getSpecialTeams() + " " + getFirstName() + " " + getLastName();
      }
   }
   
   public void randomFirstName()
   {
      int randomNumber1;
      
      List<String> firstNameList = new ArrayList<String>();
      
      Scanner firstNameScan = null;
      Scanner keyboard = new Scanner(System.in);

      try
      {
         firstNameScan = new Scanner(new FileInputStream("FirstName.txt"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("FirstName.txt not found.");
         System.exit(0);
      }
      
      while (firstNameScan.hasNext())
      {
         firstNameList.add(firstNameScan.next()); //add names in file to array list
      }
      
      randomNumber1 = rand.nextInt(firstNameList.size()) + 1;
         
      firstName = firstNameList.get(randomNumber1 - 1) + "";
   }
   
   public void randomLastName()
   {
      int randomNumber2;
      
      List<String> lastNameList = new ArrayList<String>();
      
      Scanner lastNameScan = null;
      Scanner keyboard = new Scanner(System.in);

      try
      {
         lastNameScan = new Scanner(new FileInputStream("LastName.txt"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("LastName.txt not found.");
         System.exit(0);
      }
      
      while (lastNameScan.hasNext())
      {
         lastNameList.add(lastNameScan.next());
      }
      
      randomNumber2 = rand.nextInt(lastNameList.size()) + 1;

      lastName = lastNameList.get(randomNumber2 - 1) + "";
   }
   
   public void randomAge()
   {
      int randomNumber3;
      
      randomNumber3 = rand.nextInt(11) + 1;
      
      age = randomNumber3 + 19;
   }
   
   public void randomPosition()
   {
      int randomNumber4;
      
      randomNumber4 = rand.nextInt(24) + 1;
      
      switch (randomNumber4)
      {
         case 1:
         case 2:
         position = "WR";
         break;
         case 3:
         position = "TE";
         break;
         case 4:
         case 5:
         position = "RB";
         break;
         case 6:
         position = "QB";
         break;
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         position = "OL";
         break;
         case 12:
         case 13:
         case 14:
         position = "LB";
         break;
         case 15:
         case 16:
         case 17:
         case 18:
         position = "DL";
         break;
         case 19:
         case 20:
         case 21:
         case 22:
         position = "DB";
         break;
         case 23:
         position = "K";
         break;
         case 24:
         position = "P";
         break;
         default:
         position = "OOB";
         break;
      }
   }
   
   public void randomStats()
   {
      int randomNumber5;
      int randomNumber6;
      int randomNumber7;
      
      randomNumber5 = rand.nextInt(30) + 1;
      randomNumber6 = rand.nextInt(30) + 1;
      randomNumber7 = rand.nextInt(30) + 1;
      
      if (position == "WR" || position == "TE" || position == "RB" || position == "LB" || position == "DB")
      {         
         passing = randomNumber5 + 70;
         rushing = randomNumber6 + 70;
         specialTeams = randomNumber7 + 70;
      }
      else if (position == "QB" || position == "OL" || position == "DL")
      {
         passing = randomNumber5 + 70;
         rushing = randomNumber6 + 70;
         specialTeams = 0;
      }
      else if (position == "K" || position == "P")
      {
         passing = 0;
         rushing = 0;
         specialTeams = randomNumber7 + 70;
      }
      else
      {
         passing = 0;
         rushing = 0;
         specialTeams = 0;
      }
   }
   
   public void randomPlayer()
   {
      randomFirstName();
      randomLastName();
      randomAge();
      randomPosition();
      randomStats();
   }
   
   public void randomEverythingButPosition()
   {
      randomFirstName();
      randomLastName();
      randomAge();
      randomStats();
   }
   */