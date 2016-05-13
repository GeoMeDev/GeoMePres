package com.geome.geomepres;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.app.*;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;


import java.util.concurrent.TimeUnit;

public class Exercise extends FragmentActivity {

    TextView timer;
    TextView gameScore;
    static Button guess1;
    static Button guess2;
    static Button guess3;
    static Button guess4;
    static Button hint;
    Button next;
    int correctAnswer;
    timerClass counter = null;
    delayTimerClass delayTimer;

    int lives;

    AlertDialog.Builder dlgAlert;

    int score;
    int elapsedTime;

    int[] pics;
    String[] questions;
    String[][] answers;
    String[] explanation;

    int[] correctAnswerIndex;

    int index;
    TextView livesCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        lives = 5;
        livesCounter = (TextView) findViewById(R.id.lives);
        livesCounter.setText(Integer.toString(lives));
        score = 0;
        gameScore = (TextView) findViewById(R.id.score);
        gameScore.setText(Integer.toString(score));

        index = 0;
        pics = new int[38];
        pics[0] = R.drawable.sunglasses;
        pics[1] = R.drawable.clock_obtuse;
        pics[2] = R.drawable.electric_poll;
        pics[3] = R.drawable.battery;
        pics[4] = R.drawable.chunky;
        pics[5] = R.drawable.map_arrows;
        pics[6] = R.drawable.building_floors;
        pics[7] = R.drawable.shapes;
        pics[8] = R.drawable.wall;
        pics[9] = R.drawable.cans;
        pics[10] = R.drawable.building;
        pics[11] = R.drawable.clock_acute;
        pics[12] = R.drawable.livingroom;
        pics[13] = R.drawable.house;
        pics[14] = R.drawable.door_wooden;
        pics[15] = R.drawable.building_triangle;
        pics[16] = R.drawable.drawers;
        pics[17] = R.drawable.pyramid;
        pics[18] = R.drawable.bridge;
        pics[19] = R.drawable.building_sphere;
        pics[20] = R.drawable.laptop;
        pics[21] = R.drawable.map;
        pics[22] = R.drawable.quarter;
        pics[23] = R.drawable.flag;
        pics[24] = R.drawable.chunky;
        pics[25] = R.drawable.white_house;
        pics[26] = R.drawable.stove_top;
        pics[27] = R.drawable.advertisement;
        pics[28] = R.drawable.pool_balls;
        pics[29] = R.drawable.tent;
        pics[30] = R.drawable.two_buildings;
        pics[31] = R.drawable.chocolate;
        pics[32] = R.drawable.water_hiking;
        pics[33] = R.drawable.screenshot;
        pics[34] = R.drawable.map_points;
        pics[35] = R.drawable.cones;
        pics[36] = R.drawable.bubble_gum;
        pics[37] = R.drawable.bricks;

        questions = new String[38];
        questions[0] = "What kind of line is this?";
        questions[1] = "What angle do we get at 6:15?";
        questions[2] = "What kind of points are these points?";
        questions[3] = "What kind of shape does the battery form?";
        questions[4] = "How many ACUTE angles do the letters form?";
        questions[5] =	"What kind of line is this?";
        questions[6] = "What kind of line is this?";
        questions[7] = "The triangle in the photo is considered to be:";
        questions[8] = "What is the midpoint on the line?";
        questions[9] = "What kind of shape do the cans form?";
        questions[10] = "What kind of points are these?";
        questions[11] = "What angle do we get at 3:30?";
        questions[12] = "Find the obtuse angle:";
        questions[13] = "What angle is this roof top?";
        questions[14] = "What angle is shown?";
        questions[15] = "The picture above represents:";
        questions[16] = "What angles does the picture represent?";
        questions[17] = "How many triangles make up a pyramid?";
        questions[18] = "What type of triangle is this?";
        questions[19] = "What kind of polygon is in this photo?";
        questions[20] = "Find the OBTUSE angle:";
        questions[21] = "Which point is Australia in?";
        questions[22] = "What angle does this triangle have?";
        questions[23] = "The triangle in the photo is considered to be:";
        questions[24] = "How many OBTUSE angles do the letters form?";
        questions[25] = "The triangle in the photo is considered to be:";
        questions[26] = "Point D indicates which stove top?";
        questions[27] = "The triangle in the photo is considered to be:";
        questions[28] = "The triangle in the photo is considered to be:";
        questions[29] = "The picture above represents:";
        questions[30] = "The picture above represents:";
        questions[31] = "What kind of polygon is the chocolate wrapping?";
        questions[32] = "How many inches is this line?";
        questions[33] = "What is the midpoint on the line?";
        questions[34] = "How many points are on this line?";
        questions[35] = "What kind of polygon do the hats resemble?";
        questions[36] = "What kind of polygon do these balls resemble?";
        questions[37] = "What type of rectangles are these?";

