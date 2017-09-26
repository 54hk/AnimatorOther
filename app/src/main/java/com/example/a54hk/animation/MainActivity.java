package com.example.a54hk.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivAnitation;
    Button butOne, butTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivAnitation  = (ImageView) findViewById(R.id.iv_anitation);
        butOne = (Button) findViewById(R.id.but_one);
        butOne.setOnClickListener(this);
        butTwo = (Button) findViewById(R.id.but_two);
        butTwo.setOnClickListener(this);

//        ani(2000,1.1f);
//        ani2();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transle);
        ivAnitation.startAnimation(animation);
    }

    private void ani2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivAnitation, "translationX", 0.0f , 100f, 0f , 0f);
        animator.setDuration(8000);//动画时间
        animator.setRepeatCount(-1);//设置动画重复次数
        animator.setStartDelay(200);//设置动画延时执行
        animator.start();//启动动画

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but_one:

                break;
            case R.id.but_two:

                break;
        }
    }

    private void ani(int p0 , float f) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(ivAnitation, "scaleX",
                1.0f, f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(ivAnitation, "scaleY",
                1.0f, f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(p0);

        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
    }
}
