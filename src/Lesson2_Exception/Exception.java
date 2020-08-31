package Lesson2_Exception;

import java.util.Arrays;

public class Exception {
    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[] g = s.split("\n");

        System.out.println("s.charAt(i) = " + g.length + g.toString());
        char b = 32; // пробел
        char h = 44; // запятая
        System.out.println(Arrays.toString(g));

        arrString(s);

    }

    public static String [][] arrString(String s) {
        int m = 4;
        String[] g = s.split("\n");
        String[][] s2 = new String[m][];
        for (int i = 0; i < g.length; i++) {
            s2[i] = new String[]{g[i]};
        }
        return s2;
    }

    public static int sumArray (String[][] s){
        int sum = 0;
        byte[] a;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
                a = (s[i][j].getBytes());
                sum = sum ; // + a[i][j];
            }
        }
        return sum/2;
    }


    public static boolean checkFour(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '\n');
           count++;
        }
        return (count == 3);
    }
}
