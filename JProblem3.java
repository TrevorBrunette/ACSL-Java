package com.trevor.Contests.ACSL;

import java.util.Scanner;

public class JProblem3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        boolean isPal = false;
        for(int i = 0; i < 10; i++){
            String str = Integer.valueOf(input).toString();
            String out = "";
            for(int a = str.length() - 1; a >= 0; a--){
                out += str.charAt(a);
            }
            int pal = Integer.valueOf(out);
            if(input == pal){
                isPal = true;
                break;
            }
            input += pal;
        }
        if(!isPal) System.out.print("NONE, ");
        System.out.println(input);
    }

}

