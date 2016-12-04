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
	
	
	/**
	 * League object contains all data necessary to save the state of the program.
	 */
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

	/**
	 * @return  the League name
	 */
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * @return  the number of teams in the League
	 */
	public int getNumTeams() {
		return numTeams;
	}

	/**
	 * @return  the scoring rules of the League
	 */
	public String getScoringRules() {
		return scoringRules;
	}

	/**
	 * @return  an accepted trade that has not been processed
	 */
	public String getPendingTrade() {
		return pendingTrade;
	}

	/**
	 * @return  the most starting QBs a Team can have
	 */
	public int getMaxQB() {
		return maxQB;
	}

	/**
	 * @return  the most starting WRs a Team can have
	 */
	public int getMaxWR() {
		return maxWR;
	}

	/**
	 * @return  the most starting RBs a Team can have
	 */
	public int getMaxRB() {
		return maxRB;
	}

	/**
	 * @return  the most starting TEs a Team can have
	 */
	public int getMaxTE() {
		return maxTE;
	}

	/**
	 * @return  the maximum number of bench players a team can have when all starting positions are filled
	 */
	public int getMaxBench() {
		return maxBench;
	}

	/**
	 * Add the maximum position settings to return the maximum size of a Team.
	 * 
	 * @return  the maximum number of players a team can have
	 */
	public int getMaxPlayers() {
		return maxQB + maxWR + maxRB + maxTE + maxBench;
	}

	/**
	 * Given a position, return the maximum amount of starters allowed.
	 * 
	 * @param pos  the position to check
	 * @return  the maximum starters allowed at the position
	 */
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

	/**
	 * @return  list of all Teams in array
	 */
	public ArrayList<Team> getTeamList() {
		return teamList;
	}

	/**
	 * Return a Team from the teamList given its index.
	 * 
	 * @param x  location on teamList array
	 * @return  the Team at that location
	 */
	public Team getTeam(int x) {
		return teamList.get(x);
	}

	/**
	 * Return the list of all players in array
	 * 
	 * @return  list of all Players in array
	 */
	public ArrayList<Player> playerList() {
		return playList;
	}

	/**
	 * @param lName  the League name to be set
	 */
	public void setLeagueName(String lName) {
		leagueName = lName;
	}

	/**
	 * @param x  the number of Teams to be set
	 */
	public void setNumTeams(int x) {
		numTeams = x;
	}

	/**
	 * @param rules  the scoring rules to be set
	 */
	public void setScoringRules(String rules) {
		scoringRules = rules;
	}

	/**
	 * @param trade  the accepted trade to be set
	 */
	public void setPendingTrade(String trade) {
		pendingTrade = trade;
	}

	/**
	 * @param x  the most starting QBs a Team can have
	 */
	public void setMaxQB(int x) {
		maxQB = x;
	}

	/**
	 * @param x  the most starting WRs a Team can have
	 */
	public void setMaxWR(int x) {
		maxWR = x;
	}

	/**
	 * @param x  the most starting RBs a Team can have
	 */
	public void setMaxRB(int x) {
		maxRB = x;
	}

	/**
	 * @param x the most starting TEs a Team can have
	 */
	public void setMaxTE(int x) {
		maxTE = x;
	}

	/**
	 * @param x  the number of bench players a Team can have in addition to starters
	 */
	public void setMaxBench(int x) {
		maxBench = x;
	}

	/**
	 * @param tList  TeamList to set
	 */
	public void setTeamList(ArrayList<Team> tList) {
		teamList = tList;
	}

	/**
	 * @param pList  PlayerList to set
	 */
	public void setPlayerList(ArrayList<Player> pList) {
		playList = pList;
	}

	/**
	 * Create a Team for each manager once the number of teams is set.
	 */
	public void createTeamList() {
		for (int x = 0; x < getNumTeams(); x++) {
			Team aTeam = new Team();
			getTeamList().add(aTeam);
		}
	}

	/**
	 * Read Players from file and create initial Player list.
	 */
	public void createPlayerList() {
		playList = PlayerList.create();
	}

	/**
	 * Print all available players.
	 */
	public void getFreeAgents() {
		for (int x = 0; x < playerList().size(); x++) {
			if (playerList().get(x).getIsOwned() == false) {
				System.out.println((x + 1) + " - " + playerList().get(x).playerToString());
			}
		}
	}

	/**
	 * Print given amount of top available players.
	 * 
	 * @param numToShow  amount of players to show
	 */
	public void getFreeAgents(int numToShow) {
		int y = 0;
		for (int x = 0; x < numToShow; x++) {
			while (playerList().get(y).getIsOwned()) {
				y++;
			}
			System.out.println((y + 1) + " " + playerList().get(y).playerToString());
			y++;
		}
	}
	
	/**
	 * Print given amount of top available players at a given position.
	 * 
	 * @param numToShow  amount of players to show
	 * @param position  position to be shown
	 */
	public void getFreeAgents(int numToShow, String position) {
		int y = 0;
		for (int x = 0; x < numToShow; x++) {
			while (playerList().get(y).getIsOwned() || !playerList().get(y).getPosition().equals(position)) {
				y++;
				if (y == playerList().size()) {
					return;
				}
			}
			System.out.println((y + 1) + " " + playerList().get(y).playerToString());
			y++;
			if (y == playerList().size()) {
				return;
			}
		}
	}

	/**
	 * Print League settings.
	 */
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

	/**
	 * Print League standings.
	 */
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
