package com.learn.coding.decoding;

import java.io.UnsupportedEncodingException;

/**
 * @author glongone
 * @date 2021/5/7 9:45 上午
 * @desc 文本内容编码转换
 */
public class Main {
    /**
     * tomcat 默认使用iso-8859-1编码， 也就是说，如果原本字符串是GBK的，tomcat传输过程中，将GBK转成iso-8859-1了。
     * 默认情况下，使用iso-8859-1读取中文肯定是有问题的，那么我们需要将iso-8859-1 再转成GBK， 而iso-8859-1 是单字节编码的，
     * 即他认为一个字节是一个字符， 那么这种转换不会对原来的字节数组做任何改变，因为字节数组本来就是由单个字节组成的。
     * 如果之前用GBK编码，那么转成iso-8859-1后编码内容完全没变， 则 s.getBytes(“iso-8859-1”) 实际上还是原来GBK的编码内容。
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "VehicleIdä¸\u008Dè\u0083½ä¸ºç©º";
        System.out.println(new String(str.getBytes("iso-8859-1"), "UTF-8"));
    }

}
