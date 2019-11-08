package com.example.appclass_hw09_guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();
        TextView textDraw = findViewById(R.id.textDraw);
        TextView texthint = findViewById(R.id.texthint);
        TextView textCount = findViewById(R.id.textCount);
        textDraw.setText(intent.getStringExtra("Draw"));
        texthint.setText(intent.getStringExtra("Value"));
        Button button = findViewById(R.id.btnBack);
        if(intent.getStringExtra("Draw").equals("Ｏ")){
            button.setText("重新開始");
            textCount.setText("共猜了"+intent.getIntExtra("Count",0)+"次");
        }else {
            button.setText("永不放棄");
        }
    }
    public void BtnBackOnclick(View view){
        finish();
    }
}
