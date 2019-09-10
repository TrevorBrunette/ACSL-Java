package com.trevor.Contests.ACSL;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class IProblem2018_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String str = "";
        for(int t = 0; t < 5; t++){
            String[] input = in.nextLine().split(" ");
            if(input.length == 2) {
                BigInteger output = new BigInteger("0");
                int length = Integer.valueOf(input[1]);
                for (int i = 0; i <= input[0].length() - length; i++) {
                    output = output.add(new BigInteger(input[0].substring(i, i + length)));
                }
                str += "\n" + output.toString();
            }
        }
        System.out.print(str);
    }

}
