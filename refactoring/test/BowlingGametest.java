
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import bowlinggame.BowlingGame;
import bowlinggame.GameRound;

public class BowlingGametest {

    private BowlingGame game;

    @Before
    public void setUp() {
        game = new BowlingGame();
    }
    
    @Test
    public void ifBallsHaveBeenThrown_thenGameRoundListIsAlwaysCorrectlyUpdated() {
        
        // Arrange
        game.nextThrow(0);
        game.nextThrow(4);
        
        game.nextThrow(10);
        
        game.nextThrow(3);
        game.nextThrow(6);
        
        // Act
        game.fillScorekeeper();
       
        //Assert
        assertThat(game.allGameRounds.size(), is(3));
        assertThat(game.allGameRounds.get(0).getScore1(), is("0"));
        assertThat(game.allGameRounds.get(0).getScore2(), is("4"));
        assertThat(game.allGameRounds.get(1).getScore1(), is("X"));
        assertThat(game.allGameRounds.get(1).getScore2(), is(""));
        assertThat(game.allGameRounds.get(2).getScore1(), is("3"));
        assertThat(game.allGameRounds.get(2).getScore2(), is("6"));
    }

    @Test
    public void ifFillScoreKeeperIsCalled_thenGameRoundsAreProperlyCopied() {
        
        // Arrange
        game.allGameRounds.add(new GameRound("3", "2"));
        game.allGameRounds.add(new GameRound("X", "0"));
        game.allGameRounds.add(new GameRound("4", "5"));
        
        // Act
        game.fillScorekeeper();
       
        //Assert
        assertThat(game.scorekeeper[0][0], is("3"));
        assertThat(game.scorekeeper[0][1], is("2"));
        assertThat(game.scorekeeper[1][0], is("X"));
        assertThat(game.scorekeeper[1][1], is("0"));
        assertThat(game.scorekeeper[2][0], is("4"));
        assertThat(game.scorekeeper[2][1], is("5"));
    }

}
