import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    public static void AddInfo()
    {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введіть кількість нових записів: ");
            n = in.nextInt();

            if(n <= 0) System.out.println("Кількість записів має бути більше 0.");
        }
        while (n <= 0);

        System.out.println("Введення книг:");
        for (int i = 0; i < n; i++)
        {
            System.out.println("Книга " + (i+1) + ":");
            Library library = new Library();
            library.Input();
            LibraryFile.WriteToFile(library);
        }
    }

    public static void EditInfo()
    {
        try {
            ArrayList<Library> libraries = LibraryFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер книги для редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= libraries.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= libraries.size());

            System.out.println("Книга:");
            Library library = new Library();
            library.Input();
            libraries.set(n, library);

            LibraryFile.RewriteFile(libraries);
            System.out.println("Книгу змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteInfo()
    {
        try {
            ArrayList<Library> libraries = LibraryFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер книги для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= libraries.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= libraries.size());

            LibraryFile.RemoveFromFile(n);
            System.out.println("Книгу видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void PrintInfo()
    {
        try {
            List<Library> libraries = LibraryFile.ReadFromFile();
            Library.PrintTable(libraries);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SearchInfo()
    {
        Scanner in = new Scanner(System.in);
        String key;
        System.out.println("Ключ пошуку: ");
        key = in.nextLine();

        try {
            List<Library> libraries = LibraryFile.Search(key);

            if(libraries.size() > 0)
            {
                Library.PrintTable(libraries);
            }
            else
            {
                System.out.println("Не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SortInfo()
    {
        try {
            List<Library> libraries = LibraryFile.Sort();

            if(libraries.size() > 0)
            {
                Library.PrintTable(libraries);
            }
            else
            {
                System.out.println("Записів не знайдено!");
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
            System.out.println("Бібліотека. Операції:");
            System.out.println("д — додати записи;");
            System.out.println("р — редагувати запис;");
            System.out.println("в — видалити запис;");
            System.out.println("т — вивести інформацію на екран;");
            System.out.println("п — пошук по автору;");
            System.out.println("с — сортувати за роками;");
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
                case "п":
                    System.out.println("Пошук: ");
                    SearchInfo();
                    break;
                case "с":
                    System.out.println("Сортувати: ");
                    SortInfo();
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
