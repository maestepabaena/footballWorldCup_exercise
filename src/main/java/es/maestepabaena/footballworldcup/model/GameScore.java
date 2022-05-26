package es.maestepabaena.footballworldcup.model;

public class GameScore {
  int homeScore;
  int awayScore;

  public GameScore(int homeScore, int awayScore) {
    this.homeScore = homeScore;
    this.awayScore = awayScore;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
  }

}
