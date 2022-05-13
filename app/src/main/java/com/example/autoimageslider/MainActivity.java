package com.example.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper=findViewById(R.id.flipper);
        int img[]={R.drawable.one,R.drawable.two,R.drawable.three};

        for (int i=0;i<img.length;i++)
            Flip(img[i]);


    }
    public void Flip(int img){

        ImageView image=new ImageView(this);
        image.setImageResource(img);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img==R.drawable.one)
                    startActivity(new Intent(getApplicationContext(),slide1.class));
                if(img==R.drawable.two)
                    startActivity(new Intent(getApplicationContext(),slide2.class));
                if(img==R.drawable.three)
                    startActivity(new Intent(getApplicationContext(),slide3.class));

            }
        });

        flipper.addView(image);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);


    }
}