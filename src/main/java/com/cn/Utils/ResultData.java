package com.cn.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData {


    private Integer code;//业务处理结果码（0为成功，1xx为客户端错误导致异常，2xx为服务端错误导致异常）
    private String msg;//处理结果信息
    private Object data;//处理结果内容

    public ResultData() {}

    public ResultData(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }


}

