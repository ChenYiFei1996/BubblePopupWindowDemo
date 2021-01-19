package com.cyf.bubblepopupwindowdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cyf.bubblepopupwindow.view.BubblePopupWindow;
import com.cyf.bubblepopupwindowdemo.R;
import com.cyf.bubblepopupwindowdemo.databinding.ActivityAtyBubbleDemoBinding;


/**
 * Description: 气泡弹窗demo
 * Author: cyf 2021/1/19 9:38
 * Version: 1.0
 */
public class AtyBubbleDemo extends AppCompatActivity implements View.OnClickListener {
    private ActivityAtyBubbleDemoBinding mBinding;
    private BubblePopupWindow mBubblePopUpWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_aty_bubble_demo);
        mBinding.setOnClick(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //如果已有气泡弹窗显示，先隐藏
        if (mBubblePopUpWindow != null) {
            if (mBubblePopUpWindow.isShowing()) {
                mBubblePopUpWindow.dismiss();
            }
        }
        mBubblePopUpWindow = new BubblePopupWindow(this);
        switch (id) {
            case R.id.top_bubble: {//上方气泡
                TextView textView = new TextView(this);
                textView.setText("这是一个上方气泡");
                mBubblePopUpWindow.setBubbleView(textView);
                mBubblePopUpWindow.setBubbleBgColor(Color.rgb(241, 148, 138));
                //设置尖角的高和底都为0，尖角不显示
                mBubblePopUpWindow.setTriangleSize(0, 0);
                mBubblePopUpWindow.show(mBinding.topBubble, Gravity.TOP,
                        0, 0, 0);
                break;
            }
            case R.id.bottom_bubble: {//下方气泡
                TextView textView = new TextView(this);
                textView.setText("这是一个下方气泡");
                mBubblePopUpWindow.setBubbleView(textView);
                //设置尖角的高为0，尖角不显示
                mBubblePopUpWindow.setTriangleSize(0, 10);
                mBubblePopUpWindow.setBubbleBgColor(Color.rgb(241, 148, 138));
                mBubblePopUpWindow.show(mBinding.bottomBubble, Gravity.BOTTOM,
                        0, 0, 0);
                break;
            }
            case R.id.left_bubble: {//左侧气泡
                TextView textView = new TextView(this);
                textView.setText("这是一个左侧气泡");
                mBubblePopUpWindow.setBubbleView(textView);
                //设置尖角的底为0，尖角不显示，但会气泡与其参照控件之间会根据padding设置间隔
                mBubblePopUpWindow.setTriangleSize(10, 0);
                mBubblePopUpWindow.setBubbleBgColor(Color.rgb(241, 148, 138));
                mBubblePopUpWindow.show(mBinding.leftBubble, Gravity.LEFT,
                        0, 0, 0);
                break;
            }
            case R.id.right_bubble: {//右侧气泡
                TextView textView = new TextView(this);
                textView.setText("这是一个右侧气泡");
                mBubblePopUpWindow.setBubbleView(textView);
                //设置尖角的高和底都不为零时才会显示尖角
                mBubblePopUpWindow.setTriangleSize(10, 10);
                mBubblePopUpWindow.setBubbleBgColor(Color.rgb(241, 148, 138));
                mBubblePopUpWindow.show(mBinding.rightBubble, Gravity.RIGHT,
                        0, 0, 0);
                break;
            }
        }
    }
}