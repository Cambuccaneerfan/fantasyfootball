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

	// Commissioner should be able to create a league, and establish the
	// settings for the league.
	// The commissioner must be able to set the league name, number of teams in
	// the league,
	// scoring rules, maximum players per team, starting players per team, the
	// managers in the league,
	// and also be able to enter draft results.

	public Team() {
		managerName = "";
		teamName = "";
		proposedTrade = "";
		score = 0;
		record = "";
		roster = new ArrayList<Player>();
	}

	public String getManagerName() {
		return managerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getProposedTrade() {
		return proposedTrade;
	}

	public int getScore() {
		return score;
	}

	public String getRecord() {
		return record;
	}

	public ArrayList<Player> getRoster() {
		return roster;
	}

	public Player getTeamPlayer(int x) {
		return roster.get(x);
	}
	
	public int starterCount(String pos) {
		int count = 0;
		for (int x = 0; x < roster.size(); x++) {
			if (roster.get(x).getIsStarting() && roster.get(x).getPosition().equals(pos)) {
				count++;
			}
		}
		return count;
	}

	public void setManagerName(String mName) {
		managerName = mName;
	}

	public void setTeamName(String tName) {
		teamName = tName;
	}

	public void setProposedTrade(String trade) {
		proposedTrade = trade;
	}

	public void setScore(int sco) {
		score = sco;
	}

	public void setRecord(String rec) {
		record = rec;
	}

	public void teamToString() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName + "\n");
		for (int x = 0; x < roster.size(); x++) {
			System.out.println(roster.get(x).startingIndicator() + " " + roster.get(x).playerToString());
		}
	}

	public void teamToStringNum() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName + "\n");
		for (int x = 0; x < roster.size(); x++) {
			System.out.println(
					(x + 1) + " - " + roster.get(x).startingIndicator() + " " + roster.get(x).playerToString());
		}
	}

	public void teamManNameToString() {
		System.out.println("-Manager: " + managerName + "\n" + "----Team: " + teamName);
	}
}