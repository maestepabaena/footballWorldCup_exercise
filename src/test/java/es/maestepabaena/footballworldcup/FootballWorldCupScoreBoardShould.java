package es.maestepabaena.footballworldcup;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.maestepabaena.footballworldcup.model.GameScore;

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
        is("homeTeam3 0 - awayTeam3 0\nhomeTeam2 0 - awayTeam2 0\nhomeTeam 0 - awayTeam 0\n"));

  }

  @Test
  public void return_updateGameInScoreBoard_when_newScoreIsGiven() {
    // given
    GameScore givenScore = new GameScore(1, 0);

    // when
    scoreBoard.startGame("homeTeam", "awayTeam");
    scoreBoard.updateScore("homeTeam", "awayTeam", givenScore);

    // then
    assertThat(scoreBoard.getSummary(), is("homeTeam 1 - awayTeam 0\n"));

  }

  @Test
  public void return_properSummary_when_aGameIsStartedUpdatedAndFinished() {

    scoreBoard.startGame("Spain", "England");
    assertThat(scoreBoard.getSummary(), is("Spain 0 - England 0\n"));
    scoreBoard.updateScore("Spain", "England", new GameScore(1, 0));
    assertThat(scoreBoard.getSummary(), is("Spain 1 - England 0\n"));
    scoreBoard.finishGame("Spain", "England");
    assertThat(scoreBoard.getSummary(), is(""));
  }

  @Test
  public void return_orderedSummary_when_severalGamesWereStartedUpdatedAndFinished() {

    scoreBoard.startGame("Spain", "England");
    scoreBoard.startGame("Brazil", "Argentina");
    scoreBoard.startGame("Germany", "Russia");
    assertThat(scoreBoard.getSummary(), is("Germany 0 - Russia 0\nBrazil 0 - Argentina 0\nSpain 0 - England 0\n"));
    scoreBoard.updateScore("Spain", "England", new GameScore(1, 0));
    scoreBoard.updateScore("Brazil", "Argentina", new GameScore(1, 5));
    assertThat(scoreBoard.getSummary(), is("Brazil 1 - Argentina 5\nSpain 1 - England 0\nGermany 0 - Russia 0\n"));
    scoreBoard.finishGame("Spain", "England");
    assertThat(scoreBoard.getSummary(), is("Brazil 1 - Argentina 5\nGermany 0 - Russia 0\n"));
    scoreBoard.updateScore("Germany","Russia",new GameScore(3,3));
    assertThat(scoreBoard.getSummary(), is("Germany 3 - Russia 3\nBrazil 1 - Argentina 5\n"));
    scoreBoard.updateScore("Brazil","Argentina", new GameScore(4,5));
    assertThat(scoreBoard.getSummary(), is("Brazil 4 - Argentina 5\nGermany 3 - Russia 3\n"));
  }

}