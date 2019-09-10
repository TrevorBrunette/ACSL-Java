package Intermediate_Problems_2018;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IProblem4 {

    public static void main(String[] args) {
        String toPrint = "";
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        for(int i = 0; i < 5; i++){
            ArrayList<String> terms = new ArrayList<String>(Arrays.asList(scan.nextLine().split(" ")));
            int index = terms.size() - 1;
            while (terms.size() > 1) {
                if (terms.get(index - 2).equals("+") || terms.get(index - 2).equals("-") || terms.get(index - 2).equals("*")) {
                    terms.set(index - 2, "" + doOp(terms.get(index - 2), terms.get(index - 1), terms.get(index), "0"));
                    terms.remove(index - 1);
                    terms.remove(index - 1);
                    index = terms.size() - 1;
                } else if (terms.get(index - 3).equals(">") || terms.get(index - 3).equals("@")) {
                    terms.set(index - 3, "" + doOp(terms.get(index - 3), terms.get(index - 2), terms.get(index - 1), terms.get(index)));
                    terms.remove(index - 2);
                    terms.remove(index - 2);
                    terms.remove(index - 2);
                    index = terms.size() - 1;
                } else {
                    index--;
                }
            }
            toPrint += (terms.get(0) + "\n");
        }
        System.out.println(toPrint);
    }

    private static int doOp(String term, String num1, String num2, String num3){
        if(term.equals("+")){
            return Integer.valueOf(num1) + Integer.valueOf(num2);
        }

        else if(term.equals("-")){
            return Integer.valueOf(num1) - Integer.valueOf(num2);
        }

        else if(term.equals("*")){
            return Integer.valueOf(num1) * Integer.valueOf(num2);
        }

        else if(term.equals(">")){
            if((Integer.valueOf(num1) >= Integer.valueOf(num2)) && (Integer.valueOf(num1) >= Integer.valueOf(num3))){
                return Integer.valueOf(num1);
            }
            else if((Integer.valueOf(num2) >= Integer.valueOf(num1)) && (Integer.valueOf(num2) >= Integer.valueOf(num3))){
                return Integer.valueOf(num2);
            }
            else{
                return Integer.valueOf(num3);
            }
        }
        else if (term.equals("@")){
            return Integer.valueOf(num1) > 0 ? Integer.valueOf(num2) : Integer.valueOf(num3);
        }
        else return -10000000;
    }

}