import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Лабораторна 2. Оберіть завдання:");
            System.out.println("1 — обчислення значень функції (передбачення вхідних параметрів)");
            System.out.println("2 — обчислити суму всіх парних чисел у діапазоні [10;100], які є більшими за деяке ціле число x.");
            System.out.println("3 — обчислити суму");
            System.out.println("4 — таблиця результату обчислення функції");
            System.out.println("- — завершити програму");
            System.out.print("Введіть номер завдання: ");
            sel = in.next();

            //Console.Clear();
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
