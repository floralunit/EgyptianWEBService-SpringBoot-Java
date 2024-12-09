package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.Glyph;
import com.egyptianforum.egyptianapi.service.GlyphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/glyphs")
public class GlyphController {

    @Autowired
    private GlyphService glyphService;

    @GetMapping("/all")
    public List<Glyph> getAllGlyphs() {
        return glyphService.getAllGlyphs();
    }

    @GetMapping("/find/")
    public List<Glyph> searchByGardinerCode(@RequestParam String gardinerCode) {
        return glyphService.searchByGardinerCode(gardinerCode);
    }
}
