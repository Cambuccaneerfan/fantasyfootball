package team;

import java.util.ArrayList;

import player.Player;

import java.io.Serializable;

public class Team implements Serializable {
	private String managerName;
	private String teamName;
	private String proposedTrade;
	private int score;
	private String record;
	private ArrayList<Player> roster;
	public static final long serialVersionUID = 1L;

	/**
	 * Team object holds information and players specific 
	 * to each manager.
	 */
	public Team() {
		managerName = "";
		teamName = "";
		proposedTrade = "";
		score = 0;
		record = "";
		roster = new ArrayList<Player>();
	}

	/**
	 * @return  this team manager's name
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @return  this team name
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Will return empty if this team has not been offered a trade,
	 * otherwise returns the proposed trade.
	 * 
	 * @return  any trade proposed to this team
	 */
	public String getProposedTrade() {
		return proposedTrade;
	}

	/**
	 * @return  this team's score for the week
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return  this team's season-long record
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * @return  this team roster
	 */
	public ArrayList<Player> getRoster() {
		return roster;
	}

	/**
	 * Return a player from the team given it's index on the roster array.
	 * 
	 * @param x  location on roster array
	 * @return  the player at that location
	 */
	public Player getTeamPlayer(int x) {
		return roster.get(x);
	}

	/**
	 * Return the amount of starters the team has at a given position.
	 * 
	 * @param pos  position to check
	 * @return  number of starters on this team at that position
	 */
	public int starterCount(String pos) {
		int count = 0;
		for (int x = 0; x < roster.size(); x++) {
			if (roster.get(x).getIsStarting() && roster.get(x).getPosition().equals(pos)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @param mName  the manager name to set
	 */
	public void setManagerName(String mName) {
		managerName = mName;
	}

	/**
	 * @param tName  the team name to set
	 */
	public void setTeamName(String tName) {
		teamName = tName;
	}

	/**
	 * Sends a trade offer to this team
	 * 
	 * @param trade  the trade being offered to this team
	 */
	public void setProposedTrade(String trade) {
		proposedTrade = trade;
	}

	/**
	 * @param sco  the score to set
	 */
	public void setScore(int sco) {
		score = sco;
	}

	/**
	 * @param rec  the record to set
	 */
	public void setRecord(String rec) {
		record = rec;
	}

	/**
	 * Prints manager name, team name, and roster.
	 */
	public void teamToString() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName + "\n");
		for (int x = 0; x < roster.size(); x++) {
			System.out.println(roster.get(x).startingIndicator() + " " + roster.get(x).playerToString());
		}
	}

	/**
	 * Prints manager name, team name, and roster with numbers next to players so they can be selected.
	 */
	public void teamToStringNum() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName + "\n");
		for (int x = 0; x < roster.size(); x++) {
			System.out.println(
					(x + 1) + " - " + roster.get(x).startingIndicator() + " " + roster.get(x).playerToString());
		}
	}

	/**
	 * Prints only manager name and team name
	 */
	public void teamManNameToString() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName);
	}
}