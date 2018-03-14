package com.wh.jxd.com.baseframework.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by kevin321vip on 2018/3/14.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public final class AppDatabase {
    //数据库名称
    public static final String NAME = "AppDatabase";
    //数据库版本号
    public static final int VERSION = 1;

}

