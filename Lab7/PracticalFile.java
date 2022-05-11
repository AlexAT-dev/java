import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PracticalFile {
    private static final String fileName = "Practical.txt";
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    private static void WriteToFile(BufferedWriter bufferedWriter, Practical Practical) throws IOException {
        bufferedWriter.write("Практичне завдання:" + "\n");
        bufferedWriter.write(Practical.getName() + "\n");
        bufferedWriter.write(Practical.getHasExam() + "\n");
        bufferedWriter.write(DateFormatter.format(Practical.getDate())+ "\n");
        bufferedWriter.write(Practical.getTopic() + "\n");
        bufferedWriter.write(Practical.getStudentsCount() + "\n");
    }

    public static void WriteToFileList(ArrayList<Practical> Practicals, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (Practical Practical: Practicals)
            {
                WriteToFile(bufferedWriter, Practical);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(Practical Practical, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            WriteToFile(bufferedWriter, Practical);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(Practical Practical)
    {
        WriteToFile(Practical, true);
    }

    public static void RewriteFile(ArrayList<Practical> practicals) {
        WriteToFileList(practicals, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<Practical> practicals = ReadFromFile();

        practicals.remove(index);
        RewriteFile(practicals);
    }

    public static ArrayList<Practical> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Practical> practicals = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                Practical Practical = new Practical();

                line = bufferedReader.readLine();
                Practical.setName(line);

                line = bufferedReader.readLine();
                Practical.setHasExam(Boolean.parseBoolean(line));

                line = bufferedReader.readLine();
                Practical.setDate(DateFormatter.parse(line));

                line = bufferedReader.readLine();
                Practical.setTopic(line);

                line = bufferedReader.readLine();
                Practical.setStudentsCount(Integer.parseInt(line));

                practicals.add(Practical);

                line = bufferedReader.readLine();
            }
            return practicals;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static ArrayList<Practical> Sort() throws Exception {
        ArrayList<Practical> list;
        list = ReadFromFile();
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getStudentsCount() < list.get(i + 1).getStudentsCount()) {
                    Practical temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        return list;
    }

    public static ArrayList<Practical> Search(String key) throws Exception {
        ArrayList<Practical> read = ReadFromFile();
        ArrayList<Practical> practicals = new ArrayList<>();

        for(Practical item: read) {
            if(item.getName().contains(key))
            {
                practicals.add(item);
            }
        }
        return practicals;
    }
}
