package com.egyptianforum.egyptianapi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriumRepository extends JpaRepository<Categorium, String> {
    List<Categorium> findByCategoria(String categoria);
}
