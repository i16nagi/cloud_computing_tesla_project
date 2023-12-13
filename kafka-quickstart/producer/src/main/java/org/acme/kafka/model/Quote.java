package org.acme.kafka.model;

public class Quote {

    public String id;
    public Quote() { }

    public Quote(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "nom du vehicule='" + id + '}';
    }
}