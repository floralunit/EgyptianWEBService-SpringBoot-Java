package com.egyptianforum.egyptianapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egyptianforum.egyptianapi.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PhonogramService {

    private final PhonogramRepository phonogramRepository;

    @Autowired
    public PhonogramService(PhonogramRepository phonogramRepository) {
        this.phonogramRepository = phonogramRepository;
    }

    public List<Phonogram> getAllPhonograms() {
        List<Phonogram> phonograms = phonogramRepository.findAll();
        System.out.println("Полученные фонограммы: " + phonograms);
        return phonograms;
    }

    public List<Phonogram> getPhonogramByGardinerCode(String gardinerCode) {
        List<Phonogram> foundPhonogram = phonogramRepository.findByGardinerCode(gardinerCode);
        return foundPhonogram;
    }
}
