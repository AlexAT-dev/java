import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MeteorObs implements IConsolable {

    private Date date;
    private int temperature;
    private double pressure;

    public MeteorObs(){}
    public MeteorObs(Date date, int temperature, double pressure)
    {
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public Date getDate()
    {
        return date;
    }
    public int getTemperature()
    {
        return temperature;
    }
    public double getPressure()
    {
        return pressure;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }
    public void setPressure(double pressure)
    {
        this.pressure = pressure;
    }

    @Override
    public void PrintFormat()
    {
        System.out.format("%-10s | %-11s | %-20.2f",
                MeteorObsFile.DateFormatter.format(date), temperature + " °С", pressure);
        System.out.println();
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        boolean Error = true;
        do {
            try {
                System.out.print("Дата: ");
                String input = in.nextLine();
                date = MeteorObsFile.DateFormatter.parse(input);

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
                System.out.print("Температура (°С): ");
                temperature = Integer.parseInt(in.nextLine());
                if(temperature < -80 || temperature > 80) throw new Exception("Дані введенно некоректно.");

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
                System.out.print("Атмосферний тиск (мм.рт.ст): ");
                pressure = Double.parseDouble(in.nextLine());

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


    public static void PrintTable(ArrayList<MeteorObs> arr)
    {
        IConsolable.OutputTableLine();
        System.out.printf("%-10s | %-11s | %-20s", "Дата", "Температура", "Атмосф.тиск");
        System.out.println();
        IConsolable.OutputTableLine();
        for(MeteorObs item: arr) {
            item.PrintFormat();
        }
        IConsolable.OutputTableLine();
    }

    public static double AvgPressure(ArrayList<MeteorObs> arr)
    {
        double sum = 0;

        for(MeteorObs item: arr) {
            sum+=item.pressure;
        }

        return sum / arr.size();
    }

    public static void PrintTaskTable(ArrayList<MeteorObs> arr)
    {
        double avgPressure = AvgPressure(arr);
        System.out.println("Середнє значення: " + avgPressure);
        IConsolable.OutputTableLine();
        System.out.printf("%-10s | %-11s | %-20s", "Дата", "Температура", "Атмосф.тиск");
        System.out.println();
        IConsolable.OutputTableLine();
        for(MeteorObs item: arr) {
            if(item.pressure > avgPressure)
                item.PrintFormat();
        }
        IConsolable.OutputTableLine();
    }

}
