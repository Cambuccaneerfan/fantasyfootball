package utilities;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import leagueMain.League;

public class Deserializer{

   public League deserializeLeague(){

	   League theLeague;

	   try{

		   FileInputStream fin = new FileInputStream("SavedLeague.ser");
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   theLeague = (League) ois.readObject();
		   ois.close();

		   return theLeague;

	   }catch(Exception ex){
		   ex.printStackTrace();
		   return null;
	   }
   }
}