package com.wh.jxd.com.baseframework.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.wh.jxd.com.baseframework.R;

/**
 * Created by kevin321vip on 2018/1/31.
 * BaseActivity
 */
public class BaseActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    /**
     * title的样式
     */
    private static final int MODE_BACK = 0;
    private static final int MODE_DRAWER = 1;
    private static final int MODE_NONE = 2;
    private static final int MODE_HOME = 3;
    private Toolbar mToolbar;
    private TextView mTool_bar_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(int layoutResID) {
        setContentView(layoutResID, -1, -1, MODE_BACK);
    }

    /**
     * 重载setContentView
     *
     * @param layoutResID
     * @param titleRes
     */
    public void setContentView(int layoutResID, int titleRes) {
        setContentView(layoutResID, titleRes, -1, MODE_BACK);
    }


    public void setContentView(int layoutResID, int titleRes, int mode) {
        setContentView(layoutResID, titleRes, -1, mode);
    }

    public void setContentView(int layoutResID, int titleRes, int menuID, int mode) {
        super.setContentView(layoutResID);
        setUpToolBar(titleRes, menuID, mode);

    }

    /**
     * 设置ToolBar
     *
     * @param titleRes
     * @param menuID
     * @param mode
     */
    private void setUpToolBar(int titleRes, int menuID, int mode) {
        if (mode != MODE_NONE) {
            mToolbar =(Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("");
            mTool_bar_title = (TextView) findViewById(R.id.toolbar_title);
            if (mode == MODE_BACK) {
                mToolbar.setNavigationIcon(R.mipmap.ic_toolbar_back);
            }
            setUpTitle(titleRes);
            setUpMenu(menuID);
        }

    }

    /**
     * 设置toolBar的菜单
     *
     * @param menuID
     */
    private void setUpMenu(int menuID) {
        if (mToolbar != null) {
            mToolbar.getMenu().clear();
        }
        if (menuID > 0) {
            mToolbar.inflateMenu(menuID);
            mToolbar.setOnMenuItemClickListener(this);
        }
    }
    /**
     * 设置toolbar标题
     *
     * @param titleRes
     */
    private void setUpTitle(int titleRes) {
        if (titleRes > 0 && mTool_bar_title != null) {
            mTool_bar_title.setText(titleRes);
        }
    }

    /**
     * ToolBar的返回键点击
     */
    private void onNavigateClick() {
        finish();
    }

    /**
     * 菜单的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
