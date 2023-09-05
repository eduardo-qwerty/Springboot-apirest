package com.jonathaneduardo.app.repository;

import com.jonathaneduardo.app.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Page<Persona> findByApellidoContainingAllIgnoreCase(String apellido, Pageable pageable);
    Page<Persona> findByNombreContainingAllIgnoreCase(String nombre, Pageable pageable);
    Page<Persona> findByApellidoAndNombreContainingAllIgnoreCase(String apellido, String nombre, Pageable pageable);
    // Recomendado, left join, inner join (repasar sql)
    @Query("SELECT persona FROM Persona persona JOIN persona.listaDirecciones direcciones WHERE direcciones.calle LIKE %:calle%")
    Page<Persona> findByCalle(@Param("calle") String calle, Pageable pageable);
    // Otra alternativa:
    Page<Persona> findByListaDireccionesCalleContainingAllIgnoreCase(String calle, Pageable pageable);
    @Query("SELECT persona FROM Persona persona JOIN persona.listaCuentasBancarias cuentas WHERE cuentas.bancoAsociado LIKE %:banco%")
    Page<Persona> findByBanco(@Param("banco") String banco, Pageable pageable);

    Page<Persona> findBylistaCuentasBancariasBancoAsociadoContainingAllIgnoreCase(String banco,Pageable pageable );
    @Query("SELECT p FROM Persona p JOIN p.perfil perf WHERE perf.usuario LIKE %:usuario%")
    Page<Persona> findByUsuario(@Param("usuario") String usuario, Pageable pageable);
}
