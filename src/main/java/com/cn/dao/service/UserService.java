package com.cn.dao.service;
import com.cn.dao.mapper.UserMapper;
import com.cn.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Userinfo findUserinfoById(String id) {
        return userMapper.findUserinfoById(id);
    }



    public Userinfo findByUsername(Userinfo user){
        return userMapper.findByUsername(user.getUserName());
    }
    public Userinfo findUserById(String userId) {
        return userMapper.findUserById(userId);
    }



    public int addUser(Userinfo user) {
        return userMapper.addUser(user);
    }

    public int updatepassword(String id) {
        return userMapper.updatepassword(id);
    }



}

