package com.wh.jxd.com.baseframework.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.core.AppStatuesTracker;
import com.wh.jxd.com.baseframework.core.BaseActivity;
import com.wh.jxd.com.baseframework.db.AppDatabase;
import com.wh.jxd.com.baseframework.db.UserModel;
import com.wh.jxd.com.baseframework.net.RestClient;
import com.wh.jxd.com.baseframework.net.callback.IFailed;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;
import com.wh.jxd.com.baseframework.sonstants.ConstantValues;
import com.wh.jxd.com.baseframework.utils.LogUtils;
import com.wh.jxd.com.baseframework.view.LoginView;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class HomeActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在HomeActivity中进行状态的改变
        AppStatuesTracker.getInstance().setAppStatus(ConstantValues.STATUS_ALREADY_LOGGED);
        setContentView(R.layout.activity_main, R.string.home_title);
        //联网示例代码
//        RestClient.builder()
//                .url("www.baidu.com")
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String data) {
//
//                    }
//                })
//                .fail(new IFailed() {
//                    @Override
//                    public void onFail(String message) {
//
//                    }
//                })
//                .build().get();

    }

    public void startLogin(View view) {
        for (int i = 0; i < 10; i++) {
            //数据库增加数据
            UserModel userModel = new UserModel();
            userModel.setName("老疼" + i + "号");
            userModel.setAddress("武汉市洪山区街道口" + i + "号");
            userModel.setAge(26 + i);
            userModel.setPhone(i * 999999);
            userModel.save();
            LogUtils.d("增加了一条数据:" + userModel.toString());
        }

        //查询所有的数据
        List<UserModel> appDatabases = new Select().from(UserModel.class).queryList();
        if (appDatabases != null && appDatabases.size() > 0) {
            for (UserModel appDatabasis : appDatabases) {
                LogUtils.d("查出来的数据:" + appDatabases.toString()
                );
            }
        }
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
    }
}
