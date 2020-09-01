package Lesson2_Exception;

import java.io.IOException;
import java.util.Arrays;

public class ExceptionLesson {
    public static void main(String[] args) {
        char t = 32; // пробел
        char h = 44; // запятая
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        System.out.println("без замены " + s);
        String p = s.replaceAll(Character.toString(t), ",");
        System.out.println("замена запятой " + p);


        for (int i = 0; i <s.length() ; i++){

            if (s.charAt(i) == t);
        }
        String[] g = p.split("\n");
        char [] f =  p.toCharArray();

        System.out.println("s.toCharArray(f) = " + f);
        char m = 32; // пробел
        char n = 44; // запятая
        System.out.println(Arrays.toString(g));

        try {
            arrString(s);
            String[][] a = arrString(s);
            System.out.println(Arrays.toString(a));
            sumArray(a);
            System.out.println("Sum = " + sumArray(a));
        }catch ( IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static String [][] arrString(String s) throws IOException{
        int m = 4;
        char t = 32; // пробел
        String p = s.replaceAll(Character.toString(t), ",");
        String[] g = p.split("\n");
        if (g.length != 4)
            throw new IOException("This is not a 4x4 matrix");
        String[][] s2 = new String[m][];
        for (int i = 0; i < g.length; i++) {
            s2[i] = new String[]{g[i]};
            if (s2[i].length != 4 )
                throw new IOException("This is not a 4x4 matrix");
        }

        return s2;
    }

    public static int sumArray (String[][] s) throws ClassNotFoundException {
        int sum = 0;
        int a;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
                if ( s[i][j].charAt(j) >= 48 || s[i][j].charAt(j) <= 57)
                    throw new ClassNotFoundException ("This number is not int");
                a = Integer.parseInt(s[i][j]);
                sum = sum + a;
            }
        }
        return sum/2;
    }

}
