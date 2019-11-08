package com.example.appclass_hw09_guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button Btn01;
    Button Btn02;
    Button Btn03;
    Button Btn04;
    Button Btn05;
    Button Btn06;
    Button Btn07;
    Button Btn08;
    Button Btn09;
    Integer random;
    Integer Count;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOnClickListener();
        random = new Random().nextInt(9)+1;
        Count = 0;
        Log.d("Rui", ""+random);
        intent = new Intent(this,Main2Activity.class);
    }

    void initOnClickListener() {
        MyOnClickListener myOnClickListener = new MyOnClickListener();
        int my_ids[] = {
                R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04,
                R.id.btn05, R.id.btn06, R.id.btn07, R.id.btn08,
                R.id.btn09
        };
        Button b = null;
        for (int i = 0; i < my_ids.length; ++i)
            if ((b = (Button) findViewById(my_ids[i])) != null)
                b.setOnClickListener(myOnClickListener);
    }

    class MyOnClickListener implements View.OnClickListener {
        public void onClick(View v) {
            Button b = (Button) v;
            String buttonText = b.getText().toString();
            if(buttonText.equals(random.toString())){
                intent.putExtra("Value","正確 d(d＇∀＇)");
                intent.putExtra("Draw","Ｏ");
                Count = Count + 1;
                intent.putExtra("Count",Count);
                random = new Random().nextInt(9)+1;
                Count = 0;
                Log.d("Rui", ""+random);
                startActivity(intent);
            }else {
                int temp = Integer.parseInt(buttonText);
                if(temp - random > 0){//猜太大
                    intent.putExtra("Value","太大了");
                }else {//猜太小
                    intent.putExtra("Value","太小了");
                }
                intent.putExtra("Draw","Ｘ");
                Count = Count + 1;
                startActivity(intent);
            }
        }
    }
    public void BtnResetOnclick(View view){
        random = new Random().nextInt(9)+1;
        Count = 0;
        Log.d("Rui", ""+random);
    }
}

