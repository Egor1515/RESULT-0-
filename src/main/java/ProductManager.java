import java.util.Arrays;

public class ProductManager {


    public RepositoryProduct repository = new RepositoryProduct();
    public Product[] products = new Product[0];

    public ProductManager(RepositoryProduct repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String text) {

        Product[] result = new Product[repository.findAll().length];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result[0] = product;
            }

        }
        return result;
    }


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);

    }
}