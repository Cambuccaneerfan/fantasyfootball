package league;

import java.util.ArrayList;

import player.Player;
import player.PlayerList;
import team.Team;

import java.io.Serializable;

public class League implements Serializable {
	private String leagueName;
	private int numTeams;
	private String scoringRules;
	private String pendingTrade;
	private int maxQB;
	private int maxWR;
	private int maxRB;
	private int maxTE;
	private int maxBench;
	private ArrayList<Team> teamList;
	private ArrayList<Player> playList;
	public static final long serialVersionUID = 1L;

	// Commissioner should be able to create a league, and establish the
	// settings for the league.
	// The commissioner must be able to set the league name, number of teams in
	// the league,
	// scoring rules, maximum players per team, starting players per team, the
	// managers in the league,
	// and also be able to enter draft results.

	public League() {
		leagueName = "";
		numTeams = 0;
		scoringRules = "";
		pendingTrade = "";
		maxQB = 0;
		maxWR = 0;
		maxRB = 0;
		maxTE = 0;
		maxBench = 0;
		teamList = new ArrayList<Team>();
		playList = new ArrayList<Player>();
	}

	public String getLeagueName() {
		return leagueName;
	}

	public int getNumTeams() {
		return numTeams;
	}

	public String getScoringRules() {
		return scoringRules;
	}

	public String getPendingTrade() {
		return pendingTrade;
	}

	public int getMaxQB() {
		return maxQB;
	}

	public int getMaxWR() {
		return maxWR;
	}

	public int getMaxRB() {
		return maxRB;
	}

	public int getMaxTE() {
		return maxTE;
	}

	public int getMaxBench() {
		return maxBench;
	}

	public int getMaxPlayers() {
		return maxQB + maxWR + maxRB + maxTE + maxBench;
	}
	
	public int getPositionMax(String pos) {
		if (pos.equals("QB")) {
			return maxQB;
		} else if (pos.equals("WR")) {
			return maxWR;
		} else if (pos.equals("RB")) {
			return maxRB;
		} else if (pos.equals("TE")) {
			return maxTE;
		}
		return 0;
	}

	public ArrayList<Team> getTeamList() {
		return teamList;
	}

	public Team getTeam(int x) {
		return teamList.get(x);
	}

	public ArrayList<Player> playerList() {
		return playList;
	}

	public void setLeagueName(String lName) {
		leagueName = lName;
	}

	public void setNumTeams(int x) {
		numTeams = x;
	}

	public void setScoringRules(String rules) {
		scoringRules = rules;
	}

	public void setPendingTrade(String trade) {
		pendingTrade = trade;
	}

	public void setMaxQB(int x) {
		maxQB = x;
	}

	public void setMaxWR(int x) {
		maxWR = x;
	}

	public void setMaxRB(int x) {
		maxRB = x;
	}

	public void setMaxTE(int x) {
		maxTE = x;
	}

	public void setMaxBench(int x) {
		maxBench = x;
	}

	public void setTeamList(ArrayList<Team> tList) {
		teamList = tList;
	}

	public void setPlayerList(ArrayList<Player> pList) {
		playList = pList;
	}
	
	public void createTeamList() {
		for (int x = 0; x < getNumTeams(); x++) {
			Team aTeam = new Team();
			getTeamList().add(aTeam);
		}
	}
	
	public void createPlayerList() {
		playList = PlayerList.create();
	}

	public void setDraftResult(int teamNum, int playerListSpot) {
		playerList().get(playerListSpot).setIsOwned();
		getTeam(teamNum).getRoster().add(playerList().get(playerListSpot));
	}

	public void getFreeAgents() {
		for (int x = 0; x < playerList().size(); x++) {
			if (playerList().get(x).getIsOwned() == false) {
				System.out.println((x + 1) + " - " + playerList().get(x).playerToString());
			}
		}
	}

	public void getFreeAgents(int numToShow) {
		int y = 0;
		for (int x = 0; x < numToShow; x++) {
			while (playerList().get(y).getIsOwned() == true) {
				y++;
			}
			if (playerList().get(y).getIsOwned() == false) {
				System.out.println((y + 1) + " " + playerList().get(y).playerToString());
				y++;
			}
		}
	}
	public void viewSettings() {
		System.out.println("");
		System.out.println("---League Settings---");
		System.out.println("League Name: " + getLeagueName());
		System.out.println("Scoring Rules: " + getScoringRules());
		System.out.println("Starting Positions: (" + getMaxPlayers() + " player maximum)");
		System.out.println(getMaxQB() + " QB");
		System.out.println(getMaxWR() + " WR");
		System.out.println(getMaxRB() + " RB");
		System.out.println(getMaxTE() + " TE");
		System.out.println(getMaxBench() + " Bench");
	}

	public void viewStandings() {
		System.out.println("");
		System.out.println("---League Standings---");
		for (int x = 0; x < getNumTeams(); x++) {
			System.out.println("");
			getTeam(x).teamManNameToString();
			;
			System.out.println("Record: " + getTeam(x).getRecord());
			System.out.println("This week's score: " + getTeam(x).getScore());
		}
	}
}
