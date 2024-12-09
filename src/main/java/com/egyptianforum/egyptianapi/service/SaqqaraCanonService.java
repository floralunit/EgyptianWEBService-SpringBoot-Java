package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.SaqqaraCanon;
import com.egyptianforum.egyptianapi.persistence.SaqqaraCanonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaqqaraCanonService {

    @Autowired
    private SaqqaraCanonRepository saqqaraCanonRepository;

    public List<SaqqaraCanon> getAllSaqqaraCanons() {
        return saqqaraCanonRepository.findAll();
    }

    public List<SaqqaraCanon> searchByNameInList(String name) {
        return saqqaraCanonRepository.findByNameInListContaining(name);
    }
}

