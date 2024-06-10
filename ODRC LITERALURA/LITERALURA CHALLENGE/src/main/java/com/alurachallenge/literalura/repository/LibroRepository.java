package com.alurachallenge.literalura.repository;

import com.alurachallenge.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloContainingIgnoreCase (String nombreTitulo);
    @Query("SELECT l FROM Libro l WHERE :idioma = l.lenguajes")
    List<Libro> ListarLibrosPorIdioma(@Param("idioma") List<String> idioma);
    @Query("SELECT l FROM Libro l GROUP BY l.id ORDER BY MAX(l.numeroDeDescargas) DESC LIMIT :top")
    List<Libro> obtenerTop(Integer top);


}
