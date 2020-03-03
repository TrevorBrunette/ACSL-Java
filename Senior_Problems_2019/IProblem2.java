package Senior_Problems_2019;

import java.util.ArrayList;
import java.util.Scanner;

public class IProblem2 {

    static boolean changed;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String toOut = "";
        for(int x = 0; x < 5; x++) {
            String s1 = scan.next();
            String s2 = scan.next();

            changed = true;

            while (changed) {
                changed = false;
                String[] toS = removeSimilar(s1, s2);
                s1 = toS[0];
                s2 = toS[1];

                for (int i = 0; i < s1.length(); i++) {
                    for (int j = 0; j < s2.length() && i < s1.length(); j++) {
                        if (s1.charAt(i) == s2.charAt(j)) {
                            if (i + 1 == j) {
                                //if the index is smaller in s1
                                s2 = s2.substring(0, i) + s2.substring(i + 1);
                                toS = removeSimilar(s1, s2);
                                i = 0;
                                j = 0;
                                s1 = toS[0];
                                s2 = toS[1];
                                changed = true;
                            } else if (i == j + 1) {
                                //if the index is smaller in s2
                                s1 = s1.substring(0, j) + s1.substring(j + 1);
                                toS = removeSimilar(s1, s2);
                                i = 0;
                                j = 0;
                                s1 = toS[0];
                                s2 = toS[1];
                                changed = true;
                            }
                        }
                    }
                }

            }

            int sum = 0;
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                sum += s1.substring(i, i + 1).compareTo(s2.substring(i, i + 1));
            }
            sum += Math.abs(s1.length() - s2.length());
            toOut += sum + "\n";
        }
        System.out.print(toOut);
    }

    public static String[] removeSimilar(String s1, String s2){
        for (int i = Math.min(s1.length(), s2.length())-1; i >= 0; i--) {
            if (s1.charAt(i) == s2.charAt(i)) {
                s1 = s1.substring(0,i)  + s1.substring(i+1);
                s2 = s2.substring(0,i)  + s2.substring(i+1);
                changed = true;
            }
        }
        String[] out = new String[2];
        out[0] = s1;
        out[1] = s2;
        return out;
    }
}