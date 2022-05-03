
public class Task2 {

    public static int ArraySumNegIndex(int[] arr) throws Exception {
        int n = arr.length;
        if(n == 0) throw new Exception("Масив пустий");
        if(n == 1) throw new Exception("Масив не містить елементів з непарним індексом(лише 1 елемент з індексом 0)");
        if(n < 4) throw new Exception("Масив містить лише один елемент з непарним індексом");

        int sum = 0;
        for (int i = 1; i < n; i+=2) {
            sum+=arr[i];
        }

        return sum;
    }

    public static void Start() {
        int[] arr = ArrayFn.ArrayCreate();

        ArrayFn.ArrayRandom(arr);
        System.out.println("Масив: ");
        ArrayFn.ArrayOutput(arr);

        try
        {
            System.out.println("Сума елементів масиву з непарними індексами: " + ArraySumNegIndex(arr));
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
