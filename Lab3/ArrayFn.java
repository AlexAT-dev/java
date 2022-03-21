import java.util.Random;
import java.util.Scanner;

public class ArrayFn {
    public static int RRandom(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void ArrayRandom(int[] arr, int min, int max)
    {
        for (int i = 0; i < arr.length; i++)
            arr[i] = RRandom(min, max);
    }

    public static void ArrayRandom(int[] arr)
    {
        ArrayRandom(arr, -100, 100);
    }

    public static void ArrayInput(int[] arr)
    {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextInt();
    }

    public static void ArrayOutput(int[] arr)
    {
        for (int val: arr)
            System.out.println(val);
    }

    public static int[] ArrayCreate()
    {
        Scanner in = new Scanner(System.in);
        int n = 0;

        do {
            System.out.print("Введіть розмір масиву:");
            n = in.nextInt();
            if(n < 1) System.out.println("Розмір масиву не може бути меньше 1!");
        }
        while (n < 1);

        return new int[n];
    }
}
