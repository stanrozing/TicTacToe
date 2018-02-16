package com.example.rozin.tictactoe;

/**
 * Created by rozin on 15-2-2018.
 */

public class Game {

    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
        movesPlayed = 0;
    }
    public Tile draw(int row, int column) {
        if (board[row][column] == Tile.BLANK) {
            if (playerOneTurn) {
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                movesPlayed += 1;
                return Tile.CROSS;
            } else {
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                movesPlayed += 1;
                return Tile.CIRCLE;
            }
        }
        else {
            return Tile.INVALID;
        }
    }
    public GameState Gamewon() {
        if (gameOver == false) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                    if (board[i][0] == Tile.CROSS) {
                        gameOver = true;
                        return GameState.PLAYER_ONE;
                    }
                    if (board[i][0] == Tile.CIRCLE) {
                        gameOver = true;
                        return GameState.PLAYER_TWO;
                    }
                }
            }
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                    if (board[0][j] == Tile.CROSS) {
                        gameOver = true;
                        return GameState.PLAYER_ONE;
                    }
                    if (board[0][j] == Tile.CIRCLE) {
                        gameOver = true;
                        return GameState.PLAYER_TWO;
                    }
                }
            }
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                if (board[0][0] == Tile.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                }
                if (board[0][0] == Tile.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            }
            if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                if (board[0][2] == Tile.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                }
                if (board[0][2] == Tile.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            }
            if (movesPlayed == 9) {
                return GameState.DRAW;
            } else {
                return GameState.IN_PROGRESS;
            }
        }
        else {
            return GameState.OVER;
        }
    }

}
