package player;

import java.io.Serializable;

public class Player implements Serializable {
	private String position;
	private String firstName;
	private String lastName;
	private String nflTeam;
	private boolean isOwned;
	private boolean isStarting;
	private int id;
	public static final long serialVersionUID = 1L;

	public Player() {
		position = "";
		firstName = "";
		lastName = "";
		nflTeam = "";
		isOwned = false;
		isStarting = false;
		id = -1;
	}

	public String getPosition() {
		return position;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNflTeam() {
		return nflTeam;
	}

	public boolean getIsOwned() {
		return isOwned;
	}

	public boolean getIsStarting() {
		return isStarting;
	}

	public int getId() {
		return id;
	}

	public String startingIndicator() {
		if (isStarting) {
			return "~~START~~";
		}
		return "BENCH";
	}

	public void setPosition(String pos) {
		position = pos;
	}

	public void setFirstName(String first) {
		firstName = first;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public void setNflTeam(String team) {
		nflTeam = team;
	}

	public void setIsOwned() {
		isOwned = true;
	}

	public void setFreeAgent() {
		isOwned = false;
		isStarting = false;
	}

	public void setStarting() {
		isStarting = true;
	}

	public void setBench() {
		isStarting = false;
	}

	public void setId(int x) {
		id = x;
	}

	public String playerToString() {
		return getPosition() + " " + getFirstName() + " " + getLastName() + " " + getNflTeam();
	}
}