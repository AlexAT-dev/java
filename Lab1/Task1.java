import java.util.Scanner;

public class Task1 {
    public static void Start() {
        Scanner in = new Scanner(System.in);
        float y = 0;

        System.out.println("Введення x для обчисленя формул...");
        System.out.println("\tx>0 \tx^2 + 5x - 6");
        System.out.println("\tx<=0\t|x+cos(x)|");
        System.out.print("Введіть x: ");
        float x = in.nextFloat();

        if (x > 0)
        {
            y = (float)(Math.pow(x, 2) + 5 * x - 6);
        }
        if (x <= 0)
        {
            y = (float)(Math.abs(x + Math.cos(x)));
        }
        System.out.println("if...if");
        System.out.printf("Результат: %f\n", y);

        if (x > 0)
        {
            y = (float)(Math.pow(x, 2) + 5 * x - 6);
        }
        else
        {
            y = (float)(Math.abs(x + Math.cos(x)));
        }
        System.out.println("if...else");
        System.out.printf("Результат: %f\n", y);
    }
}
