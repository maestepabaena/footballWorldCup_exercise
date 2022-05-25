package es.maestepabaena.footballworldcup.model;

public class Game {

        String homeTeam;
        String awayTeam;
        int homeScore;
        int awayScore;

        public Game(String homeTeam, String awayTeam) {
                this.homeTeam=homeTeam;
                this.awayTeam=awayTeam;
                this.homeScore=0;
                this.awayScore=0;
        }

        public String getHomeTeam() {
                return homeTeam;
        }

        public void setHomeTeam(String homeTeam) {
                this.homeTeam = homeTeam;
        }

        public String getAwayTeam() {
                return awayTeam;
        }

        public void setAwayTeam(String awayTeam) {
                this.awayTeam = awayTeam;
        }

        public int getHomeScore() {
                return homeScore;
        }

        public void setHomeScore(int homeScore) {
                this.homeScore = homeScore;
        }

        public int getAwayScore() {
                return awayScore;
        }

        public void setAwayScore(int awayScore) {
                this.awayScore = awayScore;
        }

        @Override public String toString() {
                return homeTeam+ " - " + awayTeam + " : "+ homeScore+ "-"+ awayScore;
        }
}
