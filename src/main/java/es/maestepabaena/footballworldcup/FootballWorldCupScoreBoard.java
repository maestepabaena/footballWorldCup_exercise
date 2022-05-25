package es.maestepabaena.footballworldcup;

import java.util.ArrayList;
import java.util.List;

import es.maestepabaena.footballworldcup.model.Game;

public class FootballWorldCupScoreBoard {

  private List<Game> scoreBoard = new ArrayList<>();

  public void startGame(String homeTeam, String awayTeam) {
    Game game= new Game(homeTeam,awayTeam);
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
    for (Game game : scoreBoard) {
      summary += game + "\n";
    }
    return summary;
  }

  public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    for (int i = 0, scoreBoardSize = scoreBoard.size(); i < scoreBoardSize; i++) {
      Game game = scoreBoard.get(i);
      if (game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)) {
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
        scoreBoard.set(i, game);
      }

    }
  }
}
