import java.util.Scanner;

public class Task4 {
    public static float Zero(float a, float b, float dx)
    {
        float x;
        for(x = a; x <= 0; x+=dx) {}
        return x;
    }


    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Функція: log(x) / x");

        float a = -1;
        float b = 3;
        float dx = 0.05f;

        System.out.println("x\t\t|\ty");
        System.out.println("————————————————————————————————————————————————");

        for(float x = a; x <= b; x+=dx) {
            System.out.printf("%.2f\t|\t", x);

            try {
                if(x == Zero(a,b,dx)) throw new ArithmeticException("Помилка! Діленя на 0 неможливе.");
                if(x < 0) throw new ArithmeticException("Помилка! Логарифмування числа, меншого за нуль.");

                float y = (float) (Math.log(x) / x);
                System.out.printf("%.5f\n", y);
            }
            catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
