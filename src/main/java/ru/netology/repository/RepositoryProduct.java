package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class RepositoryProduct {

    public RuntimeException ex = new RuntimeException();
    public Product[] products = new Product[0];
    private RepositoryProduct repository;
    public ProductManager manager = new ProductManager(null);


    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public void removeById(int id) throws NotFoundException {
        if (manager.findById(id) == null) {
            throw new NotFoundException("нет такого Id");
        }

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }

    }


    public Product[] findAll() {
        return products;
    }

    public RepositoryProduct(Product[] products) {
        this.products = products;
    }

    public RepositoryProduct() {
    }
}

