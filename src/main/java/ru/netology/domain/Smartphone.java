package ru.netology.domain;

import ru.netology.domain.Product;

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

    public Smartphone() {
    }
}