        answers = new String[38][4];
        correctAnswerIndex = new int[38];
        answers[0][0] = "Congruent";
        answers[0][1] = "Simple line";
        answers[0][2] = "Ray line";
        answers[0][3] = "None";
        correctAnswerIndex[0] = 1;

        answers[1][0] = "360";
        answers[1][1] = "180";
        answers[1][2] = "Obtuse";
        answers[1][3] = "Acute";
        correctAnswerIndex[1] = 3;

        answers[2][0] = "Coplanar";
        answers[2][1] = "A point";
        answers[2][2] = "Collinear";
        answers[2][3] = "All";
        correctAnswerIndex[2] = 3;

        answers[3][0] = "Prismn";
        answers[3][1] = "Circle";
        answers[3][2] = "Sphere";
        answers[3][3] = "Cylinder";
        correctAnswerIndex[3] = 4;

        answers[4][0] = "5";
        answers[4][1] = "3";
        answers[4][2] = "7";
        answers[4][3] = "4";
        correctAnswerIndex[4] = 1;

        answers[5][0] = "Congruent";
        answers[5][1] = "Simple line";
        answers[5][2] = "Ray line";
        answers[5][3] = "None";
        correctAnswerIndex[5] = 1;

        answers[6][0] = "Congruent";
        answers[6][1] = "Simple line";
        answers[6][2] = "Ray line";
        answers[6][3] = "None";
        correctAnswerIndex[6] = 3;

        answers[7][0] = "Right angle";
        answers[7][1] = "Isosceles";
        answers[7][2] = "Scalene";
        answers[7][3] = "Acute";
        correctAnswerIndex[7] = 3;

        answers[8][0] = "A";
        answers[8][1] = "B";
        answers[8][2] = "C";
        answers[8][3] = "D";
        correctAnswerIndex[8] = 3;

        answers[9][0] = "Prism";
        answers[9][1] = "Circle";
        answers[9][2] = "Sphere";
        answers[9][3] = "Cylinder";
        correctAnswerIndex[9] = 4;

        answers[10][0] = "Collinear";
        answers[10][1] = "Coplanar";
        answers[10][2] = "A point";
        answers[10][3] = "All";
        correctAnswerIndex[10] = 1;

        answers[11][0] = "360";
        answers[11][1] = "180";
        answers[11][2] = "Obtuse";
        answers[11][3] = "Acute";
        correctAnswerIndex[11] = 4;

        answers[12][0] = "Chair";
        answers[12][1] = "Windows";
        answers[12][2] = "Brown pic";
        answers[12][3] = "Black pic";
        correctAnswerIndex[12] = 1;

        answers[13][0] = "Acute";
        answers[13][1] = "Obtuse";
        answers[13][2] = "Right Angle";
        answers[13][3] = "None";
        correctAnswerIndex[13] = 2;

        answers[14][0] = "Acute";
        answers[14][1] = "Obtuse";
        answers[14][2] = "Right Angle";
        answers[14][3] = "None";
        correctAnswerIndex[14] = 3;

