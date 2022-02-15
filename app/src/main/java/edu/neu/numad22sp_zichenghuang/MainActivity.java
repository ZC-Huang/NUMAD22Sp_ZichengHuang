package edu.neu.numad22sp_zichenghuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move=findViewById(R.id.button2);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SixButtons.class);
                startActivity(intent);
            }
        });
        move=findViewById(R.id.button3);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LinkCollector.class);
                startActivity(intent);
            }
        });

        //get button
        Button btn = findViewById(R.id.buttonReadMe);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyAPP", "exampleMsg");
                Toast.makeText(getApplicationContext(), "Name: Zicheng Huang\nEmail: huang.ziche@northeastern.edu", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}