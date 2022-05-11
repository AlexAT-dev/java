import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Practical extends EdCourse{
    private Date date;
    private String topic;
    private int studentsCount;

    private static final String TableLine = "—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————";

    public Practical(){}
    public Practical(String name, boolean hasExam, Date date, String topic,int studentsCount)
    {
        this.name = name;
        this.hasExam = hasExam;
        this.date = date;
        this.topic = topic;
        this.studentsCount = studentsCount;
    }


    private static void OutputTableLine()
    {
        System.out.println(TableLine);
    }

    public Date getDate()
    {
        return date;
    }

    public String getTopic()
    {
        return topic;
    }

    public int getStudentsCount()
    {
        return studentsCount;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public void setStudentsCount(int studentsCount)
    {
        this.studentsCount = studentsCount;
    }

    @Override
    public void PrintFormat()
    {
        System.out.format("%-30s | %-7s | %-10s | %-80s | %-4d",
                name, hasExam ? "+" : "-", PracticalFile.DateFormatter.format(date), topic, studentsCount);
        System.out.println();
    }

    public static void PrintTable(ArrayList<Practical> arr)
    {
        OutputTableLine();
        System.out.printf("%-30s | %-7s | %-10s | %-80s | %-4s", "Назва", "Екзамен", "Дата", "Тема", "К-ть студ.");
        System.out.println();
        OutputTableLine();
        for(Practical item: arr) {
            item.PrintFormat();
        }
        OutputTableLine();
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Назва: ");
        name = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Наявність екзамену: ");
                String input = in.nextLine();
                if(!(input.equals("+") || input.equals("-"))) throw new Exception("Введіть + або -");

                Error = false;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);

        Error = true;
        do {
            try {
                System.out.print("Дата: ");
                String input = in.nextLine();
                date = PracticalFile.DateFormatter.parse(input);

                Error = false;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);


        System.out.print("Тема: ");
        topic = in.nextLine();



        Error = true;
        do {
            try {
                System.out.print("Кількість студентів: ");
                studentsCount = Integer.parseInt(in.nextLine());
                if(studentsCount <= 1) throw new Exception("Кількість студентів повинна бути більша за 1");

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



    public static int AVGStudentCount(ArrayList<Practical> arr)
    {
        int stud_count = 0;

        for(Practical practical: arr)
        {
            stud_count+=practical.getStudentsCount();
        }

        return stud_count / arr.size();
    }

    public static ArrayList<Practical> MaxStudentCountList(ArrayList<Practical> arr)
    {
        int max = arr.get(0).studentsCount;

        for(Practical practical: arr)
        {
            if(max < practical.studentsCount)
                max = practical.studentsCount;
        }

        ArrayList<Practical> newArr = new ArrayList<>();

        for(Practical practical: arr)
        {
            if(practical.studentsCount == max)
                newArr.add(practical);
        }

        return newArr;
    }

    public static ArrayList<String> TopicsListWithWord(ArrayList<Practical> arr, String key)
    {
        ArrayList<String> list = new ArrayList<>();

        for(Practical practical: arr)
        {
            if(practical.getTopic().toLowerCase(Locale.ROOT).contains(key.toLowerCase(Locale.ROOT)))
                list.add(practical.getTopic());
        }

        return list;
    }
}
