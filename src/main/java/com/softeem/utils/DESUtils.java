package com.softeem.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @project_name: com.softeem.utils
 * @description: 对称加密，加密解密使用的是同一个秘钥
 * @author: Nicholas Chen
 * @time: 7/02/2021 4:06 PM
 * @version: v1.0
 */
public class DESUtils {

    private static Key key;
    //设置自定义秘钥
    private static String KEY_STR = "nicholas";
    //字符编码
    private static String CHARSET_NAME = "utf-8";
    //指定DES算法
    private static String ALGORITHM = "DES";

    static{
        try {
            //DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            //运用指定安全策略SHA1
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //设置秘钥的种子
            secureRandom.setSeed(KEY_STR.getBytes(StandardCharsets.UTF_8));
            //初始化基于安全策略的算法对象
            generator.init(secureRandom);
            //获取秘钥对象
            key = generator.generateKey();
            //防止被二次利用，把秘钥对象设置为null
            generator = null;
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /**
     * 获取加密后的值
     * @param oriStr 原文
     * @return
     */
    public static String getEncryptedString(String oriStr){
        //基于BASE64加密编码,常用的就是byte[]转换成String
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            //把需要加密的内容转化成byte数组
            byte[] bytes = oriStr.getBytes(StandardCharsets.UTF_8);
            //获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化加密对象
            cipher.init(Cipher.ENCRYPT_MODE,key);
            //加密上面转化的byte数组
            byte[] doFinal = cipher.doFinal(bytes);
            //输出结果
            return base64Encoder.encode(doFinal);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /**
     * 获取解密后的值
     * @param encryptString 已加密的值
     * @return
     */
    public static String getDecryptedString(String encryptString){
        //基于BASE64解密编码,常用的就是byte[]转换成String
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            //把已加密的数据解密转化为byte数组
            byte[] bytes = base64Decoder.decodeBuffer(encryptString);
            //获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化解密对象
            cipher.init(Cipher.DECRYPT_MODE,key);
            //解密
            byte[] doFinal = cipher.doFinal(bytes);
            //输出结果
            return new String(doFinal,CHARSET_NAME);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //y95vXPmveW4=
        System.out.println(getEncryptedString("root"));
        //ubcyHkCxr06BGIGwI83pQA==
        System.out.println(getEncryptedString("P@ssw0rd"));
        System.out.println("==================");
        System.out.println(getDecryptedString("y95vXPmveW4="));
        System.out.println(getDecryptedString("ubcyHkCxr06BGIGwI83pQA=="));

    }

}
