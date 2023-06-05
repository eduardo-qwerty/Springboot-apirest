package com.genus.crud.repository;

import com.genus.crud.entity.CuentasBancarias;
import com.genus.crud.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasBancariasRepository extends JpaRepository<CuentasBancarias, Long> {
}
