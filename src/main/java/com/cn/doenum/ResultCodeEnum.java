package com.cn.doenum;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/21
 */
public enum  ResultCodeEnum {

    //通用成功码,
    CODE_0(0, "SUCCESS"),

    //系统拦截异常
    CODE_10001(10001, "签名验证无效"),
    CODE_10002(10002, "签名过期，请重新获取"),
    CODE_10003(10003, "无效签名"),
    CODE_10004(10004, "签名为空"),
    CODE_10005(10005, "签名格式有误"),
    CODE_10006(10006, "接口请求参数为空或格式不对"),
    CODE_10007(10007, "请求参数拼写错误"),
    CODE_10008(10008, "请求路径无效"),
    CODE_10009(10009, "400错误"),
    CODE_10010(10010, "400错误"),
    CODE_10011(10011, "405错误"),
    CODE_10012(10012, "405错误"),
    CODE_10013(10013, "500错误"),
    CODE_10014(10014, "500错误"),


    CODE_10015(10015, "未查询到数据"),
    CODE_10016(10016, "参数无效"),
    CODE_10017(10017, "操作失败"),
    CODE_10018(10018, "当前用户无权限操作"),


    //登录换取token模块
    CODE_10101(10101, "登录账号不能为空"),
    CODE_10102(10102, "未登录"),
    CODE_10103(10103, "当前用户不存在"),
    CODE_10104(10104, "账号密码错误"),


    //文案
    CODE_10201(10201, "未查询到数据"),


    CODE_20001(20001, "服务端异常"),
    CODE_20000(20000, "服务端未知错误");

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

