package com.example.a54hk.animation.flow.mycode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a54hk.animation.R;
import com.example.a54hk.animation.utilsActivity.FlowLayout;

import java.util.Set;

import static android.support.constraint.R.id.parent;

public class FlowActivity extends AppCompatActivity {

    private String[] mVals = new String[]
            {"你阿","好看","侯坤","锁店","诉讼","对方"};

    private TagFlowLayout mFlowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

       mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        mFlowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FlowActivity.this, "FlowLayoutClicked", Toast.LENGTH_SHORT).show();
            }
        });

        mFlowLayout.setAdapter(adapter);

        Set<Integer> selectedList = mFlowLayout.getSelectedList();
       for(Integer ii : selectedList){
           Toast.makeText(this, "ii:" + ii, Toast.LENGTH_SHORT).show();
       }
    }

   TagAdapter<String> adapter =  new TagAdapter<String>(mVals) {
        @Override
        public View getView(com.example.a54hk.animation.flow.mycode.FlowLayout parent, int position, String s) {

            TextView tv = (TextView) LayoutInflater.from(FlowActivity.this).inflate(R.layout.tv,
                    mFlowLayout, false);
            tv.setTextSize(12);
            tv.setText(s);
            return tv;
        }
    };
//    遍历你选择的项目
    public void sds(View view){
        Set<Integer> selectedList = mFlowLayout.getSelectedList();
        for(Integer ii : selectedList){
            Toast.makeText(this, "ii:" + ii +"qqqqqqqq"+mVals[ii], Toast.LENGTH_SHORT).show();
        }
    }
}
