package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    String wrongCode = "";
    int howManywrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        RadioGroup Q1 = findViewById(R.id.Q1);
        if (Q1.getCheckedRadioButtonId() == R.id.rb_q1_1) {
            score += 25;
        } else {
            wrongCode += "一 ";
            howManywrong++;
        }

        RadioGroup Q2 = findViewById(R.id.Q2);
        if (Q2.getCheckedRadioButtonId() == R.id.rb_q2_2) {
            score += 25;
        } else {
            wrongCode += "二 ";
            howManywrong++;
        }

        CheckBox q1 = findViewById(R.id.check_q3_1);
        boolean q1Checked = q1.isChecked();
        CheckBox q2 = findViewById(R.id.check_q3_2);
        boolean q2Checked = q2.isChecked();
        CheckBox q3 = findViewById(R.id.check_q3_3);
        boolean q3Checked = q3.isChecked();
        CheckBox q4 = findViewById(R.id.check_q3_4);
        boolean q4Checked = q4.isChecked();

        if (q1Checked == true && q2Checked == true && q3Checked == true && q4Checked != true) {
            score += 25;
        } else {
            wrongCode += "三 ";
            howManywrong++;
        }
//        以上為Q
        EditText name = findViewById(R.id.name);
        String text = name.getText().toString();
        text = text.toLowerCase();
        if (text.equals("acoustic guitar")) {
            score += 25;
        } else {
            wrongCode += "四 ";
            howManywrong++;
        }
//        以上是輸入edittext區
        getScore(score);
        getWrong(wrongCode);
        score = 0;
        wrongCode = "";
    }

    private void getScore(int score) {
        TextView scoreView = findViewById(R.id.getThescore);
        scoreView.setText("得分(滿分100分): " + score);
        Toast.makeText(this, "得分(滿分100分): " + score, Toast.LENGTH_LONG).show();
    }

    private void getWrong(String wrongCode) {
        TextView wrongView = findViewById(R.id.getThewrong);
        wrongView.setText("第" + wrongCode + "題答錯了");
        Toast.makeText(this, "共" + howManywrong + "題答錯", Toast.LENGTH_SHORT).show();
    }
}
