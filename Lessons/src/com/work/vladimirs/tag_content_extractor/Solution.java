package com.work.vladimirs.tag_content_extractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        Pattern pattern = Pattern.compile("<(.+>)(.[^<>]+)</\\1");
        while(testCases>0){
            String line = in.nextLine();

            Matcher matcher = pattern.matcher(line);
            boolean isFound = false;
            while (matcher.find()) {
                isFound = true;
                String found = matcher.group(2);
                System.out.println(found);
            }
            if (!isFound) System.out.println("None");
            testCases--;
        }
    }

}
