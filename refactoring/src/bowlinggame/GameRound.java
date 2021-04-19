/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

import java.util.List;

public class GameRound {

	String score1 = "";
	String score2 = "";

	public void setScore1(String knockedDown1) {
		this.score1 = knockedDown1;
	}

	public void setScore2(String nbrOfDownedPins2) {
		this.score2 = nbrOfDownedPins2;
	}

	int roundPointsInt = 0;
	static boolean legalState = true;

	public int getRoundPointsInt() {
		return roundPointsInt;
	}

	String roundPointsString = "";
	int tempInt;
	boolean roundFinished;

	public GameRound() {
		roundFinished = false;
	}
        
                      public GameRound(String a, String b) {
		score1 = a;
                                            score2 = b;
	}

	/**
	 * Adds Score dependent on Pins knocked down
	 * 
	 * @param score
	 */
	public void addScore(String score) {
		if (roundFinished != true) {
			if (score1.isEmpty()) {
				if (score.equals("0")) {
					score1(score);
				} else if (0 < Integer.parseInt(score) && Integer.parseInt(score) < 10) {
					score1(score);
				} else if (score.equals("10")) {
					score1("X");
				}
				boolean b = increaseRoundPoints(score);
				if (roundPointsInt > 10) {
					failure();
				}
			} else {
				if (score.equals("0")) {
					score2 = "-";
				} else if (0 < Integer.parseInt(score) && !(Integer.parseInt(score) > 10)) {
					score2 = score;
				}
				roundPointsInt += Integer.parseInt(score);
				if (roundPointsInt == 10) {
					score2 = "/";
				} else if (roundPointsInt > 10) {
					failure();
				}
                                                                                        roundFinished = true;
			}
		}
	}

	/**
	 * Do NOT DELETE!
	 */
	public static void printGameScore(BowlingGame currentGame, List<GameRound> previousRounds, int currentPoints,
			boolean roundFinished) {
		// WICHTIG Ohne diese Informationen wirft ScorePresentation eine
		// Exception!
		if ((currentGame != null) && (previousRounds != null) && (currentPoints > 0) && legalState == true
				&& !roundFinished == false) {
			ScorePresentation p = new ScorePresentation(currentGame);
			p.getScore();
		}
	}

	/**
	 * get Score of 1st Throw
	 * 
	 * @return
	 */
	public String getScore1() {
		return score1;
	}

	public void score1(String newValue) {
		score1 = newValue;
		if (newValue.equals("X")) {
			setRoundFinished(true);
		}
	}

	/**
	 * get Score of 2nd Throw
	 * 
	 * @return
	 */
	public String getScore2() {
		return score2;
	}

	/**
	 * Tells us if the Round is Finished
	 * 
	 * @return
	 */
	public boolean isRoundFinished() {
		return roundFinished;
	}

	/**
	 * You can tell here, if the Round is finished or not
	 * 
	 * @param roundFinished
	 */
	public void setRoundFinished(boolean roundFinished) {
		this.roundFinished = roundFinished;
	}

	/**
	 * Attention, too many pins were shot
	 */
	public void failure() {
		if (roundPointsInt > 10) {
			throw new IllegalGameState("Unimplemented Special Case found");
		}
	}

	private boolean increaseRoundPoints(String a) {
		tempInt = roundPointsInt;
		tempInt = tempInt + Integer.parseInt(a);
		roundPointsInt = tempInt;
		return true;
	}

	public String pointsIntToPointsString(int points) {
		switch (points) {
		case 10:
			roundPointsString = "X";
			break;
		case 5:
			roundPointsString = "/";
			break;
		default:
			roundPointsString = Integer.toString(points);
			break;
		}
		return roundPointsString;

	}

	public class IllegalGameState extends RuntimeException {

		public IllegalGameState() {
		}

		public IllegalGameState(String message) {
			super(message + "Max 10 Pins are possible");
		}

	}

}
