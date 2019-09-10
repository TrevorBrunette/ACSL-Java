package Practice_Problems_Misc;

import java.util.Scanner;

public class Senior_2013_Problem_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] word = scan.nextLine().split(", ");
        int[] values = getValues(word);
        for(int i = 0; i < 5; i++){
            String[] tests = scan.nextLine().split(", ");
            int max = getScore(getPos(tests[0], tests[1]), values);
            int score2 = getScore(getPos(tests[2], tests[3]), values);
            int score3 = getScore(getPos(tests[4], tests[5]), values);

            if(score2 > max) max = score2;
            if(score3 > max) max = score3;
            System.out.println(max);
        }
    }

    public static int[] getValues(String[] word){
        int[] values = new int[word.length];
        for(int i = 0; i < values.length; i++){
            String s = word[i];
            if(s.equals("A") || s.equals("E")) values[i] = 1;
            else if(s.equals("D") || s.equals("R")) values[i] = 2;
            else if(s.equals("B") || s.equals("M")) values[i] = 3;
            else if(s.equals("V") || s.equals("Y")) values[i] = 4;
            else if(s.equals("J") || s.equals("X")) values[i] = 8;
            else values[i] = 0;
        }
        return values;
    }

    public static int[] getPos(String start, String direction){
        int val = direction.equals("H") ? 1 : 10;
        int[] pos = new int[4];
        pos[0] = Integer.parseInt(start);
        for(int i = 1; i < 4; i++){
            pos[i] = pos[i-1] + val;
        }
        return pos;
    }

    public static int getScore(int[] pos, int[] points){
        int score = 0;
        int wordMult = 1;
        for(int i = 0; i < pos.length; i++){
            int mult = 1;
            char gim = getBonus(pos[i]);
            if(gim=='d') mult *= 2;
            else if(gim=='t') mult *= 3;
            else if(gim=='D') wordMult *= 2;
            else if(gim=='T')wordMult *= 3;
            score += (mult * points[i]);
        }

        return score * wordMult;
    }

    public static char getBonus(int pos){
        if(pos % 6 == 3) return 'd';
        else if(pos % 5 == 0) return 't';
        else if(pos % 7 == 0) return 'D';
        else if(pos % 8 == 0) return 'T';
        else return 'x';
    }
}