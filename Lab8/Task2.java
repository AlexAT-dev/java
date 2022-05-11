import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    private static void AddInfo()
    {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введіть кількість нових записів: ");
            n = in.nextInt();

            if(n <= 0) System.out.println("Кількість записів має бути більше 0.");
        }
        while (n <= 0);

        System.out.println("Введення запису:");
        for (int i = 0; i < n; i++)
        {
            System.out.println("Запис " + (i+1) + ":");
            KioskHour kiosk = new KioskHour();
            kiosk.Input();
            KioskHourFile.WriteToFile(kiosk);
        }
    }

    private static void EditInfo()
    {
        try {
            ArrayList<KioskHour> kiosks = KioskHourFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер запису для редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= kiosks.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= kiosks.size());

            System.out.println("Запис:");
            KioskHour kiosk = new KioskHour();
            kiosk.Input();
            kiosks.set(n, kiosk);

            KioskHourFile.RewriteFile(kiosks);
            System.out.println("Запис змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void DeleteInfo()
    {
        try {
            ArrayList<KioskHour> kiosks = KioskHourFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер запису для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= kiosks.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= kiosks.size());

            KioskHourFile.RemoveFromFile(n);
            System.out.println("Запис видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void PrintInfo()
    {
        try {
            ArrayList<KioskHour> kiosks = KioskHourFile.ReadFromFile();
            KioskHour.PrintTable(kiosks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void CountAllCustomers()
    {
        try {
            ArrayList<KioskHour> kiosks = KioskHourFile.ReadFromFile();
            System.out.println(KioskHour.AllCustomersCount(kiosks));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void LowerCustomers()
    {
        try {
            ArrayList<KioskHour> search = KioskHour.MinCustomerCount(KioskHourFile.ReadFromFile());

            if(search.size() > 0)
            {
                KioskHour.PrintTable(search);
            }
            else
            {
                System.out.println("Не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void SearchComment()
    {
        Scanner in = new Scanner(System.in);
        String key;
        System.out.println("Ключі пошуку: ");
        key = in.nextLine();
        String[] keys = key.split(" ");

        try {
            ArrayList<KioskHour> search = KioskHour.Search(KioskHourFile.ReadFromFile(), keys);

            if(search.size() > 0)
            {
                KioskHour.PrintTable(search);
            }
            else
            {
                System.out.println("Не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Start()
    {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Цілодобовий кіоск. Операції:");
            System.out.println("д — додати записи;");
            System.out.println("р — редагувати запис;");
            System.out.println("в — видалити запис;");
            System.out.println("т — вивести інформацію на екран;");
            System.out.println("з — загальна кількість покупців;");
            System.out.println("н — година з найменшою кількістю покупців;");
            System.out.println("к — коментарі з певними словами;");
            System.out.println("- — завершити");
            System.out.print("Операція: ");
            sel = in.next();
            System.out.println();

            switch (sel)
            {
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
                case "з":
                    System.out.println("Загальна кількість покупців: ");
                    CountAllCustomers();
                    break;
                case "н":
                    System.out.println("Година з найменшою кількістю покупців: ");
                    LowerCustomers();
                    break;
                case "к":
                    System.out.println("Коментарі з певними словами: ");
                    SearchComment();
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