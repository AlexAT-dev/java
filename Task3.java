import java.util.Scanner;

public class Task3 {
    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть номер квартири: ");
        int n = in.nextInt();

        switch (n)
        {
            case 1, 2, 3, 4, 5:
                System.out.printf("Кімната №%d знаходиться на першому поверсі.", n);
                break;
            case 6, 7, 8, 9, 10:
                System.out.printf("Кімната №%d знаходиться на другому поверсі.", n);
                break;
            case 11, 12, 13, 14, 15:
                System.out.printf("Кімната №%d знаходиться на третьому поверсі.", n);
                break;
            case 16, 17, 18, 19, 20:
                System.out.printf("Кімната №%d знаходиться на четвертому поверсі.", n);
                break;
            case 21, 22, 23, 24, 25:
                System.out.printf("Кімната №%d знаходиться на п'ятому поверсі.", n);
                break;
            case 26, 27, 28, 29, 30:
                System.out.printf("Кімната №%d знаходиться на шостому поверсі.", n);
                break;
            case 31, 32, 33, 34, 35:
                System.out.printf("Кімната №%d знаходиться на сьомому поверсі.", n);
                break;
            case 36, 37, 38, 39, 40:
                System.out.printf("Кімната №%d знаходиться на восьмому поверсі.", n);
                break;
            case 41, 42, 43, 44, 45:
                System.out.printf("Кімната №%d знаходиться на дев'ятому поверсі.", n);
                break;
            default:
                System.out.printf("Кімнати №%d немає в даному будинку.", n);
                break;
        }
        System.out.println();
    }
}
