package es.maestepabaena.footballworldcup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

import es.maestepabaena.footballworldcup.model.Game;
import es.maestepabaena.footballworldcup.model.GameScore;

public class FootballWorldCupScoreBoard {

  private List<Game> scoreBoard = new ArrayList<>();

  public void startGame(String homeTeam, String awayTeam) {
    Game game = new Game(homeTeam, awayTeam);
    scoreBoard.add(game);
  }

  public List<Game> getScoreBoard() {
    return scoreBoard;
  }

  public void finishGame(String homeTeam, String awayTeam) {
    scoreBoard.remove(0);
  }

  public Object getSummary() {
    String summary = "";
    Queue<Game> lifoQueue = Collections.asLifoQueue(new ArrayDeque<>());
    for (Game game: scoreBoard) {
      lifoQueue.add(game);
    }
    while (!lifoQueue.isEmpty()) {
      Game maxGameScore = lifoQueue.stream().max(Comparator.comparing(Game::getToTalScore)).orElse(null);
      summary = summary + summaryGameFormatter(maxGameScore);
      lifoQueue.remove(maxGameScore);
    }
    return summary;
  }

  private String summaryGameFormatter(Game game) {
    return game.getHomeTeam() + " " + game.getHomeScore() + " - " + game.getAwayTeam() + " " + game.getAwayScore()
        + "\n";
  }

  public void updateScore(String homeTeam, String awayTeam, GameScore score) {
    for (int i = 0, scoreBoardSize = scoreBoard.size(); i < scoreBoardSize; i++) {
      Game game = scoreBoard.get(i);
      if (game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)) {
        game.setHomeScore(score.getHomeScore());
        game.setAwayScore(score.getAwayScore());
        scoreBoard.set(i, game);
      }

    }
  }
}
