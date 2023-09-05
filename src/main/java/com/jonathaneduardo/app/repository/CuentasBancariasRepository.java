package com.jonathaneduardo.app.repository;

import com.jonathaneduardo.app.entity.CuentasBancarias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasBancariasRepository extends JpaRepository<CuentasBancarias, Long> {
}
