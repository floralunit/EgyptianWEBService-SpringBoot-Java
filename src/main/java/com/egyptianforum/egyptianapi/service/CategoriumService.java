package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.Categorium;
import com.egyptianforum.egyptianapi.persistence.CategoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriumService {

    private final CategoriumRepository categoriumRepository;

    @Autowired
    public CategoriumService(CategoriumRepository categoriumRepository) {
        this.categoriumRepository = categoriumRepository;
    }

    public List<Categorium> getAllCategories() {
        return categoriumRepository.findAll();
    }

    public List<Categorium> findByCategoria(String categoria) {
        return categoriumRepository.findByCategoria(categoria);
    }
}