        answers[15][0] = "Congruent Lines";
        answers[15][1] = "Congruent Angles";
        answers[15][2] = "Obtuse triangles";
        answers[15][3] = "Scalene triangles";
        correctAnswerIndex[15] = 2;

        answers[16][0] = "Vertical";
        answers[16][1] = "Acute";
        answers[16][2] = "Obtuse";
        answers[16][3] = "1 Right angle";
        correctAnswerIndex[16] = 1;

        answers[17][0] = "4";
        answers[17][1] = "3";
        answers[17][2] = "5";
        answers[17][3] = "None";
        correctAnswerIndex[17] = 1;

        answers[18][0] = "Right angle";
        answers[18][1] = "Obtuse";
        answers[18][2] = "Scalene";
        answers[18][3] = "Acute";
        correctAnswerIndex[18] = 1;

        answers[19][0] = "Sphere";
        answers[19][1] = "Prism";
        answers[19][2] = "Circle";
        answers[19][3] = "Cylinder";
        correctAnswerIndex[19] = 1;

        answers[20][0] = "Laptop";
        answers[20][1] = "Board";
        answers[20][2] = "Table";
        answers[20][3] = "Stapler";
        correctAnswerIndex[20] = 1;

        answers[21][0] = "A";
        answers[21][1] = "B";
        answers[21][2] = "C";
        answers[21][3] = "D";
        correctAnswerIndex[21] = 4;

        answers[22][0] = "Right";
        answers[22][1] = "Obtuse";
        answers[22][2] = "Scalene";
        answers[22][3] = "Acute";
        correctAnswerIndex[22] = 4;

        answers[23][0] = "Right angled";
        answers[23][1] = "Obtuse angled";
        answers[23][2] = "Scalened";
        answers[23][3] = "Isosceles";
        correctAnswerIndex[23] = 4;

        answers[24][0] = "3";
        answers[24][1] = "7";
        answers[24][2] = "4";
        answers[24][3] = "5";
        correctAnswerIndex[24] = 1;

        answers[25][0] = "Right angled";
        answers[25][1] = "Obtuse angled";
        answers[25][2] = "Scalened";
        answers[25][3] = "Acute";
        correctAnswerIndex[25] = 4;

        answers[26][0] = "1";
        answers[26][1] = "2";
        answers[26][2] = "3";
        answers[26][3] = "4";
        correctAnswerIndex[26] = 4;

        answers[27][0] = "Right angled";
        answers[27][1] = "Isosceles";
        answers[27][2] = "Scalened";
        answers[27][3] = "Acute angled";
        correctAnswerIndex[27] = 2;

        answers[28][0] = "Right angled";
        answers[28][1] = "Equilateral";
        answers[28][2] = "Scalened";
        answers[28][3] = "Isosceles";
        correctAnswerIndex[28] = 2;

        answers[29][0] = "Congruent lines";
        answers[29][1] = "Congruent triangles";
        answers[29][2] = "Congruent angles";
        answers[29][3] = "Scalene triangles";
        correctAnswerIndex[29] = 2;

        answers[30][0] = "Congruent lines";
        answers[30][1] = "Congruent triangles";
        answers[30][2] = "Congruent angles";
        answers[30][3] = "Scalene triangles";
        correctAnswerIndex[30] = 2;

        answers[31][0] = "Prism";
        answers[31][1] = "Circle";
        answers[31][2] = "Sphere";
        answers[31][3] = "Cylinder";
        correctAnswerIndex[31] = 1;

        answers[32][0] = "4";
        answers[32][1] = "1";
        answers[32][2] = "5";
        answers[32][3] = "None";
        correctAnswerIndex[32] = 1;

        answers[33][0] = "A";
        answers[33][1] = "B";
        answers[33][2] = "C";
        answers[33][3] = "D";
        correctAnswerIndex[33] = 3;

        answers[34][0] = "3";
        answers[34][1] = "1";
        answers[34][2] = "5";
        answers[34][3] = "2";
        correctAnswerIndex[34] = 1;

