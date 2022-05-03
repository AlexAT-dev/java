import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Task3 {
    public static String ReadStrFromFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static void WriteStrToFile(String fileName, String text) throws Exception {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                bufferedWriter.write(text + " ");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static String LongerWord(String[] words)
    {
        int max_i = 0;
        for(int i = 1; i < words.length; i++)
        {
            if(words[max_i].length() < words[i].length())
            {
                max_i = i;
            }
        }
        return words[max_i];
    }


    public static void Start() {
        String line = new String();
        try
        {
            line = ReadStrFromFile("input.txt");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

        try
        {
            String[] words = line.split(" ");
            WriteStrToFile("output.txt", LongerWord(words));
            System.out.println("Файл створенно. Результат записано у файл.");
        }
        catch (Exception e)
        {
            System.out.println("Файл пустий");
            return;
        }
    }
}
