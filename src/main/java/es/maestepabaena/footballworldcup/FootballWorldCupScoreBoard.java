package es.maestepabaena.footballworldcup;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCupScoreBoard {

        private List<String> scoreBoard = new ArrayList<>();

        public void startGame(String homeTeam, String awayTeam) {
                scoreBoard.add(homeTeam +" - "+awayTeam + " : "+ "0-0");
        }

        public List<String> getScoreBoard() {
                return scoreBoard;
        }

        public void finishGame(String homeTeam, String awayTeam) {
                scoreBoard.remove(0);
        }

        public Object getSummary() {
                String summary="";
                for (String game :scoreBoard) {
                        summary+=game+"\n";
                }
                return  summary;
        }
}

