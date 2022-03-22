import java.util.Scanner;

public class Task1 {
    public static void OutputMainDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    public static void OutputAntiDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
        System.out.println();
    }

    public static void OutputDoubleAboveMainDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = i + 1; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] * 2 + " ");
            }
        }
        System.out.println();
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);

        int[][] matrix = MatrixFn.SquareMatrixCreate();
        System.out.println("Введення квадратної матриці: ");
        MatrixFn.MatrixInput(matrix);

        System.out.println("Головна діагональ матриці: ");
        OutputMainDiagonal(matrix);

        System.out.println("Бічна діагональ матриці: ");
        OutputAntiDiagonal(matrix);

        System.out.println("Елементи, що знаходяться вище головної діагоналі, збільшені в 2 рази: ");
        OutputDoubleAboveMainDiagonal(matrix);
    }
}
