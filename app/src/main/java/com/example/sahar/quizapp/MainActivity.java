package com.example.sahar.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button yesButton;
    private Button noButton;
    private Button nextButton;
    private Button hintButton;
    private Button cheatButton;
    private TextView hintChecker;
    private TextView cheatChecker;
    int hintFlag = 0;
    int cheatFlag = 0;
    private TextView testData;
    Random randomGenerator = new Random();
    Integer randomInt = randomGenerator.nextInt(1000);

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        testData = (TextView) findViewById(R.id.testNumber);
        hintChecker = (TextView) findViewById(R.id.hintChecker);
        cheatChecker = (TextView) findViewById(R.id.cheatChecker);

        if(savedState!=null)
        {
            randomInt=savedState.getInt("randomInt",randomGenerator.nextInt(1000));
            hintFlag=savedState.getInt("hintTaken");
            cheatFlag=savedState.getInt("cheatTaken");
            if(hintFlag==1)
                hintChecker.setVisibility(View.VISIBLE);
            if(cheatFlag==1)
                cheatChecker.setVisibility(View.VISIBLE);
            testData.setText(Integer.toString(randomInt));
        }
        else
        {
            randomInt = randomGenerator.nextInt(1000);
            testData.setText(Integer.toString(randomInt));
        }

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                randomInt = randomGenerator.nextInt(1000);
                testData = (TextView) findViewById(R.id.testNumber);
                testData.setText(Integer.toString(randomInt));
                hintFlag=0;
                hintChecker.setVisibility(View.INVISIBLE);
                cheatFlag=0;
                cheatChecker.setVisibility(View.INVISIBLE);
            }
        });

        yesButton = (Button) findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int flag = 0;
                for(int i = 2;i<randomInt/2;i++)
                {
                    if(randomInt%i==0)
                    {
                        flag++;
                        break;
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(MainActivity.this, "Correct",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        yesButton = (Button) findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int flag = 0;
                for(int i = 2;i<randomInt/2;i++)
                {
                    if(randomInt%i==0)
                    {
                        flag++;
                        break;
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(MainActivity.this, "Correct",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        noButton = (Button) findViewById(R.id.noButton);
        noButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int flag = 0;
                for(int i = 2;i<randomInt/2;i++)
                {
                    if(randomInt%i==0)
                    {
                        flag++;
                        break;
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Correct",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        hintButton = (Button) findViewById(R.id.hintButton);
        hintButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                hintFlag = 1;
                showHint(view);
            }
        });

        cheatButton = (Button) findViewById(R.id.cheatButton);
        cheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cheatFlag = 1;
                showCheat(view);
            }
        });

    }

    public void showHint(View view)
    {
        Intent intent = new Intent(this, HintActivity.class);
        intent.putExtra("hint", randomInt);
        startActivity(intent);
    }

    public void showCheat(View view)
    {
        Intent intent = new Intent(this, CheatActivity.class);
        intent.putExtra("cheat", randomInt);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedState){
        super.onSaveInstanceState(savedState);
        savedState.putInt("randomInt",randomInt);
        savedState.putInt("hintTaken",hintFlag);
        savedState.putInt("cheatTaken",cheatFlag);
        if(hintFlag==1)
            hintChecker.setVisibility(View.VISIBLE);
        if(cheatFlag==1)
            cheatChecker.setVisibility(View.VISIBLE);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }


}
