import java.util.Scanner;

/**
 * 顺时针旋转二维矩阵（2018携程春招）
 * <p>
 * Created by Jiacheng on 2018/3/30.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        /**
         * 直接输入N*N的矩阵：
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int length = a.length;
        String[][] matrix = new String[length][length];
        for (int i = 0; i < length; i++) {
            matrix[0][i] = a[i];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = sc.next();
            }
        }
        rotate(matrix);
        print(matrix);
    }

    private static void rotate(String[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR) {
            rotate2(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotate2(String[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        String temp;
        for (int i = 0; i != times; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    private static void print(String[][] matrix) {
        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

