import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class KioskHour extends Kiosk{
    private int customerCount;
    private String comment;

    public int getCustomerCount() {
        return customerCount;
    }

    public String getComment() {
        return comment;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public KioskHour(){}
    public KioskHour(String name, String address, int customerCount, String comment)
    {
        this.name = name;
        this.address = address;
        this.customerCount = customerCount;
        this.comment = comment;
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Назва: ");
        name = in.nextLine();

        System.out.print("Адреса: ");
        address = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Кількість клієнтів: ");
                customerCount = Integer.parseInt(in.nextLine());
                if(customerCount < 1 ) throw new Exception("Дані введенно некоректно.");

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

        System.out.print("Коментар: ");
        comment = in.nextLine();
    }

    @Override
    public void PrintFormat()
    {
        System.out.format("%-15s | %-20s | %-15d | %-20s",
                name, address, customerCount, comment);
        System.out.println();
    }

    public static void PrintTable(ArrayList<KioskHour> arr)
    {
        IConsolable.OutputTableLine();
        System.out.printf("%-15s | %-20s | %-15s | %-20s", "Назва", "Адреса", "К-ть клієнтів", "Коментар");
        System.out.println();
        IConsolable.OutputTableLine();
        for(KioskHour item: arr) {
            item.PrintFormat();
        }
        IConsolable.OutputTableLine();
    }

    public static int AllCustomersCount(ArrayList<KioskHour> arr)
    {
        int count = 0;

        for(KioskHour item: arr) {
            count+=item.customerCount;
        }

        return count;
    }

    public static ArrayList<KioskHour> MinCustomerCount(ArrayList<KioskHour> arr)
    {
        int min = arr.get(0).customerCount;

        for(KioskHour kiosk: arr)
        {
            if(min > kiosk.customerCount)
                min = kiosk.customerCount;
        }

        ArrayList<KioskHour> newArr = new ArrayList<>();

        for(KioskHour kiosk: arr)
        {
            if(kiosk.customerCount == min)
                newArr.add(kiosk);
        }

        return newArr;
    }

    public static ArrayList<KioskHour> Search(ArrayList<KioskHour> arr, String[] keys) {
        ArrayList<KioskHour> kiosks = new ArrayList<>();

        for(KioskHour item: arr) {
            for(String key: keys) {
                if(item.getComment().toLowerCase(Locale.ROOT).contains(key.toLowerCase(Locale.ROOT)))
                {
                    kiosks.add(item);
                    break;
                }
            }
        }
        return kiosks;
    }
}
