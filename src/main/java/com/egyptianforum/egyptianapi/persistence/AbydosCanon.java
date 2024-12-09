package com.egyptianforum.egyptianapi.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "abydos_canon")
public class AbydosCanon {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name_in_list")
    private String nameInList;

    @Column(name = "transliteration")
    private String transliteration;

    @Column(name = "pharaoh_name")
    private String pharaohName;

    @Column(name = "wiki_link")
    private String wikiLink;

    @Column(name = "english_pharaoh_name")
    private String englishPharaohName;

    @Column(name = "pharaoh_se_link")
    private String pharaohSeLink;

    @Column(name = "dynasty")
    private String dynasty;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameInList() {
        return nameInList;
    }

    public void setNameInList(String nameInList) {
        this.nameInList = nameInList;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getPharaohName() {
        return pharaohName;
    }

    public void setPharaohName(String pharaohName) {
        this.pharaohName = pharaohName;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getEnglishPharaohName() {
        return englishPharaohName;
    }

    public void setEnglishPharaohName(String englishPharaohName) {
        this.englishPharaohName = englishPharaohName;
    }

    public String getPharaohSeLink() {
        return pharaohSeLink;
    }

    public void setPharaohSeLink(String pharaohSeLink) {
        this.pharaohSeLink = pharaohSeLink;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }
}
