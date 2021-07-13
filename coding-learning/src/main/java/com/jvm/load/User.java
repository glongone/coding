package com.jvm.load;

import java.io.UnsupportedEncodingException;

/**
 * @author glongone
 * @date 2021/4/21 5:52 下午
 * @desc
 */
public class User {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "VehicleIdä¸è½ä¸ºç©º";
        System.out.println(new String(s.getBytes("iso-8859-1"), "UTF-8"));
    }
}
