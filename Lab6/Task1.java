import java.util.Scanner;

public class Task1 {

    public static Book[] AutoPutInfo()
    {
        Book book1 = new Book("Роздуми за філіжанкою кави", "Альохіна Ольга", "Колесо життя", 2019, 191);
        Book book2 = new Book("Казка про Добромола", "Олександр Турчинов", "Дніпро", 2020, 132);
        Book book3 = new Book("Книга мудрості", "Григорій Латник", "Арій", 2016, 172);
        Book book4 = new Book("Алгебра 9 клас", "Мерзляк А. Г.", "Гімназія", 2017, 163);
        Book book5 = new Book("Інформатика рівень стандарту 10-11 клас", "Ривкінд Й. Я.", "Генеза", 2018, 171);
        Book book6 = new Book("Літо довжиною в ДНК", "Штефан Аліна", "Ранок", 2018, 212);
        Book book7 = new Book("Англійський детектив. Дама зникає", "Етель Ліна Вайт", "Жорж", 2019, 101);
        Book book8 = new Book("Чекай удома, коли повернуся", "Ельчін Сафарлі", "Book Chef", 2017, 82);
        Book book9 = new Book("Фізика. Основи і механічний рух", "Павло Віктор", "Book Chef", 2020, 121);
        Book book10 = new Book("Зламати ДНК.", "Дженніфер Дудна", "Наш Формат", 2018, 172);

        return new Book[] {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10};
    }

    public static Book[] InputInfo()
    {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть кількість записів: ");
            n = in.nextInt();

            if(n <= 0) System.out.println("Кількість записів має бути більше 0.");
        }
        while (n <= 0);

        Book[] books = new Book[n];
        System.out.println("Введення книг:");
        for (int i = 0; i < books.length; i++)
        {
            System.out.println("Книга " + (i+1) + ":");
            Book book = new Book();
            book.Input();
            books[i] = book;
        }

        return books;
    }

    public static void Start() {
        Scanner in = new Scanner(System.in);
        String type;
        Book[] books = new Book[0];

        do {
            System.out.println("Оберіть тип введення даних: ");
            System.out.println("1 — автоматичне");
            System.out.println("2 — ввід з клавіатури");
            type = in.nextLine();

            switch (type) {
                case "1" -> books = AutoPutInfo();
                case "2" -> books = InputInfo();
            }

        } while(!(type.equals("1") || type.equals("2")));

        System.out.println("Таблиця з інформацією про книги: ");
        Book.PrintTable(books);
        System.out.println("Книги, згруповані за роками: ");
        Book.PrintTableGroupByYear(books);
    }
}
