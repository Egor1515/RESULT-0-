package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.NotFoundException;

public class ProductManager {


    public Product[] products = new Product[0];

    public ProductManager(Object o) {
    }

    public void add(Product product) {
        save(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
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


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);


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
