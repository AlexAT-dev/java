import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void AddInfo() {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введіть кількість нових записів: ");
            n = in.nextInt();

            if (n <= 0) System.out.println("Кількість записів має бути більше 0.");
        }
        while (n <= 0);

        System.out.println("Введення практичних завдань:");
        for (int i = 0; i < n; i++) {
            System.out.println("Практичне завдання " + (i + 1) + ":");
            Practical practical = new Practical();
            practical.Input();
            PracticalFile.WriteToFile(practical);
        }
    }

    public static void EditInfo() {
        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер практичного завдання для редагування: ");
                n = in.nextInt();

                if (n < 0 || n >= practicals.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= practicals.size());

            System.out.println("Практичне завдання:");
            Practical practical = new Practical();
            practical.Input();
            practicals.set(n, practical);

            PracticalFile.RewriteFile(practicals);
            System.out.println("Практичне завдання змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteInfo() {
        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер практичного завдання для видалення: ");
                n = in.nextInt();

                if (n < 0 || n >= practicals.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= practicals.size());

            PracticalFile.RemoveFromFile(n);
            System.out.println("Практичне завдання видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void PrintInfo() {
        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();
            Practical.PrintTable(practicals);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AVGInfo() {
        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();
            if (practicals.size() <= 0) throw new Exception("Немає записів");

            System.out.println("Середнє значення: " + Practical.AVGStudentCount(practicals));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MaxStudInfo() {
        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();
            if (practicals.size() <= 0) throw new Exception("Немає записів");

            Practical.PrintTable(Practical.MaxStudentCountList(practicals));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void TopicList() {
        Scanner in = new Scanner(System.in);
        String key;
        System.out.println("Ключ пошуку: ");
        key = in.nextLine();

        try {
            ArrayList<Practical> practicals = PracticalFile.ReadFromFile();
            if (practicals.size() <= 0) throw new Exception("Немає записів");

            System.out.println("Теми: ");
            ArrayList<String> list = Practical.TopicsListWithWord(practicals, key);
            for (String item: list)
            {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do {
            System.out.println("Практичні завдання. Операції:");
            System.out.println("д — додати записи;");
            System.out.println("р — редагувати запис;");
            System.out.println("в — видалити запис;");
            System.out.println("т — вивести інформацію на екран;");
            System.out.println();
            System.out.println("с — середня кількість студентів;");
            System.out.println("з — заняття з максимальною кількістю студентів;");
            System.out.println("п — список тем з певним словом у назві;");
            System.out.println("- — завершити");
            System.out.print("Операція: ");
            sel = in.next();
            System.out.println();

            switch (sel) {
                case "д":
                    System.out.println("Додавання: ");
                    AddInfo();
                    break;
                case "р":
                    System.out.println("Редагування: ");
                    EditInfo();
                    break;
                case "в":
                    System.out.println("Видалення: ");
                    DeleteInfo();
                    break;
                case "т":
                    System.out.println("Виведення:");
                    PrintInfo();
                    break;
                case "с":
                    System.out.println("Середня кількість студентів: ");
                    AVGInfo();
                    break;
                case "з":
                    System.out.println("Заняття з максимальною кількістю студентів: ");
                    MaxStudInfo();
                    break;
                case "п":
                    System.out.println("список тем з певним словом у назві: ");
                    TopicList();
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
