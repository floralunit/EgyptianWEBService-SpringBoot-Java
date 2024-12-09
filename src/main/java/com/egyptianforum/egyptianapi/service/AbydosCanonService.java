package com.egyptianforum.egyptianapi.service;

import com.egyptianforum.egyptianapi.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbydosCanonService {

    @Autowired
    private AbydosCanonRepository abydosCanonRepository;

    public List<AbydosCanon> getAllAbydosCanons() {
        return abydosCanonRepository.findAll();
    }

    public List<AbydosCanon> searchByNameInList(String name) {
        return abydosCanonRepository.findByNameInListContaining(name);
    }
}
