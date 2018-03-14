package com.wh.jxd.com.baseframework.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.receive.NetBroadcastReceiver;
import com.wh.jxd.com.baseframework.sonstants.ConstantValues;
import com.wh.jxd.com.baseframework.ui.activity.HomeActivity;

/**
 * Created by kevin321vip on 2018/1/31.
 * BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, NetBroadcastReceiver.NetEvevt {
    /**
     * title的样式
     */
    private static final int MODE_BACK = 0;
    private static final int MODE_DRAWER = 1;
    private static final int MODE_NONE = 2;
    private static final int MODE_HOME = 3;
    public static NetBroadcastReceiver.NetEvevt evevt;
    private Toolbar mToolbar;
    private TextView mTool_bar_title;
    private int netMobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int appStatus = AppStatuesTracker.getInstance().getAppStatus();
        switch (appStatus) {
            case ConstantValues.STATUS_ALREADY_LOGGED:
                break;
            case ConstantValues.STATUS_NOT_LOGIN_IN:
                break;
            case ConstantValues.STATUS_FORCE_KILLED:
                //应用被强杀
                protectApp();
                break;
        }
    }

    /**
     * 保护app不会崩溃,重新走启动流程
     */
    private void protectApp() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(ConstantValues.KEY_HOME_ACTION, ConstantValues.ACTION_RESTART_APP);
        startActivity(intent);
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
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("");
            mTool_bar_title = (TextView) findViewById(R.id.toolbar_title);
            if (mode == MODE_BACK) {
                mToolbar.setNavigationIcon(R.mipmap.ic_toolbar_back);
            }
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNavigateClick();
                }
            });
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

    /**
     * 网络状态变化的监听
     *
     * @param netMobile
     */
    @Override
    public void onNetChange(int netMobile) {
        // TODO Auto-generated method stub
        this.netMobile = netMobile;
        boolean netConnect = isNetConnect();
        if (!netConnect) {
            Toast.makeText(this, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 判断有无网络
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;
        }
        return false;
    }
}
