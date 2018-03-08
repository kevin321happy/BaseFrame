package com.wh.jxd.com.baseframework.net.loader;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


import com.wang.avi.AVLoadingIndicatorView;
import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.utils.DisplayUtil;

import java.util.ArrayList;

/**
 * Created by kevin321vip on 2017/11/18.
 * load加载管理类
 */

public class LyonLoader {
    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;
    private static final ArrayList<Dialog> LOADERS = new ArrayList<>();
    //默认的加载样式
    private static final String DEFAULT_LOADER = LoadStyle.BallClipRotatePulseIndicator.name();
//    private static LoadingDialog mDefaultLoading;
//    private static LoadingDialog defaultDialog;

    public static void showLoading(Context context, Enum<LoadStyle> loadStyleEnum) {
        showLoading(context, loadStyleEnum.name());
    }

    /**
     * 显示加载框
     *
     * @param context
     * @param type
     */
    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.loading_dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.creat(type, context);
        dialog.setContentView(avLoadingIndicatorView);
        int deviceWidth = DisplayUtil.getScreenWidth();
        int deviceHeight = DisplayUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    /**
     * 加载默认的样式
     *
     * @param context
     */
    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
            for (Dialog loader : LOADERS) {
                if (loader != null) {
                    Log.d("LyonLoader", "LOADERS.size():" + LOADERS.size());
                    //cancle和dismiss的区别是cancle有对应的回调
                    if (loader.isShowing()) {
                        loader.cancel();
                    }
                }
        }
    }

    /**
     * 显示默认的加载跑马
     *
     * @param context
     */
//    public static void showLoadingDefault(Context context) {
//        defaultDialog = new LoadingDialog(context);
//        defaultDialog.show();
//    }
}
