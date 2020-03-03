package Practice_Problems_Misc;

import java.util.Scanner;

public class Senior_2013_Problem_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int a = 0; a < 5; a++) {
            String[] params = scan.nextLine().split(", ");
            String line = params[0];
            String num = params[1];
            boolean comma;
            boolean dollar;
            int decimalLoc;

            comma = line.contains(",");
            dollar = line.contains("$");
            decimalLoc = line.length() - line.indexOf('.') - 1;
            String out = "";
            if(line.contains("E")){
                int size = line.length()-2;
                int e = 0;
                double value = Double.valueOf(num);
                while(value >= 10) {
                    value /= 10;
                    e++;
                }
                out = "" + round(value, size);
                while(out.length() < size+2){
                    out += 0;
                }
                out += "E" + e;
            }
            else if(line.contains(",")){
                int count = 0;
                line = line.replace(",", "");
                for(int i = num.length()-1; i >= 0; i--){
                    out = num.charAt(i) + out;
                    if((num.length()-i)%3==0 && i!=0){
                        out = "," + out;
                        count++;
                    }
                }
                for(int f = 0; f < line.length() - num.length(); f++){
                    out = "*" + out;
                }
            }
            else if(line.contains("*$")){
                out = "$" + num;
                for(int i = 0; i < line.length() - num.length() - 2; i++) out = "*" + out;
            }
            else if(line.contains("$")){
                out = "$" + num;
            }
            else if(line.contains(".")){

            }
            else{
                for(int i = 0; i < line.length() - num.length(); i++) out += "*";
                out += num;
            }
            System.out.println(out);

        }
    }

    public static double round(double value, int decimalLength){
        value = (int)((value * Math.pow(10, decimalLength + 1) + 5)/10);
        value = value * Math.pow(10, -1 * decimalLength);
        return value;
    }

}
