import java.util.Scanner;

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    Triangle()
    {
        p1 = new Point();
        p2 = new Point();
        p3 = new Point();
    }

    public void Print() {
        System.out.println("Трикутник:");
        System.out.println("Точка 1:");
        p1.Print();
        System.out.println("Точка 2:");
        p2.Print();
        System.out.println("Точка 3:");
        p3.Print();
    }

    public void Input() {
        Scanner in = new Scanner(System.in);

        float S;

        do {
            System.out.println("Введення точки 1:");
            p1.Input();
            System.out.println("Введення точки 2:");
            p2.Input();
            System.out.println("Введення точки 3:");
            p3.Input();

            S = CountArea();
            if(S == 0) System.out.println("Неможливо побудувати трикутник за введеними точками. Спробуйте ще раз!");
        } while (S == 0);


    }

    public float GetA() {
        return (float)(Math.sqrt(Math.pow(p1.y - p3.y, 2) + Math.pow(p1.x - p3.x, 2)));
    }

    public float GetB() {
        return (float)(Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2)));
    }

    public float GetC() {
        return (float)(Math.sqrt(Math.pow(p3.y - p2.y, 2) + Math.pow(p3.x - p2.x, 2)));
    }

    public float CountArea() {
        float a = GetA();
        float b = GetB();
        float c = GetC();
        float p = (a + b + c) / 2.f;
        return (float)(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
