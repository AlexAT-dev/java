import org.junit.Test;
import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void arraySumNegIndex() {
        int[] arr = new int[]{5, 3, 8, -2, 3, 3};
        //int[] arr = new int[]{-15};
        //int[] arr = new int[]{-15, 51};

        try
        {
            int actual = Task2.ArraySumNegIndex(arr);
            int expected = 4;

            assertEquals(expected, actual);

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}