        answers[35][0] = "Prism";
        answers[35][1] = "Cone";
        answers[35][2] = "Sphere";
        answers[35][3] = "Celinder";
        correctAnswerIndex[35] = 2;

        answers[36][0] = "Prism";
        answers[36][1] = "Cone";
        answers[36][2] = "Sphere";
        answers[36][3] = "Cylinder";
        correctAnswerIndex[36] = 3;

        answers[37][0] = "Congruent Simi";
        answers[37][1] = "Congruent";
        answers[37][2] = "Sphere";
        answers[37][3] = "Cylinder";
        correctAnswerIndex[37] = 2;


        explanation = new String[38];
        explanation[0] = "Congruent segments are simple line segments that are equal in length";
        explanation[1] = "Obtuse angles are any angles greater than 90 degrees";
        explanation[2] = "Collinear Points are Points that lie on the same line";
        explanation[3] = "A cylinder is a solid geometric figure with straight parallel sides and a circular or oval cross section";
        explanation[4] = "Acute angles are any angle less than 90 degree";
        explanation[5] = "Congruent segments are simply line segments that are equal in length";
        explanation[6] = "A portion of a line that consists at one endpoint and extends in any particular direction";
        explanation[7] = "A scalene triangle is a triangle that has three unequal sides, such as those illustrated above";
        explanation[8] = "Midpoint is the point that divides a segment into two congruent segments";
        explanation[9] = "A cylinder is a solid geometric figure with straight parallel sides and a circular or oval cross section";
        explanation[10] = "Collinear points are points that lie on the same line";
        explanation[11] = "Acute angles are any angle less than 90 degree";
        explanation[12] = "Obtuse angles are any angle greater than 90 degree";
        explanation[13] = "Obtuse angles are any angle greater than 90 degree";
        explanation[14] = "A right angle is an angle of 90°, as in a corner of a square or at the intersection of two perpendicular straight lines";
        explanation[15] = "Congruent angles have the exact same measure";
        explanation[16] = "Vertical angles are two angles are vertical angles two pairs of opposite rays";
        explanation[17] = "A triangular pyramid is made of four sides";
        explanation[18] = "A right triangle, is a triangle with a right angle";
        explanation[19] = "A sphere is a  round solid figure, with every point on its surface equidistant from its center";
        explanation[20] = "Obtuse angles are any angle greater than 90 degree";
        explanation[21] = "A point is a distinct place on a line.";
        explanation[22] = "An acute triangle is a triangle with all three angles acute (less than 90°)";
        explanation[23] = "A right triangle, is a triangle with a right angle (90 degrees)";
        explanation[24] = "Obtuse angles are any angle greater than 90 degree";
        explanation[25] = "An obtuse triangle is a triangle in which one of the angles is an obtuse angle";
        explanation[26] = "Look at the picture on the right side of the stove";
        explanation[27] = "An isosceles triangle has two sides of equal length";
        explanation[28] = "An equilateral triangle is a triangle in which all three sides are equal";
        explanation[29] = "When two triangles are congruent they will have exactly the same three sides and exactly the same three angles";
        explanation[30] = "When two triangles are congruent they will have exactly the same three sides and exactly the same three angles";
        explanation[31] = "A Prism is a solid geometric figure whose two end faces are similar: equal, parallel rectilinear figures, and whose sides are parallelograms";
        explanation[32] = "The distance between neighboring points is 1 inch";
        explanation[33] = "Midpoint is the point that divides a segment into two congruent segments";
        explanation[34] = "There are 3 blue dots on the line, so there are 3 dots";
        explanation[35] = "A cone is a solid or hollow object that tapers from a circular or roughly circular base to a point";
        explanation[36] = "A sphere is a round solid figure, with every point on its surface equidistant from its center";
        explanation[37] = "If two figures have the same shape and the same size, then they are said to be congruent figures";




