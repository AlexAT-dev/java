import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MeteorObsFile {
    public enum SortBy
    {
        DATE,
        TEMPERATURE,
        PRESSURE
    }

    private static final String fileName = "MeteorObs.txt";
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    private static void WriteToFile(BufferedWriter bufferedWriter, MeteorObs meteor) throws IOException {
        bufferedWriter.write("Метеорологічне спостереження:" + "\n");
        bufferedWriter.write(DateFormatter.format(meteor.getDate())+ "\n");
        bufferedWriter.write(meteor.getTemperature() + "\n");
        bufferedWriter.write(meteor.getPressure() + "\n");
    }

    public static void WriteToFileList(ArrayList<MeteorObs> meteors, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (MeteorObs meteor: meteors)
            {
                WriteToFile(bufferedWriter, meteor);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(MeteorObs meteor, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            WriteToFile(bufferedWriter, meteor);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(MeteorObs meteor)
    {
        WriteToFile(meteor, true);
    }

    public static void RewriteFile(ArrayList<MeteorObs> meteors) {
        WriteToFileList(meteors, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<MeteorObs> meteors = ReadFromFile();

        meteors.remove(index);
        RewriteFile(meteors);
    }

    public static ArrayList<MeteorObs> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<MeteorObs> meteors = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                MeteorObs meteor = new MeteorObs();

                line = bufferedReader.readLine();
                meteor.setDate(DateFormatter.parse(line));

                line = bufferedReader.readLine();
                meteor.setTemperature(Integer.parseInt(line));

                line = bufferedReader.readLine();
                meteor.setPressure(Double.parseDouble(line));

                meteors.add(meteor);

                line = bufferedReader.readLine();
            }
            return meteors;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (NumberFormatException e) {
            throw new Exception("Дані введено некоректно!");
        }
        catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static ArrayList<MeteorObs> Sort(SortBy sortBy) throws Exception {
        ArrayList<MeteorObs> list;
        list = ReadFromFile();
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {

                boolean result = false;

                switch (sortBy)
                {
                    case DATE -> result = (list.get(i).getDate().compareTo(list.get(i + 1).getDate()) > 0);
                    case TEMPERATURE -> result = (list.get(i).getTemperature() < list.get(i + 1).getTemperature());
                    case PRESSURE -> result = (list.get(i).getPressure() < list.get(i + 1).getPressure());
                }

                if (result) {
                    MeteorObs temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        return list;
    }
}

