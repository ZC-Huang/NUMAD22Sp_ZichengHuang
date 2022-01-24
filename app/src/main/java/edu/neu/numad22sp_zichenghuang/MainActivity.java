package edu.neu.numad22sp_zichenghuang;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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