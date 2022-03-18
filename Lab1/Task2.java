import java.util.Scanner;

public class Task2 {

    public static void Start() {
        Scanner in = new Scanner(System.in);

        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle();

        System.out.println("Введення трикутників:");
        System.out.println("Трикутник 1:");
        triangle1.Input();
        System.out.println("Трикутник 2:");
        triangle2.Input();

        float S1 = triangle1.CountArea();
        float S2 = triangle2.CountArea();
        System.out.printf("Площа трикутника 1 = %.2f\n", S1);
        System.out.printf("Площа трикутника 2 = %.2f\n", S2);

        if (S1 > S2) {
            System.out.println("Площа трикутника 1 більша за 2.");
        }
        else if (S1 < S2) {
            System.out.println("Площа трикутника 2 більша за 1.");
        }
        else {
            System.out.println("Площі трикутників рівні.");
        }
    }
}
