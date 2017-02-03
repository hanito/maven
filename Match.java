package tennis.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;

public class Match {

	private static final Player Player = null;
	private ArrayList<Set> partie;
	private Player p1;
	private Player p2;
	private Player gagnant;

	public void addSet(Set set) {
		this.partie.add(set);
	}

	public ArrayList<Set> getPartie() {
		return partie;
	}

	public void setPartie(ArrayList<Set> partie) {
		this.partie = partie;
	}

	public Player getGagnant() {
		return gagnant;
	}

	public void setGagnant(Player gagnant) {
		this.gagnant = gagnant;
	}

	/**
	 * @param p1
	 * @param p2
	 */
	public Match(Player p1, Player p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		Set set = new Set(p1, p2);
		this.addSet(set);

	}

	/*
	 * recuperer le score d'un joueur
	 * 
	 * 
	 */
	public Point getScore(Match match, Player p) {
		Game game = null;
		return (Point) game.getScores().get(p);
	}

	/*
	 * marquer un point durant Tiebreak
	 * 
	 * 
	 */

	public void winBallTieBreak(Match match, Player p1) {
		TieBreak tieBreak = null;
		Integer scoreP1 = (Integer) tieBreak.getScores().get(p1);
		Player p2 = match.p2;
		Integer scoreP2 = (Integer) tieBreak.getScores().get(p2);
		tieBreak.getScores().put(p1, scoreP1 += 1);
		// le joueur P1 gagne si son score est superieur à 7 et à 2 points de
		// plus que P2
		if (scoreP1 >= 7 && Math.abs(scoreP1 - scoreP2) >= 2) {
			WinGame(match, p1);
		}
	}

	/*
	 * marquer un point durant un jeu
	 * 
	 */
	public void winBallGame(Match match, Player p1) {
		Game game = null;
		Point scoreP1 = (Point) game.getScores().get(p1);
		Player p2 = match.p2;
		Point scoreP2 = (Point) game.getScores().get(p2);
		switch (scoreP1) {
		case ZERO:
			scoreP1 = Point.QUINZE;
			break;
		case QUINZE:
			scoreP1 = Point.TRENTE;
			break;
		case TRENTE:
			scoreP1 = Point.QUARANTE;
			if (Point.QUARANTE.equals(scoreP2)) {
				scoreP1 = Point.DEUCE;
				scoreP2 = Point.DEUCE;
			} else {
				scoreP1 = Point.QUARANTE;
			}
			break;
		case QUARANTE:
			scoreP1 = Point.AVANTAGE;
			break;
		case DEUCE:
			scoreP1 = Point.AVANTAGE;
			scoreP2 = Point.QUARANTE;
			break;
		case AVANTAGE:
			WinGame(match, p1);
			break;
		}
		game.getScores().put(p1, scoreP1);
		game.getScores().put(p2, scoreP2);

	}

	public long getWinGame(Match match, Player p) {
		Set set = null;
		return getWinGame(set, p);
	}

	/*
	 * nombre de Jeux gagnés dans un set
	 * 
	 * 
	 */

	public long getWinGame(Set set, Player p) {
		return set.getGame().stream().filter(game -> p.equals(game.getWinner())).count();
	}

	/*
	 * nombre de sets gagnés dans un match
	 * 
	 */
	public long getWinSet(Match match, Player p) {
		return match.getPartie().stream().filter(game -> p.equals(game.getGagnant())).count();
	}

	/*
	 * le gagnant d'un set
	 */
	public void WinSet(Match match, Player p) {
		Set set;

		/*
		 * si le nombre de set est supérieur ou egal à 2= nombres de sets
		 * gagnants durant le match alors le jouer remporte le match sinon on
		 * reprend un nouveau set
		 */
		if (getWinSet(match, p) >= 2) {
			WinMatch(match, p);

		} else {
			Set Newset = new Set(match.p1, match.p2);
			match.addSet(Newset);
		}
	}

	/*
	 * gagner un jeu
	 */
	public void WinOneGame(Match match, Player p) {
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			match.winBallGame(match, p);
		});
	}

	/*
	 * gagner un set
	 * 
	 */

	public void WinOneSet(Match match, Player p) {
		IntStream.rangeClosed(1, 6).forEach((Integer) -> {
			WinOneGame(match, p);
		});
	}
	/*
	 * le gagnant d 'un jeu
	 */

	public void WinGame(Match match, Player p1) {
		Game game = null;
		game.setWinner(p1);

	}

	/*
	 * le gagnant du match
	 * 
	 * 
	 */
	public void WinMatch(Match match, Player p) {
		match.setGagnant(p);
	}

}
