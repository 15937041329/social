package com.cn.Utils;

import java.util.Random;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/21
 */
public class RandomUtiltext {

    /**
     * @Function: 生成验证码
     * @author:   yangxf
     * @Date:     2019/4/11 15:30
     */
    public static String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }

}

