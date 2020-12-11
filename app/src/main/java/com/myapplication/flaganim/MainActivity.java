package com.myapplication.flaganim;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private AnimationDrawable frameAnimation;
    private String buttonText;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image_view);
        button = (Button)findViewById(R.id.status_button);
        animation = AnimationUtils.loadAnimation(this, R.anim.blink);

        imageView.setBackgroundResource(R.drawable.flags);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonText = button.getText().toString();
                if(buttonText.equals("START FLAGS")){
                    button.setText(R.string.stop);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.getLayoutParams().width = 170;
                    imageView.getLayoutParams().height = 100;
                    imageView.setBackgroundResource(R.drawable.animation_list);
                    frameAnimation = (AnimationDrawable) imageView.getBackground();
                    frameAnimation.start();
                }else if(buttonText.equals("STOP FLAGS")){
                    button.setText(R.string.start);
                    imageView.startAnimation(animation);
                    imageView.setVisibility(View.INVISIBLE);
                    frameAnimation.stop();
                }
            }
        });
    }


}