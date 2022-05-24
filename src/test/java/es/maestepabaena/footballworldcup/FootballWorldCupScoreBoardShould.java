package es.maestepabaena.footballworldcup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * A sport data company would like to develop a new Live Football World Cup Score Board that shows matches and scores
 * It should support the following operations:
 * 1. startGame -> We receive the game data: Home team, AwayTeam and score data: 0-0
 * 2. finishGame -> Remove match from the scoreBoard
 * 3. updateScore -> Receiving a pair of score (home and away team) update the gameScore
 * 4. getSummary -> Summary of games by total score ordered by the most recently added to the system
 *
 **/


public class FootballWorldCupScoreBoardShould {

        @Test
        public void return_0_0_when_startGameIsCalled(){
                //given
                FootballWorldCupScoreBoard scoreBoard = new FootballWorldCupScoreBoard();

                //when
                String score= scoreBoard.startGame("homeTeam","awayTeam");

                //then
                assertEquals("0-0",score);
        }
}