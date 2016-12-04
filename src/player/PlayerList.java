package player;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerList {
	/**
	 * Create the initial player list. Scan the playerList.txt file and create 
	 * array of Player objects using the player information listed.
	 * 
	 * @return  the player list array
	 */
	public static ArrayList<Player> create() {
		Scanner playerScan = null;
		try {
			playerScan = new Scanner(new FileInputStream("playerList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("playerList.txt not found.");
			System.exit(0);
		}

		// add players in file playerList.txt to arraylist
		ArrayList<Player> playList = new ArrayList<Player>();
		int i = 0;
		while (playerScan.hasNext()) {
			Player aPlayer = new Player();

			aPlayer.setPosition(playerScan.next());

			if (playerScan.hasNext()) {
				aPlayer.setFirstName(playerScan.next());
			}
			if (playerScan.hasNext()) {
				aPlayer.setLastName(playerScan.next());
			}
			if (playerScan.hasNext()) {
				aPlayer.setNflTeam(playerScan.next());
			}
			aPlayer.setId(i);
			i++;
			playList.add(aPlayer);
		}
		return playList;
	}
}