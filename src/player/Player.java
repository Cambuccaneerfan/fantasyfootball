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

	/**
	 * NFL players, identified by name, position, and NFL team.
	 */
	public Player() {
		position = "";
		firstName = "";
		lastName = "";
		nflTeam = "";
		isOwned = false;
		isStarting = false;
		id = -1;
	}

	/**
	 * @return  this player's position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @return  this player's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return  this player's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return  this player's NFL team
	 */
	public String getNflTeam() {
		return nflTeam;
	}

	/**
	 * Returns true if a player is owned by a team, false if the player is a free agent.
	 * 
	 * @return  whether this player is owned by a team
	 */
	public boolean getIsOwned() {
		return isOwned;
	}

	/**
	 * Returns true if a player is starting on a team.
	 * 
	 * @return  whether this player is starting
	 */
	public boolean getIsStarting() {
		return isStarting;
	}

	/**
	 * ID number is equal to the player's position on the playerList array. Used to 
	 * place players back in the same position on the array when they are dropped.
	 * 
	 * @return  this player's ID number
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns a string to clearly show whether a player is benched or starting
	 * 
	 * @return  start or bench String
	 */
	public String startingIndicator() {
		if (isStarting) {
			return "~~START~~";
		}
		return "BENCH";
	}

	/**
	 * @param pos  the position to set
	 */
	public void setPosition(String pos) {
		position = pos;
	}

	/**
	 * @param first  the first name to set
	 */
	public void setFirstName(String first) {
		firstName = first;
	}

	/**
	 * @param last  the last name to set
	 */
	public void setLastName(String last) {
		lastName = last;
	}

	/**
	 * @param team  the NFL team to set
	 */
	public void setNflTeam(String team) {
		nflTeam = team;
	}

	/**
	 * When a team owns a player, it makes them unavailable to other teams.
	 */
	public void setIsOwned() {
		isOwned = true;
	}

	/**
	 * When a player is dropped, they must be made available to other teams, 
	 * and can no longer be starting.
	 */
	public void setFreeAgent() {
		isOwned = false;
		isStarting = false;
	}

	/**
	 * Indicates that this player is starting.
	 */
	public void setStarting() {
		isStarting = true;
	}

	/**
	 * This player is not starting.
	 */
	public void setBench() {
		isStarting = false;
	}

	/**
	 * When playerList is created, player ID is set as position on array at the same time.
	 *
	 * @param x  the id to be set 
	 */
	public void setId(int x) {
		id = x;
	}

	/**
	 * Prints this player's position, name, and NFL team.
	 * 
	 * @return  this player's identifying information
	 */
	public String playerToString() {
		return getPosition() + " " + getFirstName() + " " + getLastName() + " " + getNflTeam();
	}
}