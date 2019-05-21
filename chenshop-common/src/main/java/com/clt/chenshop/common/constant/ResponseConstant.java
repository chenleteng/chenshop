package com.clt.chenshop.common.constant;

public class ResponseConstant {
    public static  final  int Ok = 200;

    public static final  int LOGIN_FAIL_STATUS_PASSWORD = 10001;//登录失败，邮箱或密码错误
    public static  final String LOGIN_FAIL_MSG_PASSWORD = "登录失败，邮箱或密码错误!";

    public static  final int SAVE_ITEM_STATUS_OK = 20001;
    public static  final int SAVE_ITEM_STATUS_FAIL = 20002;
    public static  final int SAVE_CONTENT_STATUS_OK = 20003;
    public static  final int SAVE_CONTENT_STATUS_FAIL = 20004;
    public static  final String SAVE_ITEM_MSG_OK = "商品保存成功";
    public static  final String SAVE_ITEM_MSG_FAIL = "商品保存失败";
    public static  final String SAVE_CONTENT_MSG_OK = "内容保存成功";
    public static  final String SAVE_CONTENT_MSG_FAIL = "内容保存失败";
}
