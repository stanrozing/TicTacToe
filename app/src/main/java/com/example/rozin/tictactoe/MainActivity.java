package com.example.rozin.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;
    int row;
    int column;
    int[] buttons = {R.id.button0, R.id.button1, R.id.button2, R.id.button10, R.id.button11,
                        R.id.button12, R.id.button20, R.id.button21, R.id.button22};
    int[][] coordinates = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
    int length = buttons.length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void TileClicked(View view) {
        int id = view.getId();
        for (int i = 0; i < length; i++) {
            if (id == buttons[i]) {
                row = coordinates[i][0];
                column = coordinates[i][1];
            }
        }

        Tile tile = game.draw(row, column);
        Button button = (Button) view;


        switch(tile) {
            case CROSS:
                button.setText("x");
                break;
            case CIRCLE:
                button.setText("o");
                break;
            case INVALID:
                break;
        }
        TextView text = findViewById(R.id.textView);
        GameState winner = game.Gamewon();

        switch(winner) {
            case PLAYER_ONE:
                text.setText("Player 1 wins!");
                break;
            case PLAYER_TWO:
                text.setText("Player 2 wins!");
                break;
            case DRAW:
                text.setText("It's a draw! =(");
                break;
            case IN_PROGRESS:
                text.setText("Game in progress...");
        }
    }

    public void ResetClicked(View view) {
        game = new Game();
        for (int j = 0; j < length; j++){
            Button button = findViewById(buttons[j]);
            button.setText("");
        }
        TextView text = findViewById(R.id.textView);
        text.setText("");


    }


}
