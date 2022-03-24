package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.RepositoryProduct;

public class ProductManager {


    public RepositoryProduct repository;
    Book book = new Book();
    Smartphone smart = new Smartphone();

    public ProductManager(RepositoryProduct repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchByBook(String search) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (book.matches(search)) {
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
        for (Product product : repository.findAll()) {
            if (smart.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;

            }
        }
        return result;
    }


}


