package es.maestepabaena.footballworldcup;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * A sport data company would like to develop a new Live Football World Cup Score Board that shows matches and scores It
 * should support the following operations: 1. startGame -> We receive the game data: Home team, AwayTeam and score
 * data: 0-0 2. finishGame -> Remove match from the scoreBoard 3. updateScore -> Receiving a pair of score (home and
 * away team) update the gameScore 4. getSummary -> Summary of games by total score ordered by the most recently added
 * to the system
 **/
public class FootballWorldCupScoreBoardShould {

  private FootballWorldCupScoreBoard scoreBoard;

  @Before
  public void setUp() {
    scoreBoard = new FootballWorldCupScoreBoard();
  }

  @Test
  public void store_matchData_when_startGameIsCalled() {

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");

    // then
    assertEquals("homeTeam - awayTeam : 0-0", scoreBoard.getScoreBoard().get(0).toString());
  }

  @Test
  public void store_matchesData_when_twoGamesStart() {

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");
    scoreBoard.startGame("homeTeam2", "awayTeam2");

    // then
    assertEquals("homeTeam - awayTeam : 0-0", scoreBoard.getScoreBoard().get(0).toString());
    assertEquals("homeTeam2 - awayTeam2 : 0-0", scoreBoard.getScoreBoard().get(1).toString());
  }

  @Test
  public void remove_match_when_finishGameIsCalled() {

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");

    // then
    assertEquals("homeTeam - awayTeam : 0-0", scoreBoard.getScoreBoard().get(0).toString());

    // when
    scoreBoard.finishGame("homeTeam", "awayTeam");

    // then
    assertTrue(scoreBoard.getScoreBoard().isEmpty());
  }

  @Test
  public void remove_TwoMatches_when_TwoGamesHasFinished() {

    scoreBoard.startGame("homeTeam", "awayTeam");
    scoreBoard.startGame("homeTeam2", "awayTeam2");

    // then
    assertEquals("homeTeam - awayTeam : 0-0", scoreBoard.getScoreBoard().get(0).toString());
    assertEquals("homeTeam2 - awayTeam2 : 0-0", scoreBoard.getScoreBoard().get(1).toString());

    // when
    scoreBoard.finishGame("homeTeam", "awayTeam");
    scoreBoard.finishGame("homeTeam2", "awayTeam2");

    // then
    assertTrue(scoreBoard.getScoreBoard().isEmpty());
  }

  @Test
  public void return_summaryData_when_severalGamesStart() {

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");
    scoreBoard.startGame("homeTeam2", "awayTeam2");
    scoreBoard.startGame("homeTeam3", "awayTeam3");

    // then
    assertThat(
        scoreBoard.getSummary(),
        is("homeTeam - awayTeam : 0-0\nhomeTeam2 - awayTeam2 : 0-0\nhomeTeam3 - awayTeam3 : 0-0\n"));

  }

  @Test
  public void return_updateGameInScoreBoard_when_newScoreIsGiven() {

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");
    scoreBoard.updateScore("homeTeam", "awayTeam", 1, 0);

    // then
    assertThat(scoreBoard.getSummary(), is("homeTeam - awayTeam : 1-0\n"));

  }

}