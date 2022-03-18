import java.util.Scanner;

public class Task3 {
    public static void Start() {
        Scanner in = new Scanner(System.in);
        float sum = 0;
        int n;

        System.out.println("Задані натуральне число n та дійсне число x. Обчислити суму E(i=1 -> n)E(j=1 -> n) x+i/j");

        do {
            System.out.print("Введіть натуральне число n: ");
            n = in.nextInt();

            if(n <= 0) System.out.println("Введене число не є натуральним.");
        }
        while (n <= 0);

        System.out.print("Введіть дійсне число x: ");
        float x = in.nextFloat();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum += x+i/j;
            }
        }
        System.out.printf("Сума: %.2f\n", sum);
    }
}
