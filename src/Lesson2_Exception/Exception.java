package Lesson2_Exception;

import java.util.Arrays;

public class Exception  {
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
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    public static String [][] arrString(String s) throws ArrayIndexOutOfBoundsException{
        int m = 4;
        char t = 32; // пробел
        String p = s.replaceAll(Character.toString(t), ",");
        String[] g = p.split("\n");
        if (g.length > 4)
            throw new ArrayIndexOutOfBoundsException("");
        String[][] s2 = new String[m][];
        for (int i = 0; i < g.length; i++) {
            s2[i] = new String[]{g[i]};
        }
        return s2;
    }

    public static int sumArray (String[][] s) throws NumberFormatException {
        int sum = 0;
        int a; // Exception - NumberFormatException
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
                a = Integer.parseInt(s[i][j]);
                sum = sum + a;
                throw new NumberFormatException ();
            }
        }
        return sum/2;

    }

    public static int forInt (String[][] a){
        int v = 0;
        return v;
    }
}
