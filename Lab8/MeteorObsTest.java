import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class MeteorObsTest {

    @Test
    public void getTemperature() {
        MeteorObs item = new MeteorObs(new Date(), 20, 213);

        int actual = item.getTemperature();
        int expected = 20;

        assertEquals(expected, actual);
    }

    @Test
    public void avgPressure() {
        MeteorObs item1 = new MeteorObs(new Date(), 20, 200);
        MeteorObs item2 = new MeteorObs(new Date(), 20, 600);
        MeteorObs item3 = new MeteorObs(new Date(), 20, 400);

        ArrayList<MeteorObs> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        double actual = MeteorObs.AvgPressure(list);
        double expected = 400;

        assertEquals(expected, actual, 0.0f);
    }
}