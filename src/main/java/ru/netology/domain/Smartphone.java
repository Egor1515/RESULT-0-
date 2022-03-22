package ru.netology.domain;

public class Smartphone extends Product {


    private String producer;

    public Smartphone(int id, String name, int cost, String producer) {
        super(id, name, cost);
        this.producer = producer;
    }

    public Smartphone(int id, String name, int cost) {
        super(id, name, cost);
    }

    public Smartphone(String producer) {
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Smartphone() {
    }

    public boolean matches(Product product, String search) {
        return producer.contains(search);
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (producer.contains(search)) {
            return true;
        }
        return false;
    }

}
