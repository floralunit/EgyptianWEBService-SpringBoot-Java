package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlyphRepository extends JpaRepository<Glyph, String> {
    List<Glyph> findByGardinerCodeContaining(String gardinerCode);
}
