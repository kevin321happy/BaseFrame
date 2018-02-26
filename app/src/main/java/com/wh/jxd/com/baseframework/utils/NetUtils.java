package com.wh.jxd.com.baseframework.utils;

import android.content.Context;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * description: 规则工具类,接口加密,以及用户登录验证
 * autour: Kevin
 * company:锦绣氘(武汉)科技有限公司
 * date: 2017/5/27 16:14
 * update: 2017/5/27
 * version: 1.21
 * 站在峰顶 看世界
 * 落在谷底 思人生
 */
public class NetUtils {
    private Map<String, String> signMap = new HashMap<>();
    private static Object info;
    //获取签名后的数据
//    public static String[] getSignData(Context context, Map<String, Object> map) {
//        List<String> dataList = new ArrayList<>();
//        StringBuffer signString = new StringBuffer();
//        StringBuffer str = new StringBuffer();
//        //传入信息放在数组中
//        String[] signArray = new String[2];
//        //遍历map集合将key值存入新的集合
//        for (String key : map.keySet()) {
//            dataList.add(key);
//        }
//        //将data集合排序
//        // 升序
//        Collections.sort(dataList);
//        for (String s : dataList) {
//            signString.append("&" + s + "=" + map.get(s));
//            str.append(s + "|");
//        }
//        String s = PreferenceUtils.getAPP_Secret();
//        String md5 = Md5Utils.encodeBy32BitMD5(s);
//        signString.append("&" + md5.toLowerCase());
//        String substring = signString.toString().substring(1);
//        signArray[0] = Md5Utils.encodeBy32BitMD5(substring).toLowerCase();
//        StringBuffer finStr = str.deleteCharAt(str.length() - 1);
//        signArray[1] = finStr.toString();
//        if (signArray != null && signArray.length > 0) {
//            return signArray;
//        }
//        return null;
//    }

    /**
     * String json
     * 判断是否已经登录了
     */
    public static boolean checkIsLogined(String s) {
        //判断是否已经登录了
        boolean islogined = false;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            String is_login = jsonObject.getString("is_login");
            if (is_login.equals("-99")) {
                islogined = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return islogined;
    }

    public static boolean isNewestVersion(String s) {
        boolean isnewest = true;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            String is_login = jsonObject.getString("is_login");
            if (is_login.equals("-100")) {
                isnewest = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return isnewest;
    }

    /**
     * 获取json里面的数据
     */
    public static String getData(String s) {
        //判断是否已经登录了
        String dataString = null;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            dataString = jsonObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataString;
    }

    //返回data数组
    public static String getDataArray(String s) {
        String dataString = null;
        try {
            JSONObject jsonObject = new JSONObject(s);
            //json转数组
            JSONArray data = jsonObject.getJSONArray("data");
            dataString = data.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataString;
    }

    //判断是否正确
    public static boolean isRight(String s) {
        //判断是否已经登录了
        String state = null;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            state = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "1".equals(state);
    }

    //获取服务器的返回的描述信息
    public static String getInfo(String s) {
        //判断是否已经登录了
        String info = null;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            info = jsonObject.getString("info");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return info;
    }

    //获取服务器的返回的描述信息
    public static String getStatus(String s) {
        //判断是否已经登录了
        String status = null;
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(s);
            status = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return status;
    }

//    public static String[] getSignatureArray(String timestamp, String userid) {
//        HashMap<String, Object> stringHashMap = new HashMap<>();
//        stringHashMap.put("timestamp", timestamp);
//        stringHashMap.put("userid", userid);
//        return NetUtils.getSignData(ApplicationEx.getInstance(), stringHashMap);
//    }

//    /**
//     * 获取房间的id
//     *
//     * @return
//     */
//    public static String getRoomId(String type) {
//        String companyId = PreferenceUtils.getCompanyId();
//        StringBuffer roomid = new StringBuffer();
//        roomid.append("qmct_")
//                .append(companyId)
//                .append("_")
//                .append(String.valueOf(Utils.getCurrentTime()))
//                .append("_")
//                .append(type)
//                .append("_")
//                .append(String.valueOf(Utils.getRandom(10000)));
//        return roomid.toString();
//    }

    /**
     * 返回公共的请求参数的Map
     *
     * @return
     */
//    public static WeakHashMap<String, Object> getCommonParams() {
//        WeakHashMap<String, Object> map = new WeakHashMap<>();
//        String timestamp = Utils.getCurrentTimestamp();
//        String[] signData = NetUtils.getSignatureArray(timestamp, PreferenceUtils.getUserId());
//        map.put("userid", PreferenceUtils.getUserId());
//        map.put("qmct_token", PreferenceUtils.getQM_Token());
//        map.put("str", signData[1]);
//        map.put("sign", signData[0]);
//        map.put("timestamp", timestamp);
//        return map;
//    }
}
