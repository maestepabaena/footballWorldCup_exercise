package es.maestepabaena.footballworldcup.model;

public class Game {

        String homeTeam;
        String awayTeam;
        GameScore score;

        public Game(String homeTeam, String awayTeam) {
                this.homeTeam=homeTeam;
                this.awayTeam=awayTeam;
                this.score= new GameScore(0,0);
        }

        public String getHomeTeam() {
                return homeTeam;
        }

        public String getAwayTeam() {
                return awayTeam;
        }

        public void setHomeScore(int homeScore) {
                this.score.homeScore = homeScore;
        }

        public void setAwayScore(int awayScore) {
                this.score.awayScore = awayScore;
        }

        @Override public String toString() {
                return homeTeam+ " - " + awayTeam + " : "+ score.homeScore+ "-"+ score.awayScore;
        }
}
