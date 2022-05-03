import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
public class BookTest {

    @Test
    public void getCountFromList() {
        Book book = new Book("", "", "", 0, 1);
        Book book2 = new Book("", "", "", 0, 12);
        Book book3 = new Book("", "", "", 0, 13);
        Book[] books = {book, book2, book3};
        int actual = Book.GetCountFromList(Arrays.stream(books).toList());
        int expected = -1;

        assertEquals(expected, actual);
    }
}