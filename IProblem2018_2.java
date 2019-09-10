package com.trevor.Contests.ACSL;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class IProblem2018_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        String toPrint = "";
        for(int t = 0; t < 5; t++) {
            String[] in = scan.nextLine().split(" ");
            String first = in[0];
            String second = in[1];
            String ABLR = output(first, second);
            String BALR = output(second, first);
            String ABRL = output(reverse(first), reverse(second));
            String BARL = output(reverse(second), reverse(first));
            String result = "";
            for (int i = 0; i < ABLR.length(); i++) {
                char c = ABLR.charAt(i);
                CharSequence cs = "" + c;
                if (BALR.contains(cs) && ABRL.contains(cs) && BARL.contains(cs)) {
                    BALR = BALR.replace(""+c, "");
                    ABRL = ABRL.replace(""+c, "");
                    BARL = BARL.replace(""+c, "");
                    result += c;
                }
            }
            char[] chars = result.toCharArray();
            Arrays.sort(chars);
            result = new String(chars);
            toPrint += "\n" + ((result.equals("")) ? "NONE" : result);
        }
        System.out.println(toPrint);
    }

    public static String output(String first, String second){
        String output = "";
        for (int i = 0; i < first.length(); i++) {
            int index = second.indexOf(first.charAt(i));
            if(index >= 0){
                output += first.charAt(i);
                second = second.substring(index + 1);
            }
        }
        return output;
    }

    public static String reverse(String str){
        String out = "";
        for(int i = str.length()-1; i >= 0; i--){
            out += str.charAt(i);
        }
        return out;
    }
}
