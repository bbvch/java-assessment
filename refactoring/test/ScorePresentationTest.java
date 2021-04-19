import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bowlinggame.BowlingGame;
import bowlinggame.ScorePresentation;

public class ScorePresentationTest {

	private ScorePresentation presentation;

	@Before
	public void setUp() {
		presentation = new ScorePresentation(new BowlingGame());
	}

	@Test
	public void getScore_noSparesOrStrikes_shouldProduceCorrectString() {
		// arrange
		BowlingGame game = new BowlingGame();
		game.nextThrow(1);
		game.nextThrow(2);
		game.nextThrow(3);
		game.nextThrow(4);
		game.nextThrow(5);
		game.nextThrow(1);
		game.nextThrow(2);
		game.nextThrow(3);
		game.nextThrow(4);
		game.nextThrow(5);
		game.nextThrow(1);
		game.nextThrow(2);
		game.nextThrow(3);
		game.nextThrow(4);
		game.nextThrow(5);
		game.nextThrow(1);
		game.nextThrow(2);
		game.nextThrow(3);
		game.nextThrow(4);
		game.nextThrow(5);
		game.fillScorekeeper();
		presentation = new ScorePresentation(game);

		// act
		String result = presentation.getScore();

		// assert
		assertEquals("12345123451234512345", result);
	}

	@Test
	public void getScore_onlySpares_shouldProduceCorrectString() {
		// arrange
		BowlingGame game = new BowlingGame();
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.nextThrow(5);
		game.fillScorekeeper();
		presentation = new ScorePresentation(game);

		// act
		String result = presentation.getScore();

		// assert
		assertEquals("5/5/5/5/5/5/5/5/5/5/", result);
	}

	@Test
	public void getScore_withStrikes_shouldProduceCorrectString() {
		// arrange
		BowlingGame game = new BowlingGame();
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.nextThrow(10);
		game.fillScorekeeper();
		presentation = new ScorePresentation(game);

		// act
		String result = presentation.getScore();

		// assert
		assertEquals("XXXXXXXXXX", result);
	}

	@Test
	public void getScoreString_normalCase_shouldProduceCorrectString() {
		String scoreString1 = presentation.round2str("1", "1");
		String scoreString2 = presentation.round2str("1", "2");
		String scoreString3 = presentation.round2str("3", "4");
		assertEquals("11", scoreString1);
		assertEquals("12", scoreString2);
		assertEquals("34", scoreString3);
	}

	@Test
	public void getScoreString_spare_shouldProduceCorrectString() {
		String spare1 = presentation.round2str("0", "10");
		String spare2 = presentation.round2str("1", "9");
		String spare3 = presentation.round2str("5", "5");
		assertEquals("0/", spare1);
		assertEquals("1/", spare2);
		assertEquals("5/", spare3);
	}

	@Test
	public void getScoreString_strike_shouldProduceCorrectString() {
		String strike1 = presentation.round2str("10", "");
		String strike2 = presentation.round2str("10", "0");
		String strike3 = presentation.round2str("10", null);
		assertEquals("X", strike1);
		assertEquals("X", strike2);
		assertEquals("X", strike3);
	}
}
