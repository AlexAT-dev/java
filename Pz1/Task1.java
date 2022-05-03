public class Task1 {
    public static int IndexMinAbsElement(int[] arr)
    {
        int min_i = 0;
        for (int i = 0; i < arr.length; i++) {
            if(Math.abs(arr[i]) < Math.abs(arr[min_i]))
                min_i = i;
        }
        return min_i;
    }

    public static int IndexPosNumFirst(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) return i;
        }
        return -1;
    }

    public static int IndexPosNumLast(int[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] >= 0) return i;
        }
        return -1;
    }

    public static int ArraySumBetween(int[] arr, int first, int last) throws Exception {
        if(first == -1 || last == -1) throw new Exception("Немає додатніх елементів!");
        else if(first == last ) throw new Exception("В масиві лише один додатній елемент!");
        else if(first == last-1 ) throw new Exception("Між першим і останнім додатними елементами немає елементів!");

        int sum = 0;
        for (int i = first+1; i < last; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static void Start() {
        int[] arr = ArrayFn.ArrayCreate();

        ArrayFn.ArrayRandom(arr);
        System.out.println("Масив: ");
        ArrayFn.ArrayOutput(arr);

        int min_i = IndexMinAbsElement(arr);
        System.out.println("Номер мінімального за модулем елемента масиву: " + min_i + ". Елемент: " + arr[min_i]);

        try
        {
            System.out.println("Сума елементів масиву, розташованих між першим й останнім додатними елементами: " +
                    ArraySumBetween(arr, IndexPosNumFirst(arr), IndexPosNumLast(arr)));
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }


}
