package com.learning.encryption.rsa;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class SignatureWithRSA {
    // 公/私钥生成算法
    private final static String KEY_ALGORITHM = "RSA";

    // 数据签名算法
    /**
     * JDK实现的RSA签名算法有  MD2withRSA、MD5withRSA、SHA1withRSA
     * 密钥长度为512~65536（要求为64的整数倍），默认长度为1024，签名的长度和密钥长度相等
     *
     * 其他的RSA签名算法有SHA224withRSA、SHA256withRSA、SHA512withRSA等JDK并未实现，
     * 但是bouncycastle都做了支持，默认密钥为2048，签名长度同样和密钥长度相等
     * */
    private static final String SIGN_ALGORITHM = "SHA1withRSA";

    private static final String PUBLIC_KEY = "publicKey";

    private static final String PRIVATE_KEY = "privateKey";

    private static final int KEY_LENGTH = 512;

    /**
     * 初始化密钥
     * @throws Exception 异常
     * */
    public static Map<String, Key> initKey() throws Exception {
        // 实例化密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 初始化密钥长度，此处为512
        keyPairGenerator.initialize(KEY_LENGTH);
        // 获取密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取RSA公钥
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        // 获取RSA私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Key> keyMap = new HashMap<String, Key>();
        keyMap.put(PUBLIC_KEY, rsaPublicKey);
        keyMap.put(PRIVATE_KEY, rsaPrivateKey);

        return keyMap;
    }

    /**
     * 获取公钥
     * */
    public static RSAPublicKey getPublicKey(Map<String, Key> keyMap) {
        return (RSAPublicKey) keyMap.get(PUBLIC_KEY);
    }

    /**
     * 获取私钥
     * */
    public static RSAPrivateKey getPrivateKey(Map<String, Key> keyMap) {
        return (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
    }

    /**
     * 使用私钥对数据进行签名
     * @throws Exception
     * @return byte[]
     * */
    public static byte[] signatureWithPrivateKey(String data, RSAPrivateKey rsaPrivateKey) throws Exception {
        PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 获取私钥
        PrivateKey privateKey = keyFactory.generatePrivate(encodedKeySpec);

        // 使用签名算法实例化Signature
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        // 使用签名私钥进行初始化
        signature.initSign(privateKey);
        // 更新需要签名的数据
        signature.update(data.getBytes());
        // 执行签名
        byte[] signed = signature.sign();

        return signed;
    }

    /**
     * 使用公钥对签名的数据进行校验
     * @throws Exception
     * */
    public static boolean verifyWithPublicKey(String data, byte[] signed, RSAPublicKey rsaPublicKey) throws Exception {
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        // 实例化KeyFactory
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 获取签名公钥
        PublicKey publicKey = keyFactory.generatePublic(encodedKeySpec);

        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        boolean verified = signature.verify(signed);

        return verified;
    }

    public static void main(String[] args) throws Exception {
        String msg = "Hello World";
        Map<String, Key> keyMap = initKey();
        RSAPrivateKey priK = getPrivateKey(keyMap);
        RSAPublicKey pubK = getPublicKey(keyMap);
        System.out.println("签名前的数据---->" + msg);
        // 执行签名
        byte[] signedMsg = signatureWithPrivateKey(msg, priK);
        System.out.println("密钥长度---->" + KEY_LENGTH);
        System.out.println("签名后数据长度---->" + signedMsg.length * 8);
        System.out.println("签名后的数据---->" + Base64.encode(signedMsg));
//                .encodeBase64String(signedMsg));
        // 校验签名
        boolean verified = verifyWithPublicKey(msg, signedMsg, pubK);
        System.out.println("校验---->" + verified);
    }
}