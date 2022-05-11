import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

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

        System.out.println("Введення спостережень:");
        for (int i = 0; i < n; i++)
        {
            System.out.println("Спостереження №" + (i+1) + ":");
            MeteorObs meteor = new MeteorObs();
            meteor.Input();
            MeteorObsFile.WriteToFile(meteor);
        }
    }

    private static void EditInfo()
    {
        try {
            ArrayList<MeteorObs> meteors = MeteorObsFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер спостереження для редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= meteors.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= meteors.size());

            System.out.println("Спостереження:");
            MeteorObs meteor = new MeteorObs();
            meteor.Input();
            meteors.set(n, meteor);

            MeteorObsFile.RewriteFile(meteors);
            System.out.println("Спостереження змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void DeleteInfo()
    {
        try {
            ArrayList<MeteorObs> meteors = MeteorObsFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер спостереження для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= meteors.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= meteors.size());

            MeteorObsFile.RemoveFromFile(n);
            System.out.println("Спостереження видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void PrintInfo()
    {
        try {
            ArrayList<MeteorObs> meteors = MeteorObsFile.ReadFromFile();
            MeteorObs.PrintTable(meteors);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void SortInfo()
    {
        try {
            Scanner in = new Scanner(System.in);
            MeteorObsFile.SortBy sortBy = MeteorObsFile.SortBy.DATE;

            boolean Error;
            do {
                Error = false;
                System.out.println("Оберіть поле для сортування:");
                System.out.println("1 — дата;");
                System.out.println("2 — температура;");
                System.out.println("3 — атмосферний тиск.");
                String sel = in.nextLine();

                switch (sel)
                {
                    case "1" -> sortBy = MeteorObsFile.SortBy.DATE;
                    case "2" -> sortBy = MeteorObsFile.SortBy.TEMPERATURE;
                    case "3" -> sortBy = MeteorObsFile.SortBy.PRESSURE;
                    default -> {
                        System.out.println("Дані введено некоретно. Повторіть ввід:");
                        Error = true;
                    }
                }
            } while (Error);

            ArrayList<MeteorObs> meteors = MeteorObsFile.Sort(sortBy);

            if(meteors.size() > 0)
            {
                MeteorObs.PrintTable(meteors);
            }
            else
            {
                System.out.println("Записів не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Task()
    {
        try {
            ArrayList<MeteorObs> meteors = MeteorObsFile.ReadFromFile();
            MeteorObs.PrintTaskTable(meteors);
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
            System.out.println("Метеорологічні спостереження. Операції:");
            System.out.println("д — додати записи;");
            System.out.println("р — редагувати запис;");
            System.out.println("в — видалити запис;");
            System.out.println("т — вивести інформацію на екран;");
            System.out.println("с — сортувати;");
            System.out.println("з — дні з атмосферним тиском, більшим від середнього значення;");
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
                case "с":
                    System.out.println("Сортувати: ");
                    SortInfo();
                    break;
                case "з":
                    System.out.println("Дні з атмосферним тиском, більшим від середнього значення: ");
                    Task();
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
