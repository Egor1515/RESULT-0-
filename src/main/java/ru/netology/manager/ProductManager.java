package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.RepositoryProduct;

public class ProductManager extends RepositoryProduct {


    public ProductManager() {
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : super.findAll()) {
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


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);


    }


}
