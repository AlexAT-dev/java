import java.util.Scanner;

public class Task2 {
    public static int UseFor(int x) {
        int sum = 0;
        for(int i = 10; i <= 100; i++) {
            if(i % 2 == 0 && i > x)
                sum+=i;
        }
        return sum;
    }

    public static int UseWhile(int x) {
        int sum = 0;
        int i = 10;
        while(i <= 100) {
            if(i % 2 == 0 && i > x)
                sum+=i;
            i++;
        }
        return sum;
    }

    public static int UseDoWhile(int x) {
        int sum = 0;
        int i = 10;
        do {
            if(i % 2 == 0 && i > x)
                sum+=i;
            i++;
        } while(i <= 100);
        return sum;
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Сума всіх парних чисел у діапазоні [10;100], які є більшими за x");
        System.out.print("Введіть x: ");
        int x = in.nextInt();
        System.out.println("Сума:");
        System.out.printf("\tfor       \t%d\n", UseFor(x));
        System.out.printf("\twhile     \t%d\n", UseWhile(x));
        System.out.printf("\tdo...while\t%d\n", UseDoWhile(x));
    }
}
