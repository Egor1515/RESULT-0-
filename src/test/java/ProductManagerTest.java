import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    public RepositoryProduct repository = new RepositoryProduct();
    public ProductManager manager = new ProductManager(repository);

    Product Hello = new Book(1, "Book", 100, "Bondar");
    Product Bye = new Book(2, "Book", 100, "Bondar");
    Product SmartOne = new Smartphone(1, "NY", 1000, "Sony");
    Product SmartTwo = new Smartphone(2, "NY", 1100, "Sony");


    @Test
    void shouldBook() {

        repository.save(Hello);
        repository.findAll();
        Product[] expected = {Hello};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByBook() {
        repository.save(Hello);

        Product[] expected = {Hello};
        Product[] actual = manager.searchByBook("Bondar");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookNone() {
        repository.save(Hello);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchByBook("Sony");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByBookMany() {
        repository.save(Hello);
        repository.save(Bye);

        Product[] expected = {Hello,Bye};
        Product[] actual = manager.searchByBook("Bondar");


        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySmart() {
        repository.save(SmartOne);

        Product[] expected = {SmartOne};
        Product[] actual =manager.searchBySmart("Sony");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartNone() {
        repository.save(SmartOne);


        Product[] expected = new Product[0];
        Product[] actual = manager.searchBySmart("qweqweondar");

        assertArrayEquals(expected, actual);


    }
    @Test

    void shouldFindMany(){
        repository.save(SmartOne);
        repository.save(SmartTwo);
        Product[] expected = {SmartOne,SmartTwo};
        Product[] actual = manager.searchBySmart("Sony");

        assertArrayEquals(expected, actual);
    }
}
