package com.trevor.Contests.ACSL;

import java.util.Scanner;

public class JProblem1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int in = (int)scan.nextLine().charAt(0) - 64;
        if(1 <= in && in <=5){
            in *= 2;
        }
        else if(6 <= in && in <=10){
            in = (in % 3) * 5;
        }
        else if(11 <= in && in <=15){
            in = (in / 4) * 8;
        }
        else if(16 <= in && in <=20){
            in = ((in % 10) + (in / 10)) * 10;
        }
        else if(21 <= in && in <=26){
            int temp = -1;
            for(int i = 1; i < in; ++i) {
                if (in % i == 0) {
                    temp = i;
                }
            }
            in = temp * 12;
        }
        if(in == 0) {
            in = 35 - 64;
        }
        if(in >= 0) in = in % 26;
        if(in == 0) in = 26;
        System.out.println((char)(in + 64));
    }

}
