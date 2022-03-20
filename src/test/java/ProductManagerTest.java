import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;
import ru.netology.repository.NotFoundException;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    public ProductManager manager = new ProductManager(null);
    Product first = new Product(1, "ABC", 1111);
    Product second = new Product(2, "ABC", 111);
    Product third = new Product(3, "ABC", 11);
    Product forth = new Product(4, "KLM", 100);


    @Test
    void shouldDisplay() {


        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(forth);
        Product[] expected = {first, second, third, forth};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldMatch() {

        manager.save(first);
        boolean actual = manager.matches(first, "ABC");
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    void shouldAdd() {
        manager.add(first);
        Product[] expected = {first};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldRemoveById() throws NotFoundException {
        manager.save(forth);
        manager.save(third);
        manager.save(second);
        manager.removeById(2);

        Product[] expected = {forth, third};
        assertArrayEquals(expected, manager.findAll());

    }


    @Test
    void shouldSearchByText() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        Product[] expected = {first, second, third};
        Product[] actual = manager.searchBy("ABC");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindById() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        Product expected = first;
        Product actual = manager.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNone() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        Product actual = manager.findById(1);
        assertNull(actual);
    }

    @Test
    void shouldFindByIdMany() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        manager.save(first);
        manager.save(second);
        Product actual = manager.findById(2);
        assertEquals(first, actual);
    }

    @Test
    void shouldThrowException() {
        Product first = new Product(1, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        manager.save(first);
        manager.save(second);

        Assertions.assertThrows(NotFoundException.class, () -> manager.removeById(3));

    }

    @Test
    void shouldNotThrowException() {
        Product first = new Product(1, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);
        manager.save(first);
        manager.save(second);

        Assertions.assertThrows(NotFoundException.class, () -> manager.removeById(3));

    }


}
