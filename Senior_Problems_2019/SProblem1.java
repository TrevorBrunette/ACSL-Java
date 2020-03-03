package Senior_Problems_2019;

import java.util.ArrayList;
import java.util.Scanner;

public class SProblem1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String out = "";
        for (int d = 0; d < 5; d++) {
            String num = scan.next();
            int pos = scan.nextInt();
            int numAtPos = Integer.parseInt("" + num.charAt(num.length() - pos));
            String outNum = "";
            for (int i = 0; i < num.length(); i++) {
                if (num.length() - pos > i) outNum += Integer.parseInt("" + num.charAt(i)) + numAtPos;
                else if (num.length() - pos < i) outNum += Math.abs(Integer.parseInt("" + num.charAt(i)) - numAtPos);
                else if (num.length() - pos == i) {
                    long l = Long.parseLong(num);
                    int count = 0;
                    ArrayList<Long> foundPrimeFactors = new ArrayList<>();
                    while (l != 1) {
                        long factor = 2;
                        while (l % factor != 0) {
                            if(factor*factor > Long.parseLong(num)) break;
                            factor++;
                        }
                        if(l%factor == 0) {
                            l /= factor;
                            if (!foundPrimeFactors.contains(factor)) count++;
                            foundPrimeFactors.add(factor);
                        } else {
                            count++;
                            break;
                        }
                    }
                    outNum += count;
                }
            }
            out += outNum + "\n";
        }
        System.out.print("\n" + out);
    }
}