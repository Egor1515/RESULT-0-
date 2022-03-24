import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    public RepositoryProduct repository = new RepositoryProduct();
    public ProductManager manager = new ProductManager();
    public Book book = new Book();
    public Smartphone smart = new Smartphone();
    Product first = new Product(1, "ABC", 1111);
    Product second = new Product(2, "ABC", 111);
    Product third = new Product(3, "ABC", 11);
    Product forth = new Product(4, "KLM", 100);
    Book Hello = new Book(1, "Book", 100, "Bondar");



    @Test
    void shouldBook() {

        repository.save(Hello);
        repository.findAll();
        Product[] expected = {Hello};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);

    }
    @Test

    void shouldSearchBy(){
        manager.save(first);
        manager.save(second);
        manager.save(third);
        Product[] expected ={Hello};
        Product[] actual = manager.searchByBook("Bondar");
        assertArrayEquals(expected,actual);
    }


}