        guess1 = (Button) findViewById(R.id.guess1);
        guess2 = (Button) findViewById(R.id.guess2);
        guess3 = (Button) findViewById(R.id.guess3);
        guess4 = (Button) findViewById(R.id.guess4);
        hint = (Button) findViewById(R.id.hint);


        init();


        dlgAlert  = new AlertDialog.Builder(this);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.cancel();
                counter = null;
                dlgAlert.setMessage(explanation[index-1]);
                dlgAlert.setTitle("Hint");
                dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        counter = new timerClass(elapsedTime * 1000, 1000);
                        counter.start();
                    }
                });
                dlgAlert.setCancelable(false);
                dlgAlert.create().show();
            }
        });

        guess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 1) {
                    guess1.setBackgroundColor(Color.GREEN);
                    score += elapsedTime;
                    gameScore.setText(Integer.toString(score));
                }
                else {
                    guess1.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                    lives--;

                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                hint.setEnabled(false);
                counter.cancel();
                counter = null;
                delayTimer = new delayTimerClass(1000, 1000);
                delayTimer.start();
            }
        });

        guess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 2) {
                    guess2.setBackgroundColor(Color.GREEN);
                    score += elapsedTime;
                    gameScore.setText(Integer.toString(score));
                }
                else {
                    guess2.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                    lives--;
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                hint.setEnabled(false);
                counter.cancel();
                counter = null;
                delayTimer = new delayTimerClass(1000, 1000);
                delayTimer.start();
            }
        });

        guess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 3) {
                    guess3.setBackgroundColor(Color.GREEN);
                    score += elapsedTime;
                    gameScore.setText(Integer.toString(score));
                }
                else {
                    guess3.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                    lives--;
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                hint.setEnabled(false);
                counter.cancel();
                counter = null;
                delayTimer = new delayTimerClass(1000, 1000);
                delayTimer.start();
            }
        });

        guess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 4) {
                    guess4.setBackgroundColor(Color.GREEN);
                    score += elapsedTime;
                    gameScore.setText(Integer.toString(score));
                }
                else {
                    guess4.setBackgroundColor(Color.RED);
                    paintCorrectButton();
                    lives--;
                }
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                hint.setEnabled(false);
                counter.cancel();
                counter = null;
                delayTimer = new delayTimerClass(1000, 1000);
                delayTimer.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
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
            elapsedTime = 0;
            livesCounter.setText(Integer.toString(lives));
            if(lives == 0) {
                dlgAlert.setMessage("Game Over! Your Score Is: " + Integer.toString(score));
                dlgAlert.setTitle("Game Over");
                dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dlgAlert.setCancelable(false);
                dlgAlert.create().show();
            }
            else {
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
                hint.setEnabled(true);
                timer = (TextView) findViewById(R.id.timer);
                timer.setText("20");
                if (counter == null) {
                    counter = new timerClass(20000, 1000);
                    counter.start();
                }
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
        else {
            dlgAlert.setMessage("Congratulations, You Finished The Game, Your Score Is: " + Integer.toString(score));
            dlgAlert.setTitle("Congratulations!");
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            dlgAlert.setCancelable(false);
            dlgAlert.create().show();
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
            elapsedTime = 20;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String sec = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
            elapsedTime = (int) TimeUnit.MILLISECONDS.toSeconds(millis);
            timer.setText(sec);
            if (sec.equals("12")) cutAnswer();
            if (sec.equals("06")) cutAnswer();
        }

        @Override
        public void onFinish() {
            lives--;
            timer.setText("00");
            paintCorrectButton();
            guess1.setEnabled(false);
            guess2.setEnabled(false);
            guess3.setEnabled(false);
            guess4.setEnabled(false);
            hint.setEnabled(false);
            counter.cancel();
            counter = null;
            delayTimer = new delayTimerClass(1000, 1000);
            delayTimer.start();
        }
    }

    public class delayTimerClass extends CountDownTimer {
        public delayTimerClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            init();
        }
    }
}