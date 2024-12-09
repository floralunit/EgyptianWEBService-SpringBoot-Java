package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaqqaraCanonRepository extends JpaRepository<SaqqaraCanon, String> {
    List<SaqqaraCanon> findByNameInListContaining(String name);
}

