package utilities;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import league.League;

public class Deserializer {
	/**
	 * Returns the League object saved to SavedLeague.ser.
	 * 
	 * @return  the saved league
	 */
	public League deserializeSavedLeague() {
		League theLeague;

		try {
			FileInputStream fin = new FileInputStream("SavedLeague.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			theLeague = (League) ois.readObject();
			ois.close();
			return theLeague;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns the sample League object saved to SampleLeague.ser.
	 * 
	 * @return  the sample league
	 */
	public League deserializeSampleLeague() {
		League theLeague;

		try {
			FileInputStream fin = new FileInputStream("SampleLeague.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			theLeague = (League) ois.readObject();
			ois.close();
			return theLeague;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}