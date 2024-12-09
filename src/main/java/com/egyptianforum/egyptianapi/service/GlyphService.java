package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.Glyph;
import com.egyptianforum.egyptianapi.persistence.GlyphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlyphService {

    @Autowired
    private GlyphRepository glyphRepository;

    public List<Glyph> getAllGlyphs() {
        return glyphRepository.findAll();
    }

    public List<Glyph> searchByGardinerCode(String gardinerCode) {
        return glyphRepository.findByGardinerCodeContaining(gardinerCode);
    }
}
