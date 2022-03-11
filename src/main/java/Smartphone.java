public class Smartphone extends Product {

    private String name;
    private String producer;

    public Smartphone(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    public Smartphone() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
