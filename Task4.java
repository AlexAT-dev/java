import java.util.Scanner;

public class Task4 {
    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Обчислення значення функції √(3(y/(z-2y))-yz)");
        float t;
        System.out.print("Введіть y: ");
        int y = in.nextInt();
        System.out.print("Введіть z: ");
        int z = in.nextInt();

        try {
            if (z - 2 * y == 0) {
                throw new ArithmeticException("Помилка! При введених значеннях дільник є 0.");
            }

            float f = 3 * (y / (float)(z - 2*y)) - y*z;

            if (f < 0) {
                throw new ArithmeticException("Помилка! Корінь з від’ємного числа.");
            }

            System.out.printf("Результат: %f\n", Math.sqrt(f));
        }
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
