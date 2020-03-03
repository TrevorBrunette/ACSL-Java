package Senior_Problems_2019;

import java.util.Scanner;
public class SProblem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            String string1 = modify(scan.nextLine());
            String string2 = modify(scan.nextLine());
            System.out.print("\n" + factor(string1, string2));
        }
    }
    public static String modify(String str){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 65 && c <= 122) newStr += str.charAt(i);
        }
        return newStr.toUpperCase();
    }
    public static int factor(String string1, String string2){
        if(string1.equals("") || string2.equals("")) return 0;
        String longestString = "";
        for(int i = 0; i < string1.length(); i++){
            for(int j = i+1; j <= string1.length(); j++){
                String testString1 = string1.substring(i, j);
                for(int k = 0; k < string2.length()-testString1.length()+1; k++) {
                    for(int l = k+1; l <= string2.length(); l++){
                        String testString2 = string2.substring(k, l);
                        if(testString1.equals(testString2)){
                            if(testString1.length() > longestString.length()) {
                                longestString = testString1;
                            }
                            if(testString1.length() == longestString.length() &&
                                    longestString.compareTo(testString1) > 0){
                                longestString = testString1;
                            }
                        }
                    }
                }
            }
        }
        if(longestString.equals("")) return 0;
        String[] fourSubstrings = {string1.substring(0, string1.indexOf(longestString)),
                string1.substring(string1.indexOf(longestString)+longestString.length()),
                string2.substring(0, string2.indexOf(longestString)),
                string2.substring(string2.indexOf(longestString)+longestString.length())};
        int sum = 0;
        sum += factor(fourSubstrings[0], fourSubstrings[2]);
        sum += factor(fourSubstrings[1], fourSubstrings[3]);
        return sum + longestString.length();
    }
}