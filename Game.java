package tennis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

	private Player p1;
	private Player p2;
	private Player winner;
	private Map<Player, Point> scores;

	/**
	 * @param p1
	 * @param p2
	 */
	public Game(Player p1, Player p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.scores = new HashMap<Player, Point>();
		this.addScore(p1, Point.ZERO);
		this.addScore(p2, Point.ZERO);
	}

	public Map getScores() {
		return this.scores;
	}

	public void addScore(Player p, Point pt) {
		this.scores.put(p, pt);
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

}
