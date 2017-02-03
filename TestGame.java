import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

import tennis.model.Match;
import tennis.model.Player;
import tennis.model.Point;
import tennis.model.Set;

public class TestGame {

	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

private Player Vanessa;
private Player Serena;
private Match match;	
	
	
	@Before
	public void beforeTestGame(){
		Vanessa = new Player("Vanessa");
		Serena = new Player ("Serena");
		match= new Match(Vanessa,Serena);
	}
	
	
	
	@Test
	public void Score15(){
		match.winBallTieBreak(match, Vanessa);
		assertTrue(Point.QUINZE.equals(match.getScore(match, Vanessa)));
		
	}
	
	@Test
	public void ScoreGame15(){
		match.winBallGame(match, Vanessa);
		assertTrue(Point.QUINZE.equals(match.getScore(match, Vanessa)));
	
		
	}
	
	@Test
	public void Score30(){
		match.winBallTieBreak(match, Serena);
		match.winBallTieBreak(match, Serena);
		assertTrue(Point.TRENTE.equals(match.getScore(match,Serena)));
		
		
	}
	
	@Test
	public void ScoreGame30(){
		match.winBallGame(match, Serena);
		match.winBallGame(match, Serena);
		assertTrue(Point.TRENTE.equals(match.getScore(match,Serena)));
		
	}
		
	
	
	@Test
	public void Score40(){
		match.winBallTieBreak(match, Serena);
		match.winBallTieBreak(match, Serena);
		match.winBallTieBreak(match, Serena);
		assertTrue(Point.QUARANTE.equals(match.getScore(match,Serena)));
		
		
	}
	
	@Test
	public void ScoreGame40(){
		match.winBallGame(match, Serena);
		match.winBallGame(match, Serena);
		match.winBallGame(match, Serena);
		assertTrue(Point.TRENTE.equals(match.getScore(match,Serena)));
		
	}
	
	@Test
	public void ScoreDEUCE(){
		  IntStream.rangeClosed(1, 3).forEach((Integer) -> {
		match.winBallTieBreak(match, Serena);
		match.winBallTieBreak(match, Vanessa);
		  });
		assertTrue(Point.DEUCE.equals(match.getScore(match,Serena)));
		assertTrue(Point.DEUCE.equals(match.getScore(match,Vanessa)));
		
	}
	
	@Test
	public void ScoreGameDEUCE(){
		  IntStream.rangeClosed(1, 3).forEach((Integer) -> {
		match.winBallGame(match, Serena);
		match.winBallGame(match, Vanessa);
		  });
		assertTrue(Point.DEUCE.equals(match.getScore(match,Serena)));
		assertTrue(Point.DEUCE.equals(match.getScore(match,Vanessa)));
		
	}
	@Test
	public void ScoreAVANTAGE(){
		  IntStream.rangeClosed(1, 3).forEach((Integer) -> {
		match.winBallTieBreak(match, Serena);
		match.winBallTieBreak(match, Vanessa);
		  });
		  match.winBallTieBreak(match, Serena);
		  
		assertTrue(Point.AVANTAGE.equals(match.getScore(match,Serena)));
		assertTrue(Point.QUARANTE.equals(match.getScore(match,Vanessa)));
		
	}
	
	@Test
	public void ScoreGameAVANTAGE(){
		  IntStream.rangeClosed(1, 3).forEach((Integer) -> {
		match.winBallGame(match, Serena);
		match.winBallGame(match, Vanessa);
		  });
		  match.winBallGame(match, Serena);
		  
		assertTrue(Point.AVANTAGE.equals(match.getScore(match,Serena)));
		assertTrue(Point.QUARANTE.equals(match.getScore(match,Vanessa)));
		
	}

	
	
	@Test
	public void testWinTieBreak(){
		WinOneGame(match,Serena);
		IntStream.range(1, 6).forEach((Integer)->{
			WinOneGame(match,Vanessa);
			WinOneGame(match,Serena);
		});	
			//Gagner  le tie break
			
			IntStream.rangeClosed(1, 7).forEach((Integer)->{
				match.winBallTieBreak(match, Vanessa);;
				
			});
			Set set = null;
			assertTrue(match.getWinGame(set, Vanessa)==7);
			assertTrue(Vanessa.equals(set.getGagnant()));
		
	}
	
	
	
	@Test
	public void testWinSet(){
		Set set = null;
		WinOneSet(match,Vanessa);
		assertTrue(match.getWinGame(set, Vanessa)==6);
		assertTrue(Vanessa.equals(set.getGagnant()));
	}
	
	
	

	@Test
	public void testWinMatch(){
		IntStream.rangeClosed(1, 2).forEach((Integer)->{
			WinOneSet(match,Vanessa);
		});
	}

/*
 * gagner un jeu
 */
public void WinOneGame(Match match, Player p){
	IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        match.winBallGame(match, p);
    });
}


/*
 * gagner un set
 * 
 */

public void WinOneSet(Match match , Player p){
	IntStream.rangeClosed(1,6).forEach((Integer) ->{
		WinOneGame(match,p);
	});
}
	

}
