package com.egyptianforum.egyptianapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.egyptianforum.egyptianapi.persistence.*;
import com.egyptianforum.egyptianapi.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/phonograms")
public class PhonogramController {

    private final PhonogramService phonogramService;

    @Autowired
    public PhonogramController(PhonogramService phonogramService) {
        this.phonogramService = phonogramService;
    }

    @GetMapping(value = "/all")
    public List<Phonogram> getAllPhonograms() {
        return phonogramService.getAllPhonograms();
    }

    @GetMapping("find/{gardinerCode}")
    public List<Phonogram> getPhonogramByGardinerCode(@PathVariable String gardinerCode) {
        return phonogramService.getPhonogramByGardinerCode(gardinerCode);
    }
}
