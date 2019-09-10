package Junior_Problems_2001;

import java.util.Scanner;

public class JProblem4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();
        int f = scan.nextInt();

        int zero = -f + a*(d/a/2)*(d/a/2) + c*(e/c/2)*(e/c/2);
        String type = a == c ? "Circle, " : "Ellipse, ";
        int up = a > c ? a : c;
        System.out.println(d/a/2 + ", " + e/c/2);
        System.out.println(type + "(" + -d/a/2 + ", " + -e/c/2 + "), " + Math.sqrt(zero/up));
    }

}
