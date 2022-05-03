import java.util.Scanner;

public class Task1 {
    public static void ArrayOutput(String[] arr)
    {
        if(arr.length == 0) {
            System.out.println("Масив пустий");
            return;
        }

        for (String val: arr)
            System.out.println(val);
    }

    public static String[] ArrayItemAdd(String[] arr, String x)
    {
        int n = arr.length;

        String[] newArr = new String[n + 1];

        for (int i = 0; i < n; i++)
            newArr[i] = arr[i];

        newArr[n] = x;

        return newArr;
    }

    public static String[] RemoveEvery2nd(String[] arr) {
        String[] newArr = new String[0];

        for (int i = 0; i < arr.length; i++)
        {
            if((i+1) % 2 != 0)
            {
                newArr = ArrayItemAdd(newArr, arr[i]);
            }
        }
        return newArr;
    }

    public static String[] ArrayItemRemove(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }
        return newArr;
    }

    public static String[] RemoveTask2(String[] arr) {
        for (int i = 0; i < arr.length; i++)
        {
            String str = arr[i];
            char ch1 = Character.toLowerCase(str.charAt(0));
            char ch2 = Character.toLowerCase(str.charAt(str.length() - 1));
            if(ch1 == ch2)
            {
                arr = ArrayItemRemove(arr, i);
                i--;
            }
        }
        return arr;
    }


    public static void Start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть рядок:");

        String line;
        String[] words = new String[0];

        boolean Error = true;
        do {
            try {
                line = in.nextLine();
                if(line.length() <= 0) throw new Exception("Помилка: Пустий рядок.");

                words = line.split(" ");
                if(words.length <= 0) throw new Exception("Помилка: В рядку немає слів.");
                if(words.length == 1) throw new Exception("Введіть хочаб 2 слова.");

                Error = false;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (Error);

        String sel;
        do
        {
            System.out.println("Слова:");
            ArrayOutput(words);

            System.out.println("Дії з словами:");
            System.out.println("а) видаляє кожне друге слово;");
            System.out.println("б) знищує всі слова, які починаються і закінчуються за одну й ту ж літеру.");
            System.out.println("- — завершити завдання");
            System.out.print("Введіть букву завдання: ");
            sel = in.nextLine();
            System.out.println();

            switch (sel)
            {
                case "а":
                    System.out.println("Видаленння кожного другого слова:");
                    ArrayOutput(RemoveEvery2nd(words));

                    System.out.println("Продовжити? +/-");
                    sel = in.nextLine();
                    break;
                case "б":
                    System.out.println("Видаленння cлів, які починаються і закінчуються за одну й ту ж літеру:");
                    ArrayOutput(RemoveTask2(words));

                    System.out.println("Продовжити? +/-");
                    sel = in.nextLine();
                    break;
                case "-":
                    break;
                default:
                    System.out.println("Даного завдання не існує!");
                    break;
            }
            System.out.println();
        } while (!sel.equals("-"));
    }
}
