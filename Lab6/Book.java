import java.util.*;

public class Book {
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int count;

    private static final String TableLine = "———————————————————————————————————————————————————————————————————————————————————————————————————————————————";
    private static final String TableLineGroup = "---------------------------------------------------------------------------------------------------------------";

    private static void OutputTableLine()
    {
        System.out.println(TableLine);
    }

    public Book() {}
    public Book(String name, String author, String publishing, int year, int count)
    {
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.count = count;
    }

    public void Input()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Назва книги: ");
        name = in.nextLine();
        System.out.print("Автор: ");
        author = in.nextLine();
        System.out.print("Видавництво: ");
        publishing = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Рік: ");
                year = Integer.parseInt(in.nextLine());
                if(year < 1000) throw new Exception("Введіть рік корректно!");

                Error = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Помилка при введені. Невірний тип. Спробуйте ще раз!");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);

        Error = true;
        do {
            try {
                System.out.print("Кількість: ");
                count = Integer.parseInt(in.nextLine());
                if(count < 1) throw new Exception("Введіть кількість корректно!");

                Error = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Помилка при введені. Невірний тип. Спробуйте ще раз!");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);
    }

    public void PrintFormat()
    {
            System.out.format("%-40s | %-30s | %-15s | %-4d | %-10d",
                    name, author, publishing, year, count);
            System.out.println();
    }

    public static void PrintTable(Book[] arr)
    {
        OutputTableLine();
        System.out.printf("%-40s | %-30s | %-15s | %-4s | %-10s", "Назва книги", "Автор", "Видавництво", "Рік", "Кількість");
        System.out.println();
        OutputTableLine();
        for(Book item: arr) {
            item.PrintFormat();
        }
        OutputTableLine();
    }

    public static void PrintTableGroupByYear(Book[] arr)
    {
        Map<Integer, List<Book>> map = new HashMap();
        for(Book item: arr) {
            if (!map.containsKey(item.year)) {
                map.put(item.year, new ArrayList());
            }
            map.get(item.year).add(item);
        }

        OutputTableLine();
        System.out.printf("%-40s | %-30s | %-15s | %-4s | %-10s", "Назва книги", "Автор", "Видавництво", "Рік", "Кількість");
        System.out.println();
        OutputTableLine();
        for (Map.Entry<Integer, List<Book>> entry : map.entrySet()) {
            System.out.println("Рік "+ entry.getKey() + ":");
            System.out.println(TableLineGroup);
            int year_count = GetCountFromList(entry.getValue());
            System.out.println(TableLineGroup);
            System.out.printf("%110s", "Загальна К-ть: " + year_count + "\n");
            OutputTableLine();
        }
        //System.out.println("------------------------------------------------------------------------");
    }

    public static int GetCountFromList(List<Book> list)
    {
        int year_count = 0;
        for(Book item: list) {
            item.PrintFormat();
            year_count+= item.count;
        }

        return year_count;
    }
}
