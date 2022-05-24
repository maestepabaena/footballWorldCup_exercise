package es.maestepabaena.footballworldcup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        public void store_matchData_when_startGameIsCalled(){
                //given
                FootballWorldCupScoreBoard scoreBoard = new FootballWorldCupScoreBoard();

                //when
                scoreBoard.startGame("homeTeam","awayTeam");

                //then
                assertEquals("homeTeam - awayTeam : 0-0",scoreBoard.getScoreBoard().get(0));
        }

        @Test
        public void remove_match_when_finishGameIsCalled(){
                //given
                FootballWorldCupScoreBoard scoreBoard = new FootballWorldCupScoreBoard();

                //when
                scoreBoard.startGame("homeTeam","awayTeam");

                //then
                assertEquals("homeTeam - awayTeam : 0-0",scoreBoard.getScoreBoard().get(0));

                //when
                scoreBoard.finishGame("homeTeam","awayTeam");

                //then
                assertTrue(scoreBoard.getScoreBoard().isEmpty());
        }
}