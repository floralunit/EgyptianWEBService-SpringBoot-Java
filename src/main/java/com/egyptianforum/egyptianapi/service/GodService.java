package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.God;
import com.egyptianforum.egyptianapi.persistence.GodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GodService {

    private final GodRepository godRepository;

    @Autowired
    public GodService(GodRepository godRepository) {
        this.godRepository = godRepository;
    }

    public List<God> getAllGods() {
        return godRepository.findAll();
    }

    public List<God> searchByName(String name) {
        return godRepository.findByNameContainingIgnoreCase(name);
    }
}
