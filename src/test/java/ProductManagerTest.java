import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    public RepositoryProduct repository = new RepositoryProduct();

    public ProductManager manager = new ProductManager(repository);

    Product first = new Product(1, "ABC", 1111);
    Product second = new Product(2, "ABC", 111);
    Product third = new Product(3, "ABC", 11);
    Product forth = new Product(4, "KLM", 100);


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
        boolean expected = true;

        assertEquals(expected, actual);

    }

    @Test
    void shouldAdd() {

        manager.add(first);

        Product[] expected = {first};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveById() {


        repository.save(forth);
        repository.save(third);
        repository.removeById(3);

        Product[] expected = {forth};
        assertArrayEquals(expected, repository.findAll());

    }

    @Test
    void shouldSearchByText() {


        repository.save(first);
        repository.save(second);
        repository.save(third);


        Product[] expected = {first,second,third};
        Product[] actual = manager.searchBy("ABC");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextFault() {


        repository.save(first);

        Product[] expected = {null};
        Product[] actual = manager.searchBy("DEF");

        assertArrayEquals(expected, actual);


    }

  @Test
  void shouldFindById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product expected = first;
        Product actual = manager.findById(1);


      assertEquals(expected,actual);
    }
    @Test
    void shouldFindByIdNone() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);

        repository.save(first);
        repository.save(second);
        repository.save(third);


        Product actual = manager.findById(1);


        assertNull(actual);
    }
    @Test
    void shouldFindByIdMany() {
        Product first = new Product(2, "ABC", 1111);
        Product second = new Product(2, "ABC", 111);

        repository.save(first);
        repository.save(second);



        Product actual = manager.findById(2);


        assertEquals(first,actual);
    }

}
