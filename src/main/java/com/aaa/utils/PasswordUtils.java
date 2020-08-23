package com.aaa.utils;/*
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        String res = "$2a$10$TjwhHogLdTAKVRqA1Lvw1ueuaLd685RwrmT6MIRMyWOBn5gpLO4me";
        System.out.println(encode == res);
    }

}
