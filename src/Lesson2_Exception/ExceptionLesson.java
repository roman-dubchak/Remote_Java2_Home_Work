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
                try {
                a = Integer.parseInt(s[i][j]);
                } catch (NumberFormatException e) {
                    throw new ClassNotFoundException("This number is not int");
                }
                sum = sum + a;
            }
        }
        return sum/2;
    }

//    private static final class RowMismatchException extends RuntimeException {
//        RowMismatchException(String message) {
//            super("Rows exception: " + message);
//        }
//    }
//
//    private static final class ColumnMismatchException extends RuntimeException {
//        ColumnMismatchException(String message) {
//            super("Columns exception: " + message);
//        }
//    }
//
//    private static final class NumberIsNotNumberException extends RuntimeException {
//        NumberIsNotNumberException(String message) {
//            super("Not a number found: " + message);
//        }
//    }
//
//    private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
//    private static final String EXTRA_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n1 2 3 4";
//    private static final String EXTRA_COL_STRING = "1 3 1 2 1\n2 3 2 2 1\n5 6 7 1 1\n3 3 1 0 1";
//    private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
//    private static final String NO_COL_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1";
//    private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 A";
//
//    private static final int MATRIX_ROWS = 4;
//    private static final int MATRIX_COLS = 4;
//
//    private static String[][] stringToMatrix(String value) {
//        String[] rows = value.split("\n");
//        if (rows.length != MATRIX_ROWS)
//            throw new RowMismatchException(rows.length + ":\n" + value);
//
//        String[][] result = new String[MATRIX_ROWS][];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = rows[i].split(" ");
//            if (result[i].length != MATRIX_COLS)
//                throw new ColumnMismatchException(result[i].length + ":\n" + value);
//        }
//        return result;
//    }
//
//    private static float calcMatrix(String[][] matrix) {
//        int result = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                try {
//                    result += Integer.parseInt(matrix[i][j]);
//                } catch (NumberFormatException e) {
//                    throw new NumberIsNotNumberException(matrix[i][j]);
//                }
//            }
//        }
//        return result / 2f;
//    }
//
//    public static void main(String[] args) {
//        try {
////            final String[][] matrix = stringToMatrix(CORRECT_STRING);
////            final String[][] matrix = stringToMatrix(NO_ROW_STRING);
////            final String[][] matrix = stringToMatrix(NO_COL_STRING);
//            final String[][] matrix = stringToMatrix(HAS_CHAR_STRING);
//            System.out.println(Arrays.deepToString(matrix));
//            System.out.println("Half sum = " + calcMatrix(matrix));
//        } catch (NumberIsNotNumberException e) {
//            System.out.println("A NumberFormatException is thrown: " + e.getMessage());
//        } catch (RowMismatchException | ColumnMismatchException e) {
//            System.out.println("A RuntimeException successor is thrown: " + e.getMessage());
//        }
//    }
//}
}