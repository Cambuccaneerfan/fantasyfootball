package utilities;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import league.League;
import player.Player;
import team.Team;

public class Serializer {

	public void serializeLeague(String name, int numOfTeams, String rules, int QB, int WR, int RB, int TE, int bench,
			ArrayList<Team> listTeams, ArrayList<Player> listPlayers) {

		League theLeague = new League();
		theLeague.setLeagueName(name);
		theLeague.setNumTeams(numOfTeams);
		theLeague.setScoringRules(rules);
		theLeague.setNumQB(QB);
		theLeague.setNumWR(WR);
		theLeague.setNumRB(RB);
		theLeague.setNumTE(TE);
		theLeague.setNumBench(bench);
		theLeague.setTeamList(listTeams);
		theLeague.setPlayerList(listPlayers);

		try {

			FileOutputStream fout = new FileOutputStream("SavedLeague.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(theLeague);
			oos.close();
			System.out.println("");
			System.out.println("___LEAGUE SAVED___");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
