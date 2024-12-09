package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phonogram")
public class Phonogram {

    public Phonogram (){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "glyph")
    private String glyph;

    @Column(name = "gardiner_code")
    private String gardinerCode;

    @Column(name = "transliteration")
    private String transliteration;

    @Column(name = "manuel_cotage")
    private String manuelCotage;

    @Column(name = "type")
    private String type;

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGlyph() {
        return glyph;
    }

    public void setGlyph(String glyph) {
        this.glyph = glyph;
    }

    public String getGardinerCode() {
        return gardinerCode;
    }

    public void setGardinerCode(String gardinerCode) {
        this.gardinerCode = gardinerCode;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getManuelCotage() {
        return manuelCotage;
    }

    public void setManuelCotage(String manuelCotage) {
        this.manuelCotage = manuelCotage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phonogram{" +
                "id=" + id +
                ", glyph='" + glyph  + "}";
    }
}