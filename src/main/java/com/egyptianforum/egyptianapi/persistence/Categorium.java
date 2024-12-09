package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "categorium")
public class Categorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria")
    private String categoria;

    @Column(name = "Amount")
    private Short amount;

    @Column(name = "Name")
    private String name;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
