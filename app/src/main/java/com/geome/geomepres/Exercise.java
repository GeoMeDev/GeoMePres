package com.geome.geomepres;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Exercise extends AppCompatActivity {

    TextView timer;
    Button guess1;
    Button guess2;
    Button guess3;
    Button guess4;
    final timerClass counter = new timerClass(15000, 1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        timer = (TextView) findViewById(R.id.timer);
        timer.setText("15 SEC"); // just for presentation we will give 15 secs to explain
        counter.start();

        guess1 = (Button) findViewById(R.id.guess1);
        guess2 = (Button) findViewById(R.id.guess2);
        guess3 = (Button) findViewById(R.id.guess3);
        guess4 = (Button) findViewById(R.id.guess4);

        guess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess1.setBackgroundColor(Color.RED);
                guess3.setBackgroundColor(Color.GREEN);
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
                guess2.setBackgroundColor(Color.RED);
                guess3.setBackgroundColor(Color.GREEN);
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
                guess3.setBackgroundColor(Color.GREEN);
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
                guess4.setBackgroundColor(Color.RED);
                guess3.setBackgroundColor(Color.GREEN);
                guess1.setEnabled(false);
                guess2.setEnabled(false);
                guess3.setEnabled(false);
                guess4.setEnabled(false);
                counter.cancel();
            }
        });
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
            if (sec.equals("10")) guess1.setVisibility(View.INVISIBLE);
            if (sec.equals("06")) guess4.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onFinish() {
            guess3.setBackgroundColor(Color.GREEN);
            guess1.setEnabled(false);
            guess2.setEnabled(false);
            guess3.setEnabled(false);
            guess4.setEnabled(false);
            counter.cancel();
        }
    }


}
