package com.cn.dao.service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cn.model.Userinfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
@Service
public class TokenService {


    public String getToken(Userinfo user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}

