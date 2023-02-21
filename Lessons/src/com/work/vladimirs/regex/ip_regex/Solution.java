package com.work.vladimirs.regex.ip_regex;


import java.util.Scanner;

/**
 * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
 * Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
 */
public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    static class MyRegex {
        final String pattern = "^((25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9]{1,2})\\.){3}((25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9]{1,2})){1}$";
    }

    static class TestMyRegex {

        public static void main(String[] args) {
            MyRegex myRegex = new MyRegex();
            System.out.println("12.12.12.12 -> " + "12.12.12.12".matches(myRegex.pattern));
            System.out.println("13.13.13.112 -> " + "13.13.13.112".matches(myRegex.pattern));
            System.out.println("VUUT.12.12 -> " + "VUUT.12.12".matches(myRegex.pattern));
            System.out.println("111.111.11.111 -> " + "111.111.11.111".matches(myRegex.pattern));
            System.out.println("1.1.1.1.1.1.1 -> " + "1.1.1.1.1.1.1".matches(myRegex.pattern));
            System.out.println("1...1..1..1 -> " + "1...1..1..1".matches(myRegex.pattern));
            System.out.println("0.0.0.0 -> " + "0.0.0.0".matches(myRegex.pattern));
            System.out.println("255.0.255.0 -> " + "255.0.255.0".matches(myRegex.pattern));
            System.out.println("266.266.266.266 -> " + "266.266.266.266".matches(myRegex.pattern));
            System.out.println("00000.000000.0000000.00001 -> " + "00000.000000.0000000.00001".matches(myRegex.pattern));
            System.out.println("0023.0012.0012.0034 -> " + "0023.0012.0012.0034".matches(myRegex.pattern));
            System.out.println("000.12.12.034 -> " + "000.12.12.034".matches(myRegex.pattern));
            System.out.println("121.234.12.12 -> " + "121.234.12.12".matches(myRegex.pattern));
            System.out.println("23.45.12.56 -> " + "23.45.12.56".matches(myRegex.pattern));
            System.out.println("00.12.123.123123.123 -> " + "00.12.123.123123.123".matches(myRegex.pattern));
            System.out.println("I.Am.not.an.ip -> " + "I.Am.not.an.ip".matches(myRegex.pattern));
        }
    }
}
