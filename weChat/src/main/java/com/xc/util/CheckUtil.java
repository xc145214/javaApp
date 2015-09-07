package com.xc.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/9/6.
 */
public class CheckUtil {
    // 微信token
    private static final String TOKEN = "weixintest";

    /**
     * 验证服务器地址的有效性
     *
     * @param signature 微信加密签名,signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestrap 时间戳
     * @param nonce     随机数
     * @return
     */
    public static boolean checkSignature(String signature, String timestrap, String nonce) {
        String[] arr = new String[]{TOKEN, timestrap, nonce};

        // 将 token, timestamp, nonce 三个参数进行字典排序
        Arrays.sort(arr);

        //生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行 shal 加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;

    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param digest
     * @return
     */
    private static String byteToStr(byte[] digest) {
        String strDigest = "";
        for (int i = 0; i < digest.length; i++) {
            strDigest += byteToHexStr(digest[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param b
     * @return
     */
    private static String byteToHexStr(byte b) {
        // TODO Auto-generated method stub
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(b >>> 4) & 0X0F];
        tempArr[1] = Digit[b & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
