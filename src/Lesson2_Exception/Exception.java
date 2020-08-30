package Lesson2_Exception;

import java.util.Arrays;

public class Exception {
    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[] g = s.split("\n",4);

        System.out.println(s);
        char c = 32; // пробел
        char h = 44; // запятая
        System.out.println(Arrays.toString(g));
        System.out.println(s.charAt(8));

        arrString(s);
        System.out.println(arrString(s));
    }

    public static String [][] arrString(String s) {
        int m = 4;
        char c = '\n';
        s.split("\n",4);
        String[][] s2 = new String[m][];

        int start = 0;
        for (int j = 0; j < m; j++) {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    s2 = new String[j][i];
                }
                else {m++;
                    start = i++;}
            }
        } return s2;
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
