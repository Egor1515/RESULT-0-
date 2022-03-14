package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class RepositoryProduct {

    public Product[] products = new Product[0];
    public RepositoryProduct repository = new RepositoryProduct();
    public ProductManager manager = new ProductManager(repository);


    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public void removeById(int id) {
//        for (Product product : products)
//            if (manager.matchesInt(product, id)) {
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

