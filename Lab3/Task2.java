import java.util.Scanner;
import java.util.Random;

public class Task2 {
    public static int SumArrayUnpairNum(int[] arr) throws Exception {
        boolean found = false;
        int sum = 0;
        for (int val: arr) {
            if(val % 2 != 0)
            {
                sum+=val;
                found = true;
            }
        }
        if(!found) throw new Exception("Немає непарних чисел!");
        return sum;
    }

    public static int IndexNegNumFirst(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) return i;
        }
        return -1;
    }

    public static int IndexNegNumLast(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) index = i;
        }
        return index;
    }

    public static int ArrayProductBetween(int[] arr, int first, int last) throws Exception {
        if(first == -1 || last == -1) throw new Exception("Немає від'ємних елементів!");
        else if(first == last ) throw new Exception("В масиві лише один від'ємний елемент!");
        else if(first == last-1 ) throw new Exception("Між першим і останнім від'ємним елементами немає елементів!");

        int prod = 1;
        for (int i = first+1; i < last; i++) {
            prod*=arr[i];
        }
        return prod;
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);

        int[] arr = ArrayFn.ArrayCreate();

        char sel;
        do
        {
            System.out.println("Оберіть метод заповнення масиву:");
            System.out.println("1 — ввід елементів з клавіатури");
            System.out.println("2 — рандомайзер.");
            System.out.print("метод: ");
            sel = in.next().charAt(0);

            switch (sel)
            {
                case '1':
                    ArrayFn.ArrayInput(arr);
                    break;
                case '2':
                    ArrayFn.ArrayRandom(arr);
                    ArrayFn.ArrayOutput(arr);
                    break;
                default:
                    System.out.println("Дані введено некорректно!");
                    break;
            }
            System.out.println();
        } while (sel != '1' && sel != '2');

        try
        {
            System.out.println("Сума елементів з непарними номерами: " +
                    SumArrayUnpairNum(arr));
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        try
        {
            System.out.println("Добуток елементів масиву, розташованих між першим й останнім від’ємними елементами: " +
                    ArrayProductBetween(arr, IndexNegNumFirst(arr), IndexNegNumLast(arr)));
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
