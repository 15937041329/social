package com.cn.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
public class MSMDetailVO {

    Integer id;
    String phonenum;
    Integer code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date msmtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date ts;
    Integer dr;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPhonenum() {
        return phonenum;
    }
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Date getMsmtime() {
        return msmtime;
    }
    public void setMsmtime(Date msmtime) {
        this.msmtime = msmtime;
    }
    public Date getTs() {
        return ts;
    }
    public void setTs(Date ts) {
        this.ts = ts;
    }
    public Integer getDr() {
        return dr;
    }
    public void setDr(Integer dr) {
        this.dr = dr;
    }

}

