import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serializer {

   /*
   public static void main (String args[]) {

	   Serializer serializer = new Serializer();
	   serializer.serializeLeague("wall street", "united state");
   }
   */

   public void serializeLeague(String name, int numOfTeams, String rules, ArrayList<Team> listTeams, ArrayList<Player> listPlayers){

	   League theLeague = new League();
	   theLeague.setLeagueName(name);
	   theLeague.setNumTeams(numOfTeams);
	   theLeague.setScoringRules(rules);
	   theLeague.setTeamList(listTeams);
	   theLeague.setPlayerList(listPlayers);

	   try{

		FileOutputStream fout = new FileOutputStream("SavedLeague.ser"); // was using c:\\Users\\owner\\SavedLeague.ser
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(theLeague);
		oos.close();
		System.out.println("***League Saved***");

	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
}

/*
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer {

   public static void main (String args[]) {

	   Serializer serializer = new Serializer();
	   serializer.serializeAddress("wall street", "united state");
   }

   public void serializeAddress(String street, String country){

	   Address address = new Address();
	   address.setStreet(street);
	   address.setCountry(country);

	   try{

		FileOutputStream fout = new FileOutputStream("c:\\address.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(address);
		oos.close();
		System.out.println("Done");

	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
}
*/