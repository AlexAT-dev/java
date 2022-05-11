import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class KioskHourTest {

    @Test
    public void allCustomersCount() {
        KioskHour item1 = new KioskHour("name", "address", 2, "comment");
        KioskHour item2 = new KioskHour("name", "address", 5, "comment");
        KioskHour item3 = new KioskHour("name", "address", 3, "comment");

        ArrayList<KioskHour> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        int actual = KioskHour.AllCustomersCount(list);
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    public void minCustomerCount() {
        KioskHour item1 = new KioskHour("name", "address", 2, "comment");
        KioskHour item2 = new KioskHour("name", "address", 5, "comment");
        KioskHour item3 = new KioskHour("name", "address", 3, "comment");

        ArrayList<KioskHour> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        int actual = KioskHour.MinCustomerCount(list).get(0).getCustomerCount();
        int expected = 2;

        assertEquals(expected, actual);
    }
}