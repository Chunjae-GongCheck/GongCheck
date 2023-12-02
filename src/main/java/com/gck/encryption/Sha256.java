package com.gck.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    public static String getHash(String input, String salt){
        String result = "";
        try {
            // SHA256 알고리즘 객체 생성
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // salt 지정
            String newSalt = "GongCheck" + salt;

            // 비밀번호와 salt 합친 문자열에 SHA 256 적용
            md.update((input + newSalt).getBytes());
            byte[] hash = md.digest();

            // byte To String (10진수의 문자열로 변경)
            StringBuffer sb = new StringBuffer();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 예외 발생시 "" 문자열 리턴
            e.printStackTrace();
        }

        return result;
    }
}
