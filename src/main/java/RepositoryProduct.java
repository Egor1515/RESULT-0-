public class RepositoryProduct {

    public Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product film : products) {
            if (film.getId() != id) {
                tmp[index] = film;
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

