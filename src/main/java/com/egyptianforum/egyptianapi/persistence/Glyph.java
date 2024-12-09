package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "glyph")
public class Glyph {

    @Id
    @Column(name = "glyph_unicode")
    private String glyphUnicode;

    @Column(name = "unicode_string")
    private String unicodeString;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "gardiner_code")
    private String gardinerCode;

    @Column(name = "description")
    private String description;

    @Column(name = "phonogram")
    private String phonogram;

    @Column(name = "transliteration")
    private String transliteration;

    @Column(name = "notes")
    private String notes;


    // Getters and Setters
    public String getGlyphUnicode() {
        return glyphUnicode;
    }

    public void setGlyphUnicode(String glyphUnicode) {
        this.glyphUnicode = glyphUnicode;
    }

    public String getUnicodeString() {
        return unicodeString;
    }

    public void setUnicodeString(String unicodeString) {
        this.unicodeString = unicodeString;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGardinerCode() {
        return gardinerCode;
    }

    public void setGardinerCode(String gardinerCode) {
        this.gardinerCode = gardinerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhonogram() {
        return phonogram;
    }

    public void setPhonogram(String phonogram) {
        this.phonogram = phonogram;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
