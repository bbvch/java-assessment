/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

/**
 * 
 * @author danieltiefenauer
 */
public class ScorePresentation {
	
	public BowlingGame game;
    
	public ScorePresentation(BowlingGame game){
		this.game = game;
		game.setPresentation(this);
	}
	
	String[] currentRound;
	
	/**
	 * gets the score
	 * @return the score
	 */
        
                      public void printRoundScores()
                      {
                          System.out.println(getScore());
                      }
        
	public String getScore(){		
		score = "";
		String firstThrow = "", secondThrow = "";

		for(int i=0; i<game.scorekeeper.length; i++){
			currentRound = game.scorekeeper[i];			
			for(int j=0; j<currentRound.length; j++){

				if (currentRound.length == 2){
					if (currentRound[0] != null){
						firstThrow = currentRound[0];
					}
					else{
						firstThrow = null;
					}
					if (currentRound[1] != null){
						secondThrow = currentRound[1];
					}
					else{
						secondThrow = null;
					}
				}
				else if (currentRound.length == 1){
					firstThrow = currentRound[0];
				}
				else if (currentRound.length == 0){
					
				}
				else {
					throw new RuntimeException("game is invalid");
				}
			}
			score += round2str(firstThrow, secondThrow);
		}
                                            
		return score;
	}


	/**
	 * This method calculates the score of two throws
	 * @param firstThrow first throw
	 * @param secondThrow second throw
	 * @return the score
	 */
	public String round2str(String firstThrow, String secondThrow) { 
		int points1 = 0;
		int points2 = 0;
                
                                            
	
		if(firstThrow == null || secondThrow == null){
			if(firstThrow == null && secondThrow == null) return "";
			
			if(firstThrow == null) firstThrow = "-";
                                                                  
			if(secondThrow == null) secondThrow = "-"; 
			
		}
                
                                            if(firstThrow.equals("X")) firstThrow = "10"; 
                                            if(secondThrow.equals("/")) secondThrow = "5"; 
		
		try{
			points1 = Integer.parseInt(firstThrow);			
		}
		catch(Exception e){
			System.out.println("invalid number: " + firstThrow + e.getMessage());; 
		}
		try{
			points2 = Integer.parseInt(secondThrow);
		}
		catch(Exception e){
			System.out.println("invalid number: " + secondThrow + e.getMessage());; 
		}
		
		if (points1 + points2 == 10 && points1 == 10 ){
			return "X"; 
		}
		
		
		if (points1 + points2 == 10 && points1 != 10 ){
			return "" + points1 + "/";
		}

		return "" + points1 + "" + points2;
	}

	String score = "dummy Score";
        
}




