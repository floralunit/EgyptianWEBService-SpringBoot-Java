package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.Categorium;
import com.egyptianforum.egyptianapi.service.CategoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriums")
public class CategoriumController {

    private final CategoriumService categoriumService;

    @Autowired
    public CategoriumController(CategoriumService categoriumService) {
        this.categoriumService = categoriumService;
    }

    @GetMapping("/all")
    public List<Categorium> getAllCategories() {
        return categoriumService.getAllCategories();
    }

    @GetMapping("/find")
    public List<Categorium> searchByCategoria(@RequestParam String categoria) {
        return categoriumService.findByCategoria(categoria);
    }
}
