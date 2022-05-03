import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Лабораторна 5. Оберіть завдання:");
            System.out.println("1 — Текстовий рядок.\n\tа) видаляє кожне друге слово;\n\tб) знищує всі слова, які починаються і закінчуються за одну й ту ж літеру. ");
            System.out.println("2 — Створити 2 файли дійсних чисел. Записати у третій файл по черзі значення цих файлів.");
            System.out.println("3 — Записати у файл найдовше слово.");
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
                case "3":
                    System.out.println("Завдання №3:");
                    Task3.Start();
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
