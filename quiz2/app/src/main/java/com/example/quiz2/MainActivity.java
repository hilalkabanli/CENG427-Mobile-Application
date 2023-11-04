package com.example.quiz2;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.Random;

public class MainActivity extends Activity {
    Button changeBackgroundColor, prevButton, nextButton;
    TextView animText;
    ImageView movieImage;
    private static final int RED = 0xffFF0000;
    private static final int BLUE = 0xff0000FF;
    private int currentImageIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeBackgroundColor=(Button)findViewById(R.id.changeBackgroundButton);
        animText=(TextView)findViewById(R.id.animText);
        prevButton=(Button)findViewById(R.id.prevButton);
        nextButton=(Button)findViewById(R.id.nextButton);
        movieImage=(ImageView)findViewById(R.id.imageView);

        final int[] imageResources = {R.drawable.av_mevsimi, R.drawable.distant, R.drawable.donniebrasco, R.drawable.scarface, R.drawable.uncut_gems};
        movieImage.setImageResource(imageResources[currentImageIndex]);
        changeBackgroundColor.setOnClickListener(view -> setBackGroundColor());
        prevButton.setOnClickListener(view -> {
            if (currentImageIndex > 0) {
                currentImageIndex--;
                movieImage.setImageResource(imageResources[currentImageIndex]);
            } else {
                displayAlertDialog("Already at the first image");
            }
        });

        nextButton.setOnClickListener(view -> {
            if (currentImageIndex < imageResources.length - 1) {
                currentImageIndex++;
                movieImage.setImageResource(imageResources[currentImageIndex]);
            } else {
                currentImageIndex=0;
                movieImage.setImageResource((imageResources[currentImageIndex]));
            }
        });

        ValueAnimator colorAnim = ObjectAnimator.ofInt(animText, "textColor", RED, BLUE);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

    }
    private void setBackGroundColor(){
        LinearLayout linearLayout=findViewById(R.id.mainLinearLayout);
        Random random=new Random();
        int rand1=random.nextInt(256);
        int rand2=random.nextInt(256);
        int rand3=random.nextInt(256);
        linearLayout.setBackgroundColor(Color.rgb(rand1,rand2,rand3));
    }

    private void displayAlertDialog(String msg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Warning");
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}