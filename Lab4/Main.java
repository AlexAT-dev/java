import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Лабораторна 4. Оберіть завдання:");
            System.out.println("1 — Квадратна матриця.\n\tвивід діагоналей;\n\tелементи вище головної діагоналі, збільшені в 2 рази.\n");
            System.out.println("2 — Матриця.\n\tЗнайти мінімальний елемент матриці, який не входить до складу елементів вектора.\n");
            System.out.println("- — завершити програму");
            System.out.print("Введіть номер завдання: ");
            sel = in.nextLine();
            System.out.println();

            switch (sel)
            {
                case "1":
                    System.out.println("Завдання №1:");
                    Task1.Start();
                    break;
                case "2":
                    System.out.println("Завдання №2:");
                    Task2.Start();
                    break;
                case "-":
                    return;
                default:
                    System.out.println("Даного завдання не існує!");
                    break;
            }
            System.out.println();
        } while (true);
    }
}
