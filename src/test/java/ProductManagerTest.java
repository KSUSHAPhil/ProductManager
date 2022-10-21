import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Book book1 = new Book(1, "Jungle", 4, "Pushkin");
    Smartphone smartphone1 = new Smartphone(2, "Samsung", 50, "Slava");
    Book book2 = new Book(2, "Clans", 4, "Gogol");

    @Test
    public void shouldFindAllElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("s");
        Product[] expected = {book1, smartphone1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2Elements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("a");
        Product[] expected = {smartphone1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindManufacturer() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Slava");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Clans");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);
    }
}
