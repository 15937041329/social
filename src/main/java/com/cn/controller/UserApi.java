package com.cn.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.Header;
import com.alibaba.fastjson.JSONObject;
import com.cn.Utils.*;
import com.cn.dao.service.TokenService;
import com.cn.dao.service.UserService;
import com.cn.model.Userinfo;
import io.swagger.annotations.ApiOperation;
import org.omg.DynamicAny.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

 /**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */
@RestController
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    HashMap<String,String> hashMap = new HashMap<>();
    // 登录
    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Object login(Userinfo user,  HttpServletResponse response) {
        HXUtil h=new HXUtil();
        JSONObject jsonObject = new JSONObject();
        Userinfo userForBase = new Userinfo();
        userForBase.setId(userService.findByUsername(user).getId());
        userForBase.setUserName(userService.findByUsername(user).getUserName());
        userForBase.setPassword(userService.findByUsername(user).getPassword());

        h.addUser(user.getUserName());
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.put("message", "登录失败,验证码错误");
            return jsonObject;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return jsonObject;

        }


    }

    /***
     * 这个请求需要验证token才能访问
     *
     * @author: qiaoyn
     * @date 2019/06/14
     * @return String 返回类型
     */
    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {

       userService.findUserinfoById(TokenUtil.getTokenUserId());
        userService.updatepassword(TokenUtil.getTokenUserId());
        return "您已通过验证";
    }




    @RequestMapping(value = "/getyzm" ,method = RequestMethod.GET)
    public static HashMap<String,String> getMessageStatus(String userPhone) throws IOException {
        HashMap<String,String> hashMap = new HashMap<>();
        //第三方平台网站地址 http://www.webchinese.com.cn/User/?action=pay
        PostMethod post = new PostMethod("http://utf8.api.smschinese.cn/");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        String randMun = String.valueOf(RandomUtil.getRandom());

        //短信模板
        NameValuePair[] data ={
                new NameValuePair("accesskey", "ST3eyS3dQ6X0FaWo"),
                new NameValuePair("secret", "5lCMXoXaqgbLpATXtJeVKJXRYyz2d87A"),
                new NameValuePair("sign", "19310"),
                new NameValuePair("templateId", "39572"),
                new NameValuePair("mobile", userPhone),
                new NameValuePair("content", randMun)//（示例模板：{1}您好，您的订单于{2}已通过{3}发货，运单号{4}）
        };
        post.setRequestBody(data);
        HttpClient client = new HttpClient();
        client.executeMethod(post);
        //获取http头
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);

        for(Header h:headers){
            System.out.println(h.toString());
        }
        //获取返回消息
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        System.out.println(result); //打印返回消息状态
        //将返回消息和6位数验证码放入到map列表里面
        hashMap.put("result", result);
        hashMap.put("code", randMun);
        //断开与第三方平台的连接
        post.releaseConnection();
        return hashMap;
    }




    /**
     * 用户获取验证码
     */
    @RequestMapping("/getsendMsm")
    public Object sendCodeMsg(Userinfo user){

       /* if(user.getUserPhone() ==null || user.getYzm()==null){
return  new ResultData(ResultCodeEnum.CODE_10016.getCode(),ResultCodeEnum.CODE_10016.getMsg()); }*/
        HashMap<String,String> hashMap = new HashMap<>();
        String  randMun = RandomUtiltext.getMsgCode();
        user.setPassword(randMun);
        user.setUserName(user.getUserPhone());
        userService.addUser(user);
        HttpClient httpClient = new HttpClient();

        try{

            PostMethod postMethod = new PostMethod("http://api.1cloudsp.com/api/v2/single_send");
            postMethod.getParams().setContentCharset("UTF-8");
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
            NameValuePair[] data = {
                    new NameValuePair("accesskey", "ST3eyS3dQ6X0FaWo"),
                    new NameValuePair("secret", "5lCMXoXaqgbLpATXtJeVKJXRYyz2d87A"),
                    new NameValuePair("sign", "19310"),
                    new NameValuePair("templateId", "39572"),
                    new NameValuePair("mobile", user.getUserPhone()),
                    new NameValuePair("content",randMun)//（示例模板：{1}您好，您的订单于{2}已通过{3}发货，运单号{4}）
            };
            postMethod.setRequestBody(data);
            postMethod.setRequestHeader("Connection", "close");
            int statusCode = httpClient.executeMethod(postMethod);
            System.out.println("statusCode: " + statusCode + ", body: "
                    + postMethod.getResponseBodyAsString());
            return postMethod.getResponseBodyAsString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return "获取成功";
    }



}

