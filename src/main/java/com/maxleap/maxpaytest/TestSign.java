package com.maxleap.maxpaytest;

/**
 * Created by johnny on 16/1/5.
 */

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;

public class TestSign {

    public static String getHash(String source, String hashType){
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;

        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes("UTF-8"));
            for (byte b:md5.digest()){
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String appId = "568a12086e912100017722e5";
        String masterKey = "VndFblU2ZGw3X1d1d2tNZnNqd3Npdw";
        String timeStamp = "1451989779598";
        String source = appId+masterKey+timeStamp;
//        System.out.println(getHash(source,"MD5"));

        System.out.println(DigestUtils.md5Hex(source));
    }
}
