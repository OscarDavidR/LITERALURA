package com.alurachallenge.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaNacimiento;
    private String fechaFallecimiento;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaFallecimiento = datosAutor.fechaDeNacimiento();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("************************************\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Fecha De Nacimiento: ").append(fechaNacimiento).append("\n");
        sb.append("Fecha De Fallecimiento: ").append(fechaFallecimiento).append("\n");
        sb.append("Libro(s): ");
        if (!libros.isEmpty()) {
            for (int i = 0; i < libros.size() - 1; i++) {
                sb.append(libros.get(i).getTitulo()).append(", ");
            }
            sb.append(libros.get(libros.size() - 1).getTitulo());
        }
        sb.append("\n************************************\n");
        return sb.toString();
    }
}
