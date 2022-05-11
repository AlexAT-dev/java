import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PracticalTest {

    @Test
    public void AVGStudentCount() {
        Practical practical1 = new Practical("test", false, new Date(), "topic-test", 2);
        Practical practical2 = new Practical("test2", false, new Date(), "topic-test", 2);
        Practical practical3 = new Practical("test2", false, new Date(), "topic-test", 2);

        ArrayList<Practical> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);
        list.add(practical3);

        int actual = Practical.AVGStudentCount(list);
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void maxStudentCountList() {
        Practical practical1 = new Practical("test", false, new Date(), "topic-test", 12);
        Practical practical2 = new Practical("test2", false, new Date(), "topic-test", 99);

        ArrayList<Practical> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);

        int actual = Practical.MaxStudentCountList(list).get(0).getStudentsCount();
        int expected = 99;

        assertEquals(expected, actual);
    }

    @Test
    public void topicsListWithWord() {
        Practical practical1 = new Practical("test", false, new Date(), "Сортування, додавання та вилучення", 12);
        Practical practical2 = new Practical("test2", false, new Date(), "Вилучення", 99);
        Practical practical3 = new Practical("test2", false, new Date(), "Додавання та сортування", 99);

        ArrayList<Practical> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);
        list.add(practical3);

        String key = "сортування";
        String actual = Practical.TopicsListWithWord(list, key).get(0);
        String expected = "Сортування, додавання та вилучення";

        assertEquals(expected, actual);
    }
}