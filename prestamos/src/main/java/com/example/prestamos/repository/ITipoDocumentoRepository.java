package com.example.prestamos.repository;

import com.example.prestamos.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

    // este query esta atado a un método en java
    @Query("SELECT t FROM TipoDocumento t WHERE t.nombre=?1")
    ArrayList<TipoDocumento> findbyNombre(String nombre);

}
