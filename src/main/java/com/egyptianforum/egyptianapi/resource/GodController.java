package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.God;
import com.egyptianforum.egyptianapi.service.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gods")
public class GodController {

    private final GodService godService;

    @Autowired
    public GodController(GodService godService) {
        this.godService = godService;
    }

    @GetMapping("/all")
    public List<God> getAllGods() {
        return godService.getAllGods();
    }

    @GetMapping("/find")
    public List<God> searchByName(@RequestParam String name) {
        return godService.searchByName(name);
    }
}
