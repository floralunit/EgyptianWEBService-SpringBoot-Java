package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GodRepository extends JpaRepository<God, Integer> {
    List<God> findByNameContainingIgnoreCase(String name);
}
