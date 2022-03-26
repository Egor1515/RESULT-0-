package ru.netology.repository;

import ru.netology.domain.Product;

public class RepositoryProduct {

    public Product[] products = new Product[0];

    public void add(Product product) {
        save(product);
    }

    public boolean matchesInt(Product product, int number) {
        return product.getId() == number;


    }

    public Product findById(int id) {
        for (Product product : findAll()) {
            if (matchesInt(product, id)) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) throws NotFoundException {

        if (findById(id) == null) {
            throw new NotFoundException("Нет Id");
        }
        int index = 0;
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        for (Product product : findAll()) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }


            products = tmp;


        }
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



