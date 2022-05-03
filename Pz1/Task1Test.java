import org.junit.Test;
import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void IndexMinAbsElement() {
        int[] arr = new int[]{-12, -10, 5, 2, 3, 20, 21, -1};
        int actual = arr[Task1.IndexMinAbsElement(arr)];
        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    public void indexPosNumFirst() {
        int[] arr = new int[]{-12, -10, 5, 2, 3, 20, 21};
        int actual = arr[Task1.IndexPosNumFirst(arr)];
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void indexPosNumLast() {
        int[] arr = new int[]{-12, -10, 5, 2, 3, 20, 21};
        int actual = arr[Task1.IndexPosNumLast(arr)];
        int expected = 21;

        assertEquals(expected, actual);
    }

    @Test
    public void arraySumBetween() {
        //int[] arr = new int[]{-12, -10, 5, 2, 3, 20, 21};
        int[] arr = new int[]{-12, -10, 5, -2, -3, -20, -21};
        try
        {
            int actual = Task1.ArraySumBetween(arr, Task1.IndexPosNumFirst(arr), Task1.IndexPosNumLast(arr));

            int expected = 25;

            assertEquals(expected, actual);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}