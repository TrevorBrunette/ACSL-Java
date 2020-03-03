package Senior_Problems_2019;

import java.util.Scanner;

public class SProblem3 {


    private final int B = 0;
    private final int D = 1;
    private final int NOTB = 2;

    private final int A = 3;
    private final int C = 4;
    private final int NOTA = 5;

    private final int NOTD = 6;
    private final int NOTC = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String bexp = "";
        int[][] veit = getGridForHex(str);

        int[][] check = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0 ,0},
                {1, 1, 0, 0}};

    }

    public static boolean checkGrid(int[][] grid, int[][] pattern) {
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(grid[i][j] != pattern[i][j] && (pattern[i][j]==1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] gridREMOVE(int[][] grid1, int[][] grid2){
        int[][] outGrid = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(grid1[i][j] == grid2[i][j]) outGrid[i][j] = 0;
                else outGrid[i][j] = 1;
            }
        }
    }

    public static int[][] gridAND(int[][] grid1, int[][] grid2){
        int[][] outGrid = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(grid1[i][j] == 1 && grid2[i][j] == 1) outGrid[i][j] = 1;
            }
        }
        return outGrid;
    }

    public static int[][] getGrid(String bexp){
        int[][] out = new int[4][4];
        if(bexp.equals("A")){
            return getGridForHex("CCCC");
        }
        else if(bexp.equals("B")){
            return getGridForHex("FF00");
        }
        else if(bexp.equals("C")){
            return getGridForHex("6666");
        }
        else if(bexp.equals("D")){
            return getGridForHex("0FF0");
        }
        return getGridForHex("0000");
    }

    public static int[][] negate(int[][] grid){
        int[][] newGrid = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(grid[i][j]==0) newGrid[i][j]=1;
                else newGrid[i][j] = 0;
            }
        }
        return newGrid;
    }

    public static int[][] getGridForHex(String hex){
        int[][] grid = new int[4][4];
        for(int i = 0; i < 4; i++){
            String bstring = Integer.toBinaryString(Integer.parseInt("" + hex.charAt(i), 16));
            while(bstring.length() < 4){
                bstring = "0" + bstring;
            }
            for(int j = 0; j < 4; j++){
                grid[i][j] = bstring.charAt(j)-48;
            }
        }
        return grid;
    }

    public static void printGrid(int[][] grid){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}