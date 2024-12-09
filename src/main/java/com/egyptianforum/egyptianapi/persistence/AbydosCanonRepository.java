package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbydosCanonRepository extends JpaRepository<AbydosCanon, String> {
    List<AbydosCanon> findByNameInListContaining(String name);
}
