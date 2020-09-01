package Lesson2_Exception;

import java.io.IOException;
import java.util.Arrays;

public class ExceptionLesson {
    public static void main(String[] args) {

        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n";
        String[] g = s.split("\n");
        String[] v = g[0].split(" ");
        String[] p = g[1].split(" ");
        String[] x = g[2].split(" ");
        String[] d = g[3].split(" ");
        String[][] s2 = {v,p,x,d};
        int q = Integer.parseInt(s2[0][1]);
        char h = (char) 48;

        System.out.println("g = " + Arrays.toString(g));
        System.out.println("g = " + Arrays.toString(v));
        System.out.println("n = " + (s2));
        System.out.println("n1 = " + Arrays.toString(s2[1]));
        System.out.println("char00 = " + (char)q + h);

        try {
            arrString(s);
            String[][] a = arrString(s);
            System.out.println("a = " + Arrays.toString(a));
            sumArray(a);
            System.out.println("Sum = " + sumArray(a));
        }catch ( IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static String [][] arrString(String s) throws IOException{
        int m = 4;
        char t = 32; // пробел
//         String p = s.replaceAll(Character.toString(t), ","); // заменитьпробел на запятую
        String[] g = s.split("\n");
        if (g.length != 4)
            throw new IOException("This is not a 4x4 matrix g.length");
//        String[][] s2 = new String[m][];
        String[] v = g[0].split(" ");
        String[] p = g[1].split(" ");
        String[] x = g[2].split(" ");
        String[] d = g[3].split(" ");
        String[][] s2 = {v,p,x,d};
//        for (int i = 0; i < g.length; i++) {
//            for (int j = 0; j < g.length; j++){
//                String[] v = new String[j];
//                v = g[j].split(" ");
//                    s2[i][j] = v[j];
//                    }
        for (int i = 0; i < g.length; i++) {
            if (s2[i].length != 4 || g.length != 4)
                throw new IOException("This is not a 4x4 matrix s2[i].length");
        }
        return s2;
    }



    public static int sumArray (String[][] s) throws ClassNotFoundException {
        int sum = 0;
        int a;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
//                if ( s[i][j].charAt(i) >= 0 || s[i][j].charAt(i) <= 9)
//                    throw new ClassNotFoundException ("This number is not int");
                a = Integer.parseInt(s[i][j]);
                char h = (char)a;
                if( (char)a  >= (char) 48 || (char)a  <= (char) 57) throw new ClassNotFoundException ("This number is not int");
                sum = sum + a;
            }
        }
        return sum/2;
    }
}