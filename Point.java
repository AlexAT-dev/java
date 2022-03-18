import java.util.Scanner;

public class Point {
    public int x;
    public int y;

    public void Print() {
        System.out.printf("x = %d\ny = %d\n", x, y);
    }

    public void Input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть x:");
        x = in.nextInt();
        System.out.print("Введіть y:");
        y = in.nextInt();
    }
}
