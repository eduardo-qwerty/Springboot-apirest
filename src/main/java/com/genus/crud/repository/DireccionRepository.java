package com.genus.crud.repository;

import com.genus.crud.entity.Direccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    Page<Direccion> findByCalleContainingAllIgnoreCase(String calle, Pageable pageable);
}
