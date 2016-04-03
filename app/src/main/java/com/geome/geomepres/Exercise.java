package com.geome.geomepres;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Exercise extends AppCompatActivity {

    TextView timer;
    Button guess1;
    Button guess2;
    Button guess3;
    Button guess4;
    Button next;



    int correctAnswer;
//    timerClass counter = new timerClass(20000, 1000);
    timerClass counter;

    int[] pics;
    String[] questions;
    String[][] answers;
    int[] correctAnswerIndex;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        index = 0;
        pics = new int[5];
        pics[0] = R.drawable.clock;
        pics[1] = R.drawable.chunky;
        pics[2] = R.drawable.building;
        pics[3] = R.drawable.mac;
        pics[4] = R.drawable.map;
        questions = new String[5];
        questions[0] = "If the time is 3:15 what is the angle between the hour hand and the minute hand?";
        questions[1] = "How many acute angles do the letters form?";
        questions[2] = "What kind of polygon is in this photo?";
        questions[3] = "Find the obtuse angle:";
        questions[4] = "There are four points in this line, which point is Australia in?";

        answers = new String[5][4];
        correctAnswerIndex = new int[5];
        answers[0][0] = "0";
        answers[0][1] = "7.5";
        answers[0][2] = "5";
        answers[0][3] = "1";
        correctAnswerIndex[0] = 2;

        answers[1][0] = "3";
        answers[1][1] = "7";
        answers[1][2] = "4";
        answers[1][3] = "5";
        correctAnswerIndex[1] = 4;

        answers[2][0] = "Prism";
        answers[2][1] = "Circle";
        answers[2][2] = "Sphere";
        answers[2][3] = "Celinder";
        correctAnswerIndex[2] = 3;

        answers[3][0] = "Laptop";
        answers[3][1] = "Board";
        answers[3][2] = "Table";
        answers[3][3] = "Stapler";
        correctAnswerIndex[3] = 1;

        answers[4][0] = "A";
        answers[4][1] = "B";
        answers[4][2] = "C";
        answers[4][3] = "D";
        correctAnswerIndex[4] = 4;



//        timer = (TextView) findViewById(R.id.timer);
//        timer.setText("15 SEC"); // just for presentation we will give 15 secs to explain
//        counter.start();

        guess1 = (Button) findViewById(R.id.guess1);
        guess2 = (Button) findViewById(R.id.guess2);
        guess3 = (Button) findViewById(R.id.guess3);
        guess4 = (Button) findViewById(R.id.guess4);
        next = (Button) findViewById(R.id.nextButton);

        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                init();
            }
        });

        guess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 1) {
                    guess1.setBackgroundColor(Color.GREEN);
                }
                else {
                    guess1.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                counter.cancel();
            }
        });

        guess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 2) {
                    guess2.setBackgroundColor(Color.GREEN);
                }
                else {
                    guess2.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                counter.cancel();

            }
        });

        guess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 3) {
                    guess3.setBackgroundColor(Color.GREEN);
                }
                else {
                    guess3.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                counter.cancel();

            }
        });

        guess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 1) {
                    guess4.setBackgroundColor(Color.GREEN);
                }
                else {
                    guess4.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                counter.cancel();

            }
        });
    }

    private void paintCorrectButton()
    {
        switch (correctAnswer) {
            case 1:
                guess1.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                guess2.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                guess3.setBackgroundColor(Color.GREEN);
                break;
            default:
                guess4.setBackgroundColor(Color.GREEN);
        }
    }

    private void cutAnswer() {
        if(guess3.getVisibility() == View.VISIBLE && correctAnswer != 3) {
            guess3.setVisibility(View.INVISIBLE);
        }
        else if(guess2.getVisibility() == View.VISIBLE && correctAnswer != 2) {
            guess2.setVisibility(View.INVISIBLE);
        }
        else if(guess4.getVisibility() == View.VISIBLE && correctAnswer != 4) {
            guess4.setVisibility(View.INVISIBLE);
        }
        else if(guess1.getVisibility() == View.VISIBLE && correctAnswer != 1) {
            guess1.setVisibility(View.INVISIBLE);
        }
    }

    private void init() {
        if (index < pics.length) {
            guess1.setBackgroundColor(Color.GRAY);
            guess2.setBackgroundColor(Color.GRAY);
            guess3.setBackgroundColor(Color.GRAY);
            guess4.setBackgroundColor(Color.GRAY);
            guess1.setVisibility(View.VISIBLE);
            guess2.setVisibility(View.VISIBLE);
            guess3.setVisibility(View.VISIBLE);
            guess4.setVisibility(View.VISIBLE);
            guess1.setEnabled(true);
            guess2.setEnabled(true);
            guess3.setEnabled(true);
            guess4.setEnabled(true);
            timer = (TextView) findViewById(R.id.timer);
            timer.setText("20 SEC"); // just for presentation we will give 15 secs to explain
            counter = new timerClass(20000, 1000);
            counter.start();
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(pics[index]);
            TextView question = (TextView) findViewById(R.id.question);
            question.setText(questions[index]);
            guess1.setText(answers[index][0]);
            guess2.setText(answers[index][1]);
            guess3.setText(answers[index][2]);
            guess4.setText(answers[index][3]);
            correctAnswer = correctAnswerIndex[index];
            index++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class timerClass extends CountDownTimer {


        public timerClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String sec = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
            timer.setText(sec + " SEC");
            if (sec.equals("12")) cutAnswer();
            if (sec.equals("06")) cutAnswer();
        }

        @Override
        public void onFinish() {
            paintCorrectButton();
            guess1.setEnabled(false);
            guess2.setEnabled(false);
            guess3.setEnabled(false);
            guess4.setEnabled(false);
            counter.cancel();

        }
    }


}
