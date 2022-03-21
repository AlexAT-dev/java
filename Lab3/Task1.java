import java.util.Scanner;

public class Task1 {
    public static void ArrayPairNum(int[] arr)
    {
        boolean found = false;
        for (int val: arr) {
            if(val % 2 == 0)
            {
                System.out.println(val);
                found = true;
            }
        }
        if(!found) System.out.println("Парних елементів не знайдено!");
    }

    public static void ArrayUnpairNumLow10(int[] arr)
    {
        boolean found = false;
        for (int val: arr) {
            if(val % 2 != 0 && val < 10)
            {
                System.out.println(val);
                found = true;
            }
        }
        if(!found) System.out.println("Непарних елементів, які менші 10 не знайдено!");
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);

        int[] arr = ArrayFn.ArrayCreate();
        System.out.println("Введення масиву: ");
        ArrayFn.ArrayInput(arr);

        System.out.println("Парні елементи масиву:");
        ArrayPairNum(arr);
        System.out.println("Непарні елементи масиву, які менші 10:");
        ArrayUnpairNumLow10(arr);
    }
}
