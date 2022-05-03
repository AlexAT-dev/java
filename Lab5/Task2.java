import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Task2 {

    public static void WriteToFile(String fileName) {
        Scanner in = new Scanner(System.in);
        boolean Error = true;
        int size = 0;

        do {
            try {
                System.out.print("Введіть кількість елементів:");
                size = Integer.parseInt(in.next());
                if(size < 1) throw new Exception("Кількість елементів має бути більше за 0!");

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Елменти:");
            for (int i = 0; i < size; i++)
            {
                Error = true;
                float info = 0;

                do {
                    try {
                        info = Float.parseFloat(in.next());
                        Error = false;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Помилка при введені. Невірний тип. Спробуйте ще раз!");
                    }
                } while (Error);

                writer.write(Float.toString(info) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Create3FileFrom1and2(String fileName3, String fileName1, String fileName2) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName3))) {
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            while(line1 != null || line2 != null) {
                if(line1 != null)
                {
                    writer.write(line1);
                    writer.write("\n");
                    line1 = reader1.readLine();
                }

                if(line2 != null)
                {
                    writer.write(line2);
                    writer.write("\n");
                    line2 = reader2.readLine();
                }
            }

            reader1.close();
            reader2.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Start() {
        System.out.println("Введення файлу 1:");
        WriteToFile("file1.txt");

        System.out.println("Введення файлу 2:");
        WriteToFile("file2.txt");

        Create3FileFrom1and2("file3.txt", "file1.txt", "file2.txt");
        System.out.println("Створено файл 3.");
    }
}
