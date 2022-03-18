import java.util.Scanner;

public class Task1 {
    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Обчислення значень функції a = (√x + 2√(xy)) / (√y - 2√(xz)");
        boolean error = true;
        do {
            try {
                System.out.print("Введіть x: ");
                int x = in.nextInt();
                if(x < 0) throw new ArithmeticException("Помилка! x не може бути меньше 0.");
                System.out.print("Введіть y: ");
                int y = in.nextInt();
                if(y < 0) throw new ArithmeticException("Помилка! y не може бути меньше 0.");
                System.out.print("Введіть z: ");
                int z = in.nextInt();
                if(y*z < 0) throw new ArithmeticException("Помилка! Для заданих значень 'y' та 'z' у обчислюваному виразі число в корені меньше 0");
                if(x*z < 0) throw new ArithmeticException("Помилка! Для заданих значень 'x' та 'z' у обчислюваному виразі число в корені меньше 0");

                float div = (float) (Math.sqrt(y) - 2 * Math.sqrt(x * z));
                if(div == 0) throw new ArithmeticException("Для заданих значень у обчислюваному виразі виконується ділення на 0");

                float a = (float) (Math.sqrt(x) + 2 * Math.sqrt(y * z)) / div;
                System.out.printf("Результат: %f\n", a);
                error = false;
            }
            catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
        } while (error);
    }
}
