package com.example.sahar.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class HintActivity extends AppCompatActivity {

    private TextView randomNum;
    private TextView factorsList;
    ArrayList<Integer> ListOfFactors = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        randomNum = (TextView) findViewById(R.id.randomNum);
        factorsList = (TextView) findViewById(R.id.listOfFactors);
        int receiveValue = getIntent().getIntExtra("hint", 0);
        randomNum.setText(Integer.toString(receiveValue));

        for(int i = 1;i<=Math.sqrt(receiveValue);i++)
        {
            if(receiveValue%i==0)
            {
                ListOfFactors.add(i);
                if(i!=receiveValue/i)
                {
                    ListOfFactors.add(receiveValue/i);
                }
            }
        }
        Collections.sort(ListOfFactors);

        String factorString = "";

        for(int i=0;i<ListOfFactors.size();i++)
        {
            System.out.println(i);
            String num = Integer.toString(ListOfFactors.get(i));
            if(i==0)
            factorString += num.toString();
            else
                factorString += ", " + num.toString();
        }

        System.out.println(factorString);
        factorsList.setText(factorString);

    }
}
