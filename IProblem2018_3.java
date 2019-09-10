package com.trevor.Contests.ACSL;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class IProblem2018_3 {

    private static int[] blacked = new int[1];

    public static void main(String[] args) {

        int rows, cols, start, curPos, curX, curY;
        String finalPrint = "";
        Scanner scan = new Scanner(new BufferedInputStream(System.in));

        for(int t = 0; t < 5; t++) {
            String[] input = scan.nextLine().split(" ");
            int[] output = JProblem2.getValues(input);
            rows = output[0];
            cols = output[1];
            start = (curPos = output[2]);
            curX = (curPos-1) % cols;
            curY = (curPos-1) / (cols);
            if(output[3] > 0) {
                blacked = new int[output[3]];
                for (int i = 0; i < blacked.length; i++) {
                    blacked[i] = output[i + 4];
                }
            }
            String toPrint = "";
            if(start % cols == 1){
                while (!(curX == cols)) {
                    if ((spaceIsNotBlack(curPos + 1) && spaceIsNotBlack(curPos + 2) && curX + 3 <= cols)) {
                        curX += 3;
                        curPos = 1 + curX + curY * cols;
                        toPrint += 'A';
                    }
                    if ((spaceIsNotBlack(curPos + cols + 1) && spaceIsNotBlack(curPos + cols) && curX + 2 <= cols && curY + 1 <= rows-1) && !(curX == cols)) {
                        curX += 2;
                        curY += 1;
                        curPos = 1 + curX + curY * cols;
                        toPrint += 'B';
                    }
                    if ((spaceIsNotBlack(curPos + 1) && spaceIsNotBlack(curPos + cols + 1) && spaceIsNotBlack(curPos + 1 + 2 * cols) && curX + 1 <= cols && curY + 2 <= rows-1) && !(curX == cols)) {
                        curX += 2;
                        curY += 2;
                        curPos = 1 + curX + curY * cols;
                        toPrint += 'C';
                    }
                }
            }
            else{

                while(!(curX+1 == 0)){
                    if ((spaceIsNotBlack(curPos) && spaceIsNotBlack(curPos-1) && spaceIsNotBlack(curPos-2) && curX-3 >= -1)) {
                        curX -= 3;
                        curPos = 1 + curX + curY * cols;
                        toPrint = 'A' + toPrint;
                    }
                    if ((spaceIsNotBlack(curPos) && spaceIsNotBlack(curPos-1) && spaceIsNotBlack(curPos-1-cols) && curX-2 >= -1 && curY-1 >= 0) && !(curX+1 == 0)) {
                        curX -= 2;
                        curY -= 1;
                        curPos = 1 + curX + curY * cols;
                        toPrint = 'B' + toPrint;
                    }
                    if ((spaceIsNotBlack(curPos) && spaceIsNotBlack(curPos-cols) && spaceIsNotBlack(curPos-2*cols) && spaceIsNotBlack(curPos-1-2*cols) && curX-2 >= -1 && curY-2 >= 0) && !(curX+1 == 0)) {
                        curX -= 2;
                        curY -= 2;
                        curPos = 1 + curX + curY * cols;
                        toPrint = 'C' + toPrint;
                    }
                }
            }

            finalPrint += toPrint + "\n";
        }

        System.out.println(finalPrint);
    }

    public static boolean spaceIsNotBlack(int posToCheck){

        for(int i : blacked){
            if(posToCheck == i) return false;
        }
        return true;
    }
}