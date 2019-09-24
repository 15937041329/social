package com.cn.dao.mapper;
import com.cn.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * &#x3008;
 * &#x3008;&#x3009;
 *
 * @author
 * @create 2019/8/20
 */
@Mapper
public interface UserMapper {


    Userinfo findUserinfoById(String id);

    Userinfo findByUsername( String userName);

    Userinfo findUserById(String id);

    int  addUser(Userinfo user);

    int  updatepassword(String id);





}


