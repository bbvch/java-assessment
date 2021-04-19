/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;

import bowlinggame.GameRound;
import org.junit.Assert;
/**
 *
 * @author romankieser
 */
public class GameRoundTest {
    
    GameRound testee;
    
    @Test
    public void addFirstThrow_score1EqualsThrow() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("7");
        String result = testee.getScore1();
        //Assert
        Assert.assertEquals("7", result);
    }
    
    @Test
    public void addSecondThrow_score2EqualsSecondThrow() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("3");
        testee.addScore("5");
        String result = testee.getScore2();
        //Assert
        Assert.assertEquals("5", result);
    }
    
    @Test
    public void ifStrike_score1EqualsX() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("10");
        String result = testee.getScore1();
        //Assert
        Assert.assertEquals("X", result);
    }
     @Test
    public void ifSpare_score2EqualsSlash() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("0");
        testee.addScore("10");
        String result = testee.getScore2();
        //Assert
        Assert.assertEquals("/", result);
    }
    
     @Test
    public void ifSpare2_score2EqualsSlash() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("3");
        testee.addScore("7");
        String result = testee.getScore2();
        //Assert
        Assert.assertEquals("/", result);
    }
    
    @Test(expected = GameRound.IllegalGameState.class)
    public void ifMoreThanTenPinsOnFirstThrow_returnException() {
        boolean thrown = false;
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("15");
    }
    
     @Test(expected = GameRound.IllegalGameState.class)
    public void ifMoreThanTenPinsOnBothThrowsCombined_returnException() {
        boolean thrown = false;
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("6");
        testee.addScore("6");
    }
    
    @Test
    public void ifStrike_ThenRoundShouldBeFinished() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("10");
        Boolean result = testee.isRoundFinished();
        //Assert
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void ifNoStrikeAndOnlyOneThrow_ThenRoundShouldNotBeFinished() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("8");
        Boolean result = testee.isRoundFinished();
        //Assert
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void afterTwoThrows_ThenRoundShouldBeFinished()
    {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("3");
        testee.addScore("5");
        Boolean result = testee.isRoundFinished();
        //Assert
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void ifTwoLegalThrows_ThenCombinedRoundScore() {
        //Arrange
        testee = new GameRound();
        //Act
        testee.addScore("2");
        testee.addScore("2");
        String result = testee.pointsIntToPointsString(testee.getRoundPointsInt());
        //Assert
        Assert.assertEquals("4", result);
    }
    

    
    
}
