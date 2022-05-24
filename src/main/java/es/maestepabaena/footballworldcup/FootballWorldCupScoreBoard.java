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
}

