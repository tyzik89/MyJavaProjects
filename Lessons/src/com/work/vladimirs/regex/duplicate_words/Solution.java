package com.work.vladimirs.regex.duplicate_words;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        String regex = "(?i)(\\b\\w+?\\b)(\\s+(\\1))*"; // Modifier (?i) = Pattern.CASE_INSENSITIVE
        Pattern p = Pattern.compile(regex);

        List<String> strings = new ArrayList<String>(){{
            add("Goodbye bye bye world world world");
            add("Sam went went to to to his business");
            add("Reya is is the the best player in eye eye game");
            add("in inthe");
            add("Hello hello Ab aB");
        }};

        for (String input : strings) {
            System.out.println(input);
            Matcher m = p.matcher(input);
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                System.out.println("m.group(): " + m.group() + ";m.group(1): " + m.group(1) + "; m.group(2):" + m.group(2));
                input = input.replaceAll(m.group(), m.group(1));
            }
            // Prints the modified sentence.
            System.out.println(input + "\n");
        }
    }

}
