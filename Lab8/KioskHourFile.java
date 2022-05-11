import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KioskHourFile {

    private static final String fileName = "Kiosk.txt";

    private static void WriteToFile(BufferedWriter bufferedWriter, KioskHour kiosk) throws IOException {
        bufferedWriter.write("Година:" + "\n");
        bufferedWriter.write(kiosk.getName() + "\n");
        bufferedWriter.write(kiosk.getAddress() + "\n");
        bufferedWriter.write(kiosk.getCustomerCount() + "\n");
        bufferedWriter.write(kiosk.getComment() + "\n");
    }

    public static void WriteToFileList(ArrayList<KioskHour> kiosks, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (KioskHour kiosk: kiosks)
            {
                WriteToFile(bufferedWriter, kiosk);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(KioskHour kiosk, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            WriteToFile(bufferedWriter, kiosk);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(KioskHour kiosk)
    {
        WriteToFile(kiosk, true);
    }

    public static void RewriteFile(ArrayList<KioskHour> kiosks) {
        WriteToFileList(kiosks, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<KioskHour> kiosks = ReadFromFile();

        kiosks.remove(index);
        RewriteFile(kiosks);
    }

    public static ArrayList<KioskHour> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<KioskHour> kiosks = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                KioskHour kiosk = new KioskHour();

                line = bufferedReader.readLine();
                kiosk.setName(line);

                line = bufferedReader.readLine();
                kiosk.setAddress(line);

                line = bufferedReader.readLine();
                kiosk.setCustomerCount(Integer.parseInt(line));

                line = bufferedReader.readLine();
                kiosk.setComment(line);

                kiosks.add(kiosk);

                line = bufferedReader.readLine();
            }
            return kiosks;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (NumberFormatException e) {
            throw new Exception("Дані введено некоректно!");
        }
        catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }
}

