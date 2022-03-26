import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    public RepositoryProduct repository = new RepositoryProduct();
    public ProductManager manager = new ProductManager(repository);

    Product product = new Product();

    Product book = new Book(1, "Book", 100, "Bondar");
    Product book1 = new Book(2, "Book", 100, "Bondar");
    Product smart = new Smartphone(1, "NY", 1000, "Sony");
    Product smart1 = new Smartphone(2, "NY", 1100, "Sony");


    @Test
    void shouldBook() {

        repository.save(book);
        repository.findAll();
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByBook() {
        repository.save(book);

        Product[] expected = {book};
        Product[] actual = manager.searchBy("Bondar");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookNone() {
        repository.save(book);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Sony");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByBookMany() {
        repository.save(book);
        repository.save(book1);

        Product[] expected = {book,book1};
        Product[] actual = manager.searchBy("Bondar");


        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySmart() {
        repository.save(smart);

        Product[] expected = {smart};
        Product[] actual =manager.searchBy("Sony");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartNone() {
        repository.save(smart);


        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("qweqweondar");

        assertArrayEquals(expected, actual);


    }
    @Test

    void shouldFindMany(){
        repository.save(smart);
        repository.save(smart1);
        Product[] expected = {smart,smart1};
        Product[] actual = manager.searchBy("Sony");

        assertArrayEquals(expected, actual);
    }
    @Test

    void shouldMatchBook(){

        repository.save(book);

        assertTrue(book.matches("Bondar"));
    }
    @Test

    void shouldMatchBookNone(){

        repository.save(book);

        assertFalse(book.matches("sondar"));
    }
    @Test

    void shouldMatchSmart(){

        repository.save(smart1);

        assertTrue(smart.matches("Sony"));
    }
    @Test

    void shouldMatchSmartNone(){

        repository.save(smart1);


        assertFalse(smart.matches("ONE"));
    }
}
