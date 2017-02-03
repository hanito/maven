package tennis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Set {


	private Player p1;
	private Player p2;
	private Player gagnant;
	private List<Game> game;
	
	
	
	
	
	public Player getGagnant() {
		return gagnant;
	}


	public void setGagnant(Player gagnant) {
		this.gagnant = gagnant;
	}


	
	
	 public void addGame(Game game) {
	        this.game.add(game);
	    }
	
	 
	
	public List<Game> getGame() {
		return game;
	}





	/**
	 * @param p1
	 * @param p2
	 */
	public Set(Player p1, Player p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.game= new ArrayList<Game>();
		Game game =new Game(p1,p2);
		this.addGame(game);
	}

	
}
