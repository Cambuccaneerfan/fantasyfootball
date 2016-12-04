package utilities;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import league.League;
import player.Player;
import team.Team;

public class Serializer {
	/**
	 * Save the active league. performed after nearly every operation.
	 * 
	 * @param name  the league name to be saved
	 * @param numOfTeams  the number of teams in the league
	 * @param rules  the scoring rules of the league
	 * @param trade  any pending accepted trade in the league
	 * @param QB  the maximum QBs allowed in the league
	 * @param WR  the maximum WRs allowed in the league
	 * @param RB  the maximum RBs allowed in the league
	 * @param TE  the maximum TEs allowed in the league
	 * @param bench  the maximum bench players allowed in addition to starters
	 * @param listTeams  the teams in the league
	 * @param listPlayers  the player list of the league
	 */
	public void serializeLeague(String name, int numOfTeams, String rules, String trade, int QB, int WR, int RB, int TE,
			int bench, ArrayList<Team> listTeams, ArrayList<Player> listPlayers) {
		League theLeague = new League();
		theLeague.setLeagueName(name);
		theLeague.setNumTeams(numOfTeams);
		theLeague.setScoringRules(rules);
		theLeague.setPendingTrade(trade);
		theLeague.setMaxQB(QB);
		theLeague.setMaxWR(WR);
		theLeague.setMaxRB(RB);
		theLeague.setMaxTE(TE);
		theLeague.setMaxBench(bench);
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