package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0 for yellow, 1 for red, 2 for empty view
    int currentUser = 0;
    int[] currentGame = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean isGameFinished = true;
    boolean doesSomeoneWin = false;


    public void dropIn(View view) {

        for(int i=0; i <  currentGame.length; i++){
            if(currentGame[i] == 2){
                isGameFinished = false;
            }
        }

        if(isGameFinished == false && doesSomeoneWin == false){
            ImageView toss = (ImageView) view;
            int tag = Integer.parseInt(toss.getTag().toString());

            if(currentGame[tag] ==2 ){
                toss.setTranslationY(-1500);

                String stringCurrentUser = "";
                if(currentUser==0){
                    toss.setImageResource(R.drawable.yellow);
                    currentGame[tag] = currentUser;
                    stringCurrentUser = "Yellow";
                    currentUser = 1;
                }else{
                    toss.setImageResource(R.drawable.red);
                    currentGame[tag] = currentUser;
                    stringCurrentUser = "Red";
                    currentUser = 0;
                }
                toss.animate().translationYBy(1500).rotation(1800);


                //Controls whether who wins

                //Controls the columns
                for(int i=0; i<3; i++){
                    if(currentGame[i]!= 2 && currentGame[i] == currentGame[i+3] && currentGame[i] == currentGame[i+6]){
                        doesSomeoneWin = true;

                        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                        TextView playAgainText = (TextView) findViewById(R.id.playAgainText);

                        playAgainText.setText(stringCurrentUser + " won!");

                        playAgainButton.setVisibility(View.VISIBLE);
                        playAgainText.setVisibility(View.VISIBLE);
                    }
                }

                //Controls the rows
                for(int i = 0; i <7; i +=3){
                    if(currentGame[i] != 2 && currentGame[i]==currentGame[i+1] && currentGame[i] == currentGame[i+2]){
                        doesSomeoneWin = true;

                        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                        TextView playAgainText = (TextView) findViewById(R.id.playAgainText);

                        playAgainText.setText(stringCurrentUser + " won!");

                        playAgainButton.setVisibility(View.VISIBLE);
                        playAgainText.setVisibility(View.VISIBLE);
                    }
                }

                //Controls cross lines
                for(int i = 0; i < 3; i +=2){
                    if(i==0){
                        if(currentGame[i] !=2 && currentGame[i] == currentGame[i+4] && currentGame[i] == currentGame[i+8]){
                            doesSomeoneWin = true;
                            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                            TextView playAgainText = (TextView) findViewById(R.id.playAgainText);

                            playAgainText.setText(stringCurrentUser + " won!");

                            playAgainButton.setVisibility(View.VISIBLE);
                            playAgainText.setVisibility(View.VISIBLE);
                        }
                    }else{
                        if(currentGame[i] !=2 && currentGame[i] == currentGame[i+2] && currentGame[i] == currentGame[i+4]){
                            doesSomeoneWin = true;
                            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                            TextView playAgainText = (TextView) findViewById(R.id.playAgainText);

                            playAgainText.setText(stringCurrentUser + " won!");

                            playAgainButton.setVisibility(View.VISIBLE);
                            playAgainText.setVisibility(View.VISIBLE);
                        }
                    }

                }
            }
        }



    }



    public void playAgain(View view){

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView playAgainText = (TextView) findViewById(R.id.playAgainText);
        playAgainButton.setVisibility(View.INVISIBLE);
        playAgainText.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView toss = (ImageView) gridLayout.getChildAt(i);
            toss.setImageDrawable(null);
        }
        currentUser = 0;
        for(int i=0; i<currentGame.length; i++){
            currentGame[i] = 2;
        }
        isGameFinished = true;
        doesSomeoneWin = false;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}