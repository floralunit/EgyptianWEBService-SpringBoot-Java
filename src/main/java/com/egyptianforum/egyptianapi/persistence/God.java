package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "god")
public class God {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gardiner_code")
    private String gardinerCode;
    @Column(name = "hieroglyphic")
    private String hieroglyphic;
    @Column(name = "transliteration")
    private String transliteration;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "apperance")
    private String apperance;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGardinerCode() {
        return gardinerCode;
    }

    public void setGardinerCode(String gardinerCode) {
        this.gardinerCode = gardinerCode;
    }

    public String getHieroglyphic() {
        return hieroglyphic;
    }

    public void setHieroglyphic(String hieroglyphic) {
        this.hieroglyphic = hieroglyphic;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApperance() {
        return apperance;
    }

    public void setApperance(String apperance) {
        this.apperance = apperance;
    }
}
