package com.alurachallenge.literalura.repository;

import com.alurachallenge.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a JOIN FETCH a.libros")
    List<Autor> ListarTodosLosAutores();
    @Query("SELECT a FROM Autor a JOIN FETCH a.libros WHERE SUBSTRING(a.fechaNacimiento, 1, 4) > :year")
    List<Autor> ListarAutoresPorAno(String year);
    @Query("SELECT a FROM Autor a JOIN FETCH a.libros WHERE a.nombre ILIKE %:nombre%")
    Optional<Autor> AutoresPorNombre(String nombre);
    @Query("SELECT a FROM Autor a JOIN FETCH a.libros WHERE SUBSTRING(a.fechaFallecimiento, 1, 4) > :year")
    List<Autor> ListarAutoresPorAnofallecimiento(String year);

}
