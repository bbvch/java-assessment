package bowlinggame;

import java.util.ArrayList;
import java.util.List;


public class BowlingGame {

    int roundNumber = 0;
    
    GameRound currentRound;
    public List<GameRound> allGameRounds = new ArrayList<GameRound>();
    public String[][] scorekeeper = new String[11][2];
    
    private ScorePresentation scorePresentation;

    public BowlingGame() {
    }

    public List<GameRound> getAllGameRounds() {
        return allGameRounds;
    }

    int _throws = 0;
    public void nextThrow(int amountKnockedDown) {
    	++_throws;
    	if(amountKnockedDown == 10){
    		++_throws;
    	}
        if (currentRound == null) {
            currentRound = new GameRound();
        }
        currentRound.addScore(String.valueOf(amountKnockedDown));
        
        
        if(_throws == 2){
        	currentRound.setRoundFinished(true);
        	_throws = 0;
        }
        
        if (currentRound.isRoundFinished()) {
            GameRound tempList = currentRound;
            allGameRounds.add(tempList);
            currentRound = null;
        }
    }
    
    
    public void fillScorekeeper() {
        for (int i = 0; i < allGameRounds.size(); i++) {
            int j = 0;
            scorekeeper[i][j] = allGameRounds.get(i).getScore1();
            scorekeeper[i][j + 1] = allGameRounds.get(i).getScore2();
        }
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setPresentation(ScorePresentation scorePresentation) {
        this.scorePresentation = scorePresentation;
    }

    public ScorePresentation getPresentation() {
        return scorePresentation;
    }

}
