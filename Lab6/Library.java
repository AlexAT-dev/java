import java.util.*;

public class Library {
    private int num;
	private String name;
    private String author;
    private int year;
    private int count;

    private static final String TableLine = "———————————————————————————————————————————————————————————————————————————————————————————————————————————————";
    //private static final String TableLineGroup = "---------------------------------------------------------------------------------------------------------------";

    private static void OutputTableLine()
    {
        System.out.println(TableLine);
    }

    public Library() {}
    public Library(int num, String name, String author, int year, int count)
    {
		this.num = num;
        this.name = name;
        this.author = author;
        this.year = year;
        this.count = count;
    }

    public int getNum()
    {
        return num;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getYear()
    {
        return year;
    }

    public int getCount()
    {
        return count;
    }


    public void setNum(int num)
    {
        this.num = num;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setCount(int count)
    {
        this.count = count;
    }


    public void Input()
    {
        Scanner in = new Scanner(System.in);

        boolean Error = true;
        do {
            try {
                System.out.print("Інвентарний номер: ");
                num = Integer.parseInt(in.nextLine());
                if(num < 1) throw new Exception("Номер повиний бути 1 або більше!");

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

        System.out.print("Назва книги: ");
        name = in.nextLine();
        System.out.print("Автор: ");
        author = in.nextLine();

        Error = true;
        do {
            try {
                System.out.print("Рік: ");
                year = Integer.parseInt(in.nextLine());
                if(year < 1200) throw new Exception("Введіть рік корректно!");

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

    public void PrintFormat(int i)
    {
            System.out.format("%-4s | %-15s | %-40s | %-30s | %-4d | %-10d",
                    i, num, name, author, year, count);
            System.out.println();
    }

    public static void PrintTable(List<Library> arr)
    {
        OutputTableLine();
        System.out.printf("%-4s | %-15s | %-40s | %-30s | %-4s | %-10s", "№", "Інв.номер", "Назва книги", "Автор", "Рік", "К-ть стр");
        System.out.println();
        OutputTableLine();
        int i = 0;
        for(Library item: arr) {
            item.PrintFormat(i++);
        }
        OutputTableLine();
    }
}
