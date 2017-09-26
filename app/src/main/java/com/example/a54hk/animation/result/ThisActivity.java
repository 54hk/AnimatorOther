package com.example.a54hk.animation.result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a54hk.animation.R;

public class ThisActivity extends AppCompatActivity implements View.OnClickListener {

    Button thisinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this);
        thisinish = (Button) findViewById(R.id.this_finish);
        thisinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("wai","你好啊");
        setResult(Code.A , intent);
        finish();
    }
}
