package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

      Button btn1;
      TextView text1;

      ImageView img1;
       int currentposition = 0;
    List<String> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn1 = findViewById(R.id.btn1);
         text1 = findViewById(R.id.text1);
         img1 = findViewById(R.id.img1);



         list1.addAll(quotelist.getquote());
         text1.setText(list1.get(currentposition));

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (currentposition+1>=list1.size()){
                     currentposition=0;                     text1.setText(list1.get(currentposition));

                 }else {  currentposition++;
                     text1.setText(list1.get(currentposition));
                 }

             }
         });
    }
    public void sharequote(View view){
        Intent shareintent = new Intent(Intent.ACTION_SEND);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_TEXT,list1.get(currentposition));
        startActivity(Intent.createChooser(shareintent,"select an app"));


    }
}