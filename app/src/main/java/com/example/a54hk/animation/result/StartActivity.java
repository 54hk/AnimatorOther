package com.example.a54hk.animation.result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a54hk.animation.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
   Button startActivity,start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startActivity = (Button) findViewById(R.id.start_activity);
        startActivity.setOnClickListener(this);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_activity:
                Intent intent = new Intent(this,ThisActivity.class);
                startActivityForResult(intent , 0);
                break;
            case R.id.start:
                Intent intent1 = new Intent(this,ThisActivity.class);
                startActivityForResult(intent1 , 20);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null)
            return;
        String wai = data.getStringExtra("wai");
        if(resultCode == Code.A && requestCode == 0){

            Toast.makeText(this, wai, Toast.LENGTH_SHORT).show();
            Log.d("StartActivity", wai);
        }else if (resultCode == Code.A && requestCode == 20){
            Toast.makeText(this,"我是第二个"+ wai, Toast.LENGTH_SHORT).show();
        }

    }
}
