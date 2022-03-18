import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Лабораторна 1. Оберіть завдання:");
            System.out.println("1 — обчислення значень функції (if...if/if...else)");
            System.out.println("2 — порівняння трикутників (if...else)");
            System.out.println("3 — пошук кімнати в будинку (switch...case)");
            System.out.println("4 — обчислення значень функції (try...catch)");
            System.out.println("- — завершити програму");
            System.out.print("Введіть номер завдання: ");
            sel = in.next();

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
                case "3":
                    System.out.println("Завдання №3:");
                    Task3.Start();
                    break;
                case "4":
                    System.out.println("Завдання №4:");
                    Task4.Start();
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
