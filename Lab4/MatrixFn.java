import java.util.Scanner;
import java.util.Random;

public class MatrixFn {
    public static int RRandom(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void MatrixRandom(int[][] matrix, int min, int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = RRandom(min, max);
            }
        }
    }

    public static void MatrixRandom(int[][] matrix)
    {
        MatrixRandom(matrix, -100, 100);
    }

    public static void MatrixInput(int[][] matrix)
    {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    public static void MatrixOutput(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] MatrixCreate()
    {
        Scanner in = new Scanner(System.in);
        int rows, cols;

        do {
            System.out.print("Введіть кількість рядків матриці:");
            rows = in.nextInt();
            if(rows < 1) System.out.println("Кількість рядків матриці не може бути меньше 1!");
        }
        while (rows < 1);

        do {
            System.out.print("Введіть кількість стопвчиків матриці:");
            cols = in.nextInt();
            if(cols < 1) System.out.println("Кількість стопвчиків матриці не може бути меньше 1!");
        }
        while (cols < 1);

        return new int[rows][cols];
    }

    public static int[][] SquareMatrixCreate()
    {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть розмір квадратної матриці:");
            n = in.nextInt();
            if(n < 2) System.out.println("Розмір квадратної матриці не може бути меньше 2!");
        }
        while (n < 2);

        return new int[n][n];
    }
}
