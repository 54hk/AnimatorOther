package com.example.a54hk.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {


    LinearLayout mSearchLayout;
    TextView tvSearch;
    ScrollView mScrollView;
    boolean isExpand = false;
    private AutoTransition mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mSearchLayout = (LinearLayout) findViewById(R.id.ll_search);
        tvSearch = (TextView) findViewById(R.id.tv_search);
        mScrollView = (ScrollView) findViewById(R.id.smart_scrollview);

        //scrollview滚动状态监听
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                //滚动距离>=大图高度-toolbar高度 即toolbar完全盖住大图的时候 且不是伸展状态 进行伸展操作
                if (mScrollView.getScrollY() > 2  && !isExpand) {
                    reduce();
                    isExpand = true;
                }
                //滚动距离<=0时 即滚动到顶部时  且当前伸展状态 进行收缩操作
                else if (mScrollView.getScrollY()<=0 && isExpand) {
                    expand();
                    isExpand = false;
                }
            }
        });
    }

    private void expand() {
        //设置伸展状态时的布局

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
        layoutParams.width = layoutParams.MATCH_PARENT;
//        (int left, int top, int right, int bottom
        layoutParams.setMargins(dip2px(0), dip2px(0), dip2px(0), dip2px(0));
        mSearchLayout.setLayoutParams(layoutParams);
        //开始动画
        beginDelayedTransition(mSearchLayout);
    }

    private void reduce() {
        //设置收缩状态时的布局

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
        layoutParams.width = layoutParams.WRAP_CONTENT;
        layoutParams.setMargins(dip2px(0), dip2px(0), dip2px(0), dip2px(0));
        mSearchLayout.setLayoutParams(layoutParams);
        //开始动画
        beginDelayedTransition(mSearchLayout);
    }

    void beginDelayedTransition(ViewGroup view) {
        mSet = new AutoTransition();
        mSet.setDuration(300);
        TransitionManager.beginDelayedTransition(view, mSet);
    }

    private int dip2px(float dpVale) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
    }

}