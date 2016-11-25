package player;

import java.io.Serializable;

public class Player implements Serializable {
	private String position;
	private String firstName;
	private String lastName;
	private String nflTeam;
	private boolean isOwned;

	private boolean isStartingQB;
	private boolean isStartingWR;
	private boolean isStartingRB;
	private boolean isStartingTE;

	private int id;

	public static final long serialVersionUID = 1L;

	public Player() {
		position = "";
		firstName = "";
		lastName = "";
		nflTeam = "";
		isOwned = false;

		isStartingQB = false;
		isStartingWR = false;
		isStartingRB = false;
		isStartingTE = false;

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

	public boolean getIsStartingQB() {
		return isStartingQB;
	}

	public boolean getIsStartingWR() {
		return isStartingWR;
	}

	public boolean getIsStartingRB() {
		return isStartingRB;
	}

	public boolean getIsStartingTE() {
		return isStartingTE;
	}

	public int getId() {
		return id;
	}

	public String startingIndicator() {
		if (isStartingQB || isStartingWR || isStartingRB || isStartingTE) {
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
	}

	public void setStartingQB() {
		isStartingQB = true;
	}

	public void setStartingWR() {
		isStartingWR = true;
	}

	public void setStartingRB() {
		isStartingRB = true;
	}

	public void setStartingTE() {
		isStartingTE = true;
	}

	public void setBench() {
		isStartingQB = false;
		isStartingWR = false;
		isStartingRB = false;
		isStartingTE = false;
	}

	public void setId(int x) {
		id = x;
	}

	public String playerToString() {
		return getPosition() + " " + getFirstName() + " " + getLastName() + " " + getNflTeam();
	}
}
