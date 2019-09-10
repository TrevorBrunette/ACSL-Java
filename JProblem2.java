package com.trevor.Contests.ACSL;

import java.util.Scanner;

public class JProblem2 {


    static int tempJumps = 0;
    static boolean king = false;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().replace(" ","").split(",");
        int[] values = {};
        values = getValues(input);
        Pos p = new Pos(values[0], values[1]);
        Pos[] enemies = new Pos[values[2]];
        for(int i = 3; i < values.length - 1; i+=2){
            enemies[(i-3)/2] = new Pos(values[i], values[i+1]);
        }

        System.out.print(jumps(p, enemies));
        if(king) System.out.print(", KING");

    }

    static int[] getValues(String[] input) {
        int[] values = new int[input.length];
        for(int j = 0; j < input.length; j++){
            values[j] = Integer.valueOf(input[j]);
        }
        return values;
    }

    public static int jumps(Pos player, Pos[] enemies){
        for(Pos pos : enemies){
            int jumpsP2 = 0, jumpsM2 = 0;

            if(canGoLeft(player.getX(), player.getY())) {
                Pos plus2 = new Pos(player.getY() + 2, player.getX() - 2);
                if(canJump(player.getX(), player.getY(), pos.getX() - 1, pos.getY() + 1)) jumpsP2 = jumps(plus2, enemies) + 1;
            }

            //Try -2
            if(canGoRight(player.getX(), player.getY())) {
                Pos minus2 = new Pos( player.getY()+ 2, player.getX() + 2);
                if(canJump(player.getX(), player.getY(), pos.getX() + 1, pos.getY() + 1)) jumpsM2 = jumps(minus2, enemies) + 1;
            }
            if(player.getY() == 8) king = true;
            tempJumps = tempJumps >= (jumpsP2 >= jumpsM2 ? jumpsP2 : jumpsM2) ? tempJumps : (jumpsP2 >= jumpsM2 ? jumpsP2 : jumpsM2);
        }
        return tempJumps;
    }

    public static boolean canJump(int startX, int startY, int endX, int endY){
        return (startX + 2 == endX || startX - 2 == endX) && startY + 2 == endY;
    }

    public static boolean canGoLeft(int startX, int startY){
        return startX - 2 >= 1 && startY + 2 <= 8;
    }

    public static boolean canGoRight(int startX, int startY){
        return startX + 2 <= 8 && startY + 2 <= 8;
    }

}


class Pos{

    int x;
    int y;

    public Pos(int ay, int ax){
        x = ax;
        y = ay;
    }

    public Pos setPos(int y, int x){
        this.x = x;
        this.y = y;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public java.lang.String toString() {
        return "" + x + ", " + y;
    }
}
