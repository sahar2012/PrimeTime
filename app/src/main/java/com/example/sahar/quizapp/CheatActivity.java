package com.example.sahar.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {

    private TextView cheatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        int receiveValue = getIntent().getIntExtra("cheat", 0);
        cheatText = (TextView)findViewById(R.id.answer);

        int flag = 0;
        for(int i = 2;i<receiveValue/2;i++)
        {
            if(receiveValue%i==0)
            {
                flag++;
                break;
            }
        }
        if(flag==0)
        {
            cheatText.setText("Yes");
        }
        else
        {
            cheatText.setText("No");
        }


    }
}
