package com.cn.Utils;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/21
 */
public class HXUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    // 企业的唯一标识，开发者在环信开发者管理后台注册账号时填写的企业 ID
    private static final String ORG_NAME = "1121190816148811";
    // App的client_id
    private static final String CLIENT_ID = "YXA62FW_iMWhTYuDG14i4UfaLQ";
    // App的client_secret
    private static final String CLIENT_SECRET = "YXA60xUoGkig1v_kZ6wQjc8cWGrjn7s";
    // 同一“企业”下“APP”唯一标识，开发者在环信开发者管理后台创建应用时填写的“应用名称”
    private static final String APP_NAME = "texrxrad";
    // 链接前缀
    private static final String URL_PREFIX = "http://a1.easemob.com/" + ORG_NAME + "/" + APP_NAME + "/";
    // 缓存的token
    private static Token token;
    // token的失效时间
    private static long expiresTime;

    public enum HXMessageType {
        txt,// 文本
        img,// 图片
        loc,// 位置
        audio,// 音频
        video,// 视频
        file// 文件
    }

    /**
     * 获取Token
     * 注意：关于有效时间，我在网上找过，说的是7天，但是返回的是5184000，
     * 			但是官网上说是以秒为单位，这么算下来就是60天了，
     * 			觉得不太对，就先将有效时间设为了7天
     * @return token
     */
    public static Token getToken() {
        // 判断Token是否已经过期，如果过期需要重新获取
        if (token == null || expiresTime < new Date().getTime()) {
            try {
                JSONObject body = new JSONObject();
                body.put("grant_type", "client_credentials");
                body.put("client_id", CLIENT_ID );
                body.put("client_secret", CLIENT_SECRET );
                HttpEntity httpEntity = new HttpEntity(body.toString(), null);
                ResponseEntity<Token> tokenResponseEntity = restTemplate.postForEntity(URL_PREFIX + "token", httpEntity, Token.class);
                token =  tokenResponseEntity.getBody();
                // 设置7天后过期
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 7);
                expiresTime = c.getTime().getTime();
            } catch (RestClientException e) {
                e.printStackTrace();
            }
        }
        return token;
    }

    /**
     * 添加用户
     *
     *
     * @return 是否成功
     */
    public  boolean addUser(String userPhone) {
        try {
            JSONArray body = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", userPhone);
            jsonObject.put("password", "111111");
            body.add(jsonObject);
            HttpEntity httpEntity = new HttpEntity(body.toString(), null);
            ResponseEntity responseEntity = restTemplate.postForEntity(URL_PREFIX + "users", httpEntity, null);
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改用户密码
     *
     * @param username    用户名
     * @param newpassword 新密码
     * @return 是否成功
     */
    public static boolean updatePassword(String username, String newpassword) {
        try {
            JSONObject body = new JSONObject();
            body.put("newpassword", newpassword);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + getToken().getToken());
            HttpEntity httpEntity = new HttpEntity(body.toString(), headers);
            ResponseEntity responseEntity = restTemplate.postForEntity(URL_PREFIX + "users/{username}/password", httpEntity, null, username);
            System.out.println(responseEntity.getStatusCodeValue());
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除用户
     *
     * @param username 用户名
     */
  /*  public static boolean deleteUser(String username) {
        try {
            HttpEntity httpEntity = new HttpEntity(null, getHttpHeaders(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
            ResponseEntity<HXUser> responseEntity = restTemplate.exchange(URL_PREFIX + "users/{username}", HttpMethod.DELETE, httpEntity, HXUser.class, username);
            System.out.println(responseEntity.getStatusCodeValue());
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * 添加好友
     *
     * @param ownerUsername 用户名
     * @param friendName    好友用户名
     * @return 是否成功
     */
  /*  public static boolean addFriend(String ownerUsername, String friendName) {
        try {
            HttpEntity httpEntity = new HttpEntity(null, getHttpHeaders(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON));
            ResponseEntity responseEntity = restTemplate.postForEntity(URL_PREFIX + "users/{owner_username}/contacts/users/{friend_username}", httpEntity, HXUser.class, ownerUsername, friendName);
            System.out.println(responseEntity.getStatusCodeValue());
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * 删除好友
     *
     * @param ownerUsername 用户名
     * @param friendName    好友用户名
     * @return 是否成功
     */
   /* public static boolean deleteFriend(String ownerUsername, String friendName) {
        try {
            HttpEntity httpEntity = new HttpEntity(null, getHttpHeaders(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON));
            ResponseEntity responseEntity = restTemplate.exchange(URL_PREFIX + "users/{owner_username}/contacts/users/{friend_username}", HttpMethod.DELETE, httpEntity, HXUser.class, ownerUsername, friendName);
            System.out.println(responseEntity.getStatusCodeValue());
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * 发送消息
     *
     * @param sendUser   发送用户
     * @param targetUser 接收用户
     * @param msg        发送消息
     * @return 是否成功
     */
   /* public static boolean sendToUser(String sendUser, String targetUser, String msg) {
        try {
            JSONObject body = new JSONObject();
            body.put("target_type", "users");
            JSONArray targetUserjson = new JSONArray();
            targetUserjson.add(targetUser);
            body.put("target", targetUserjson);
            JSONObject msgJson = new JSONObject();
            msgJson.put("type", HXMessageType.txt.name());
            msgJson.put("msg", msg);
            body.put("msg", msgJson);
            body.put("from", sendUser);
            HttpEntity httpEntity = new HttpEntity(body, getHttpHeaders(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON));
            ResponseEntity responseEntity = restTemplate.postForEntity(URL_PREFIX + "messages", httpEntity, null);
            System.out.println(responseEntity.getStatusCodeValue());
            return responseEntity.getStatusCodeValue() == 200;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * 获取HttpHeaders
     *
     * @param contentType 客户端发送类型
     * @param accept      响应类型
     * @return HttpHeaders
     */
    private static HttpHeaders getHttpHeaders(MediaType contentType, MediaType... accept) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + getToken().getToken());
        headers.setContentType(contentType != null ? contentType : MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList((accept != null && accept.length > 0) ? accept : new MediaType[]{MediaType.APPLICATION_JSON}));
        return headers;
    }



}



