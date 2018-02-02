package com.wh.jxd.com.baseframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.wh.jxd.com.baseframework.core.BaseActivity;

/**
 * 一个基础的通用的项目框架
 */
public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main, R.string.home_title);
    }


}
