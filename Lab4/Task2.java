import java.util.Scanner;

public class Task2 {

    public static void ArrayInput(int[] arr)
    {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextInt();
    }

    public static boolean ExistsInArray(int key, int[] arr)
    {
        for (int val: arr)
            if(key == val) return true;

        return false;
    }

    public static int MatrixFoundTask(int[][] matrix, int[] arr) throws Exception {
        int min = matrix[0][0];
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] <= min && !ExistsInArray(matrix[i][j], arr))
                {
                    min = matrix[i][j];
                    found = true;
                }
            }
        }
        if(found) return min;
        else throw new Exception("Мінімальний елемент матриці, який не входить до складу елементів вектора НЕ ЗНАЙДЕНО!");
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);

        int[][] matrix = MatrixFn.MatrixCreate();

        char sel;
        do
        {
            System.out.println("Оберіть метод заповнення матриці:");
            System.out.println("1 — ввід елементів з клавіатури");
            System.out.println("2 — рандомайзер.");
            System.out.print("метод: ");
            sel = in.next().charAt(0);

            switch (sel)
            {
                case '1':
                    System.out.println("Введення матриці(" + matrix[0].length + "x" + matrix.length + "):" );
                    MatrixFn.MatrixInput(matrix);
                    break;
                case '2':
                    System.out.println("Матриця:");
                    MatrixFn.MatrixRandom(matrix);
                    MatrixFn.MatrixOutput(matrix);
                    break;
                default:
                    System.out.println("Дані введено некорректно!");
                    break;
            }
            System.out.println();
        } while (sel != '1' && sel != '2');

        int k;
        System.out.println("Створення вектору:");
        do {
            System.out.print("\tРозмір:");
            k = in.nextInt();
            if(k < 1) System.out.println("Розмір вектору не може бути меньше 1!");
        }
        while (k < 1);

        int[] vector = new int[k];
        System.out.println("Введення вектору:");
        ArrayInput(vector);

        try {
            System.out.println("Мінімальний елемент матриці, який не входить до складу елементів вектора: " + MatrixFoundTask(matrix, vector));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
