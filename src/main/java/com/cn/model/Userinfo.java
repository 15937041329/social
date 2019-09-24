package com.cn.model;

import lombok.Data;

import javax.swing.*;
import java.util.Date;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
@Data
public class Userinfo {

    private static final long serialVersionUID = 1L;
    private String id;
    private String userName;
    private String userSex;
    private String userImg;
    private String userHeadimg;
    private String userPhone;
    private String password;
    private Date birthday;
    private Date createDay;
    private Date updateDay;
    private Integer status;
    private Double price;
    private String userInfo;
    private String userLocation;
    private Integer userLiveness;
    private String yzm;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private Integer userCheckNum;
    private String salt;



    public String getYzm() {
        return userInfo;
    }

    public void setYzm(String yzm) {
        this.userInfo = userInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Integer getUserLiveness() {
        return userLiveness;
    }

    public void setUserLiveness(Integer userLiveness) {
        this.userLiveness = userLiveness;
    }

    public Integer getUserCheckNum() {
        return userCheckNum;
    }

    public void setUserCheckNum(Integer userCheckNum) {
        this.userCheckNum = userCheckNum;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public Date getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(Date updateDay) {
        this.updateDay = updateDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "SoUserInfo{" +
                ", id=" + id +
                ", userName=" + userName +
                ", userSex=" + userSex +
                ", userImg=" + userImg +
                ", userHeadimg=" + userHeadimg +
                ", userPhone=" + userPhone +
                ", password=" + password +
                ", birthday=" + birthday +
                ", createDay=" + createDay +
                ", updateDay=" + updateDay +
                ", status=" + status +
                ", price=" + price +
                ", userInfo=" + userInfo +
                ", userLocation=" + userLocation +
                ", userLiveness=" + userLiveness +
                ", userCheckNum=" + userCheckNum +
                "}";

}
}

