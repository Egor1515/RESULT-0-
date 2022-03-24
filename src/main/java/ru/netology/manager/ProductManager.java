package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {


    public Product[] products = new Product[0];
    Book book = new Book();
    Smartphone smart = new Smartphone();

    public void add(Product product) {
        save(product);
    }


    public Product[] searchByBook(String search) {
        Product[] result = new Product[0];
        for (Product product : findAll()) {
            if (book.matchesBook(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    public Product[] searchBySmart(String search) {
        Product[] result = new Product[0];
        for (Product product : findAll()) {
            if (matchesSmart(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matchesBook(String search) {
        return book.matchesBook(search);
    }

    public boolean matchesSmart( String search) {
        return smart.matchesSmart(search);

    }

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public Product[] findAll() {
        return products;
    }


}
