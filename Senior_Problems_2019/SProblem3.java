package Senior_Problems_2019;

import java.util.ArrayList;
import java.util.Scanner;

public class SProblem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int times = 1; times <= 10; times++) {
            String str = scanner.nextLine();
            ArrayList<String> bexp = new ArrayList<>();
            int[][] veit = getGridForHex(str);

            //Check single letters
            for (int i = 0; i <= 7; i++) {
                if (checkGrid(veit, getGrid("" + i))) {
                    veit = gridREMOVE(veit, getGrid("" + i));
                    bexp.add(getLetOG(i));
                }
            }

            //Check 2 var AND statements
            for (int i = 2; i <= 3; i++) { //BD
                for (int j = 6; j <= 7; j++) {
                    if (checkGrid(veit, gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)))) {
                        veit = gridREMOVE(veit, gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)));
                        bexp.add(getLetInOrder(i) + getLetInOrder(j));
                    }
                }
            }

            for (int i = 0; i <= 1; i++) { //AC
                for (int j = 4; j <= 5; j++) {
                    if (checkGrid(veit, gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)))) {
                        veit = gridREMOVE(veit, gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)));
                        bexp.add(getLetInOrder(i) + getLetInOrder(j));
                    }
                }
            }

            for (int i = 0; i <= 2; i++) { //BDB ACA
                for (int j = 3; j <= 5; j++) {
                    if (checkGrid(veit, gridAND(getGrid("" + i), getGrid("" + j)))) {
                        veit = gridREMOVE(veit, gridAND(getGrid("" + i), getGrid("" + j)));
                        bexp.add(getLetOG(i) + getLetOG(j));
                    }
                }
            }

            for (int j = 0; j <= 2; j++) { //~C BDB
                if (checkGrid(veit, gridAND(getGrid("" + 7), getGrid("" + j)))) {
                    veit = gridREMOVE(veit, gridAND(getGrid("" + 7), getGrid("" + j)));
                    bexp.add(getLetOG(7) + getLetOG(j));
                }
            }

            for (int j = 3; j <= 5; j++) { //~D ACA
                if (checkGrid(veit, gridAND(getGrid("" + 6), getGrid("" + j)))) {
                    veit = gridREMOVE(veit, gridAND(getGrid("" + 6), getGrid("" + j)));
                    bexp.add(getLetOG(6) + getLetOG(j));
                }
            }

            if (checkGrid(veit, gridAND(getGrid("~C"), getGrid("~D")))) {
                veit = gridREMOVE(veit, gridAND(getGrid("~C"), getGrid("~D")));
                bexp.add("~C~D");
            }

            //Check 3 var AND statements
            //Check rows
            for (int i = 3; i <= 5; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("B"), getGrid("~D")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("B"), getGrid("~D")), getGrid("" + i)));
                    bexp.add("B~D" + getLetOG(i));
                }
            }
            for (int i = 3; i <= 5; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("B"), getGrid("D")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("B"), getGrid("D")), getGrid("" + i)));
                    bexp.add("BD" + getLetOG(i));
                }
            }
            for (int i = 3; i <= 5; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("~B"), getGrid("D")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~B"), getGrid("D")), getGrid("" + i)));
                    bexp.add("~BD" + getLetOG(i));
                }
            }
            for (int i = 3; i <= 5; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("~B"), getGrid("~D")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~B"), getGrid("~D")), getGrid("" + i)));
                    bexp.add("~B~D" + getLetOG(i));
                }
            }

            //Check cols
            for (int i = 0; i <= 2; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("A"), getGrid("~C")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("A"), getGrid("~C")), getGrid("" + i)));
                    bexp.add("A~C" + getLetOG(i));
                }
            }
            for (int i = 0; i <= 2; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("A"), getGrid("C")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("A"), getGrid("C")), getGrid("" + i)));
                    bexp.add("AC" + getLetOG(i));
                }
            }
            for (int i = 0; i <= 2; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("~A"), getGrid("C")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~A"), getGrid("C")), getGrid("" + i)));
                    bexp.add("~AC" + getLetOG(i));
                }
            }
            for (int i = 0; i <= 2; i++) {
                if (checkGrid(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("" + i)))) {
                    veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("" + i)));
                    bexp.add("~A~C" + getLetOG(i));
                }
            }

            //Check across rows
            if (checkGrid(veit, gridAND(gridAND(getGrid("B"), getGrid("~D")), getGrid("~C")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("B"), getGrid("~D")), getGrid("~C")));
                bexp.add("B~C~D");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("B"), getGrid("D")), getGrid("~C")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("B"), getGrid("D")), getGrid("~C")));
                bexp.add("B~CD");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("~B"), getGrid("D")), getGrid("~C")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~B"), getGrid("D")), getGrid("~C")));
                bexp.add("~B~CD");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("~B"), getGrid("~D")), getGrid("~C")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~B"), getGrid("~D")), getGrid("~C")));
                bexp.add("~B~C~D");
            }

            //Check across cols
            if (checkGrid(veit, gridAND(gridAND(getGrid("A"), getGrid("~C")), getGrid("~D")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("A"), getGrid("~C")), getGrid("~D")));
                bexp.add("A~C~D");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("A"), getGrid("C")), getGrid("~D")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("A"), getGrid("C")), getGrid("~D")));
                bexp.add("AC~D");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("~D")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("~D")));
                bexp.add("~AC~D");
            }
            if (checkGrid(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("~D")))) {
                veit = gridREMOVE(veit, gridAND(gridAND(getGrid("~A"), getGrid("~C")), getGrid("~D")));
                bexp.add("~A~C~D");
            }

            //Check 4 var AND statements
            for (int i = 0; i < 2; i++) {
                for (int j = 2; j < 4; j++) {
                    for (int k = 4; k < 6; k++) {
                        for (int l = 6; l < 8; l++) {
                            if (checkGrid(veit, gridAND(gridAND(gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)), getGridLetterOrder("" + k)), getGridLetterOrder("" + l)))) {
                                bexp.add(getLetInOrder(i) + getLetInOrder(j) + getLetInOrder(k) + getLetInOrder(l));
                                veit = gridREMOVE(veit, gridAND(gridAND(gridAND(getGridLetterOrder("" + i), getGridLetterOrder("" + j)), getGridLetterOrder("" + k)), getGridLetterOrder("" + l)));
                            }
                        }
                    }
                }
            }
            if(str.equals("0000")) System.out.print("\n"+0);
            else if(str.equals("ffff")) System.out.print("\n"+1);
            else System.out.print("\n" +sortBexp(bexp));

        }
    }

    public static String sortBexp(ArrayList<String> bexp){
        String out = sortTerm(bexp.get(0));
        for(int i = 1; i < bexp.size(); i++){
            out += "+" + sortTerm(bexp.get(i));
        }
        return out;
    }

    public static String sortTerm(String term){
        String out = "";
        while(!term.isEmpty()){
            char check = term.charAt(0);
            if(check=='~'){
                check = term.charAt(1);
                char c = check;
                for(int i = 1; i < term.length(); i++){
                    if(c>term.charAt(i)) c = term.charAt(i);
                }
                if(c==check){
                    out = out + "~" + c;
                    term = term.substring(2);
                } else {
                    term = term.substring(2) + "~" + check;
                }


            } else {//check if it is the greatest term
                char c = check;
                for(int i = 0; i < term.length(); i++){
                    if(c>term.charAt(i)) c = term.charAt(i);
                }
                if(c==check){
                    out = out + check;
                    term = term.substring(1);
                } else {
                    term = term.substring(1) + check;
                }
            }
        }
        return out;
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
                else if(grid1[i][j]==1)outGrid[i][j] = 1;
                else outGrid[i][j]=0;
            }
        }
        return outGrid;
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

    public static String getLetOG(int i){
        if(i==0) return "B";
        else if(i==1) return  "D";
        else if(i==2) return  "~B";
        else if(i==3) return  "A";
        else if(i==4) return  "C";
        else if(i==5) return  "~A";
        else if(i==6) return  "~D";
        else if(i==7) return  "~C";
        else return "*";
    }

    public static String getLetInOrder(int i){
        if(i==0) return "A";
        else if(i==1) return  "~A";
        else if(i==2) return  "B";
        else if(i==3) return  "~B";
        else if(i==4) return  "C";
        else if(i==5) return  "~C";
        else if(i==6) return  "D";
        else if(i==7) return  "~D";
        else return "*";
    }

    public static int[][] getGrid(String bexp){
        int[][] out = new int[4][4];
        if(bexp.equals("A") || bexp.equals("3")){
            return getGridForHex("CCCC");
        }
        else if(bexp.equals("B") || bexp.equals("0")){
            return getGridForHex("FF00");
        }
        else if(bexp.equals("C") || bexp.equals("4")){
            return getGridForHex("6666");
        }
        else if(bexp.equals("D") || bexp.equals("1")){
            return getGridForHex("0FF0");
        }
        else if(bexp.equals("~A") || bexp.equals("5")){
            return negate(getGrid("A"));
        }
        else if(bexp.equals("~B") || bexp.equals("2")){
            return negate(getGrid("B"));
        }
        else if(bexp.equals("~C") || bexp.equals("7")){
            return negate(getGrid("C"));
        }
        else if(bexp.equals("~D") || bexp.equals("6")){
            return negate(getGrid("D"));
        }

        return getGridForHex("0000");
    }

    public static int[][] getGridLetterOrder(String bexp){
        int[][] out = new int[4][4];
        if(bexp.equals("A") || bexp.equals("0")){
            return getGridForHex("CCCC");
        }
        else if(bexp.equals("B") || bexp.equals("2")){
            return getGridForHex("FF00");
        }
        else if(bexp.equals("C") || bexp.equals("4")){
            return getGridForHex("6666");
        }
        else if(bexp.equals("D") || bexp.equals("6")){
            return getGridForHex("0FF0");
        }
        else if(bexp.equals("~A") || bexp.equals("1")){
            return negate(getGrid("A"));
        }
        else if(bexp.equals("~B") || bexp.equals("3")){
            return negate(getGrid("B"));
        }
        else if(bexp.equals("~C") || bexp.equals("5")){
            return negate(getGrid("C"));
        }
        else if(bexp.equals("~D") || bexp.equals("7")){
            return negate(getGrid("D"));
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
}