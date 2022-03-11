import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    RepositoryProduct repository = new RepositoryProduct();
    ProductManager manager = new ProductManager(repository);

    @Test
    void shouldCalc() {
        Product first = new Product(1, "BloodShot", 1111);
        Product second = new Product(2, "Forward", 111);
        Product third = new Product(3, "Belgrade Hotel", 11);
        Product forth = new Product(4, "Gentlemen", 100);

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);


        Product[] expected = {first, second, third, forth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    void ShouldCal() {
        Product first = new Product(1, "ABC", 1111);
        Product second = new Product(2, "DEF", 111);
        Product third = new Product(3, "HIJ", 11);
        Product forth = new Product(4, "KLM", 100);
        Product fifth = new Product(4, "KLM", 100);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.findAll();


        boolean expected = true;
        boolean actual = manager.matches(first, "ABC");
        assertEquals(expected, actual);


    }

    @Test
    void shouldAdd() {
        Product first = new Product(1, "ABC", 1111);
        Product second = new Product(2, "DEF", 111);
        Product third = new Product(3, "HIJ", 11);
        Product forth = new Product(4, "KLM", 100);

        manager.add(first);

        Product[] expected = {first};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveById() {
        Product first = new Product(1, "ABC", 1111);
        Product second = new Product(2, "DEF", 111);
        Product third = new Product(3, "HIJ", 11);
        Product forth = new Product(4, "KLM", 100);
        repository.save(forth);
        repository.save(third);
        repository.removeById(3);

        Product[] expected = {forth};
        assertArrayEquals(expected, repository.findAll());

    }

    @Test
    void shouldSearchByText() {
        Product first = new Product(1, "ABC", 1111);
        repository.save(first);

        Product[] expected = {first};
        Product[] actual = manager.searchBy("ABC");

        assertArrayEquals(expected, actual);


    }
    @Test
    void shouldSearchByTextFault() {
        Product first = new Product(1, "ABC", 1111);


        repository.save(first);

        Product[] expected = {null};
        Product[] actual = manager.searchBy("DEF");

        assertArrayEquals(expected, actual);


}
}
