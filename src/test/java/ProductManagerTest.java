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
    public Book book = new Book();
    public Smartphone smart = new Smartphone();
    Product first = new Product(1, "ABC", 1111);
    Product second = new Product(2, "ABC", 111);
    Product third = new Product(3, "ABC", 11);
    Product forth = new Product(4, "KLM", 100);
    private Book coreJava = new Book(1, "Book", 100, "Bondar");


    @Test
    void shouldDisplay() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        Product[] expected = {first, second, third, forth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldMatch() {

        repository.save(first);
        boolean actual = manager.matches(first, "ABC");
        assertTrue(actual);

    }

    @Test
    void shouldAdd() {
        manager.add(first);
        Product[] expected = {first};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSearchByText() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        Product[] expected = {first, second, third};
        Product[] actual = manager.searchBy("ABC");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextNull() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] actual = manager.searchBy("Abc");
        assertArrayEquals(new Product[0], actual);
    }


    @Test
    void shouldFindById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        Product expected = first;
        Product actual = repository.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNone() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        Product actual = repository.findById(1);
        assertNull(actual);
    }

    @Test
    void shouldFindByIdMany() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        repository.save(first);
        repository.save(second);
        Product actual = repository.findById(2);
        assertEquals(first, actual);
    }

    @Test
    void shouldBook() {

        repository.save(coreJava);
        repository.findAll();
        Product[] expected = {coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);

    }


}
