import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserializer{

   /*
	public static void main (String args[]) {

	   Deserializer deserializer = new Deserializer();
	   Address address = deserializer.deserialzeAddress();
	   System.out.println(address);
   }
   */

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