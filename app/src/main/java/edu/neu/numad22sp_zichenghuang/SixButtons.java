package edu.neu.numad22sp_zichenghuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SixButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_buttons);

        changeTextViewOnButtonClick();
    }

    //change textview on button click
    private void changeTextViewOnButtonClick() {
        //give each button individual id to change the textview
        TextView changingText = (TextView) findViewById(R.id.textView2);
        Button changeTextButtonA = (Button) findViewById(R.id.buttonA);
        Button changeTextButtonB = (Button) findViewById(R.id.buttonB);
        Button changeTextButtonC = (Button) findViewById(R.id.buttonC);
        Button changeTextButtonD = (Button) findViewById(R.id.buttonD);
        Button changeTextButtonE = (Button) findViewById(R.id.buttonE);
        Button changeTextButtonF = (Button) findViewById(R.id.buttonF);

        //use setText to change textView
        changeTextButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: A");
            }
        });

        changeTextButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: B");
            }
        });

        changeTextButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: C");
            }
        });

        changeTextButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: D");
            }
        });

        changeTextButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: E");
            }
        });

        changeTextButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText("Pressed: F");
            }
        });
    }